package gl2.example.todolistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public Todo addTodo(Todo todo) {
        return repository.save(todo);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }

    public Todo markAsCompleted(Long id) {
        Optional<Todo> todo = repository.findById(id);
        if (todo.isPresent()) {
            todo.get().setCompleted(true);
            return repository.save(todo.get());
        }
        return null;
    }
}