// Récupérer les tâches au démarrage
document.addEventListener('DOMContentLoaded', () => {
    fetchTodos();
});

// Ajouter une nouvelle tâche via formulaire
document.getElementById('todoForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;

    try {
        await axios.post('/api/todos', {
            title,
            description,
            completed: false
        });
        document.getElementById('title').value = '';
        document.getElementById('description').value = '';
        fetchTodos();
    } catch (error) {
        console.error('Erreur:', error);
    }
});

// Récupérer et afficher les tâches
async function fetchTodos() {
    try {
        const response = await axios.get('/api/todos');
        displayTodos(response.data);
    } catch (error) {
        console.error('Erreur:', error);
    }
}
    function displayTodos(todos) {
        const list = document.getElementById('todos');
        list.innerHTML = '';

        todos.forEach(todo => {
            const item = document.createElement('div');
            item.className = 'list-group-item d-flex justify-content-between';

            // Ajouter la classe 'todo-completed' si la tâche est terminée
            if (todo.completed) {
                item.classList.add('todo-completed');
            }

            item.innerHTML = `
            <span style="${todo.completed ? 'text-decoration: line-through' : ''}">${todo.title}</span>
            <div>
                <button class="btn btn-sm btn-success" onclick="markAsCompleted(${todo.id})">
                    ${todo.completed ? 'Terminée' : 'Terminer'}
                </button>
                <button class="btn btn-sm btn-danger" onclick="deleteTodo(${todo.id})">
                    Supprimer
                </button>
            </div>
        `;
            list.appendChild(item);
        });
    }

async function markAsCompleted(id) {
    try {
        await axios.patch(`/api/todos/${id}/complete`);
        fetchTodos(); // Actualise la liste pour refléter le changement
    } catch (error) {
        console.error('Erreur:', error);
    }
}
// Supprimer une tâche
async function deleteTodo(id) {
    try {
        await axios.delete(`/api/todos/${id}`);
        fetchTodos();
    } catch (error) {
        console.error('Erreur:', error);
    }
}

