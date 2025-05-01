package gl2.example.todolistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService service;

    // GET /api/todos : Récupérer toutes les tâches
    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    // POST /api/todos : Ajouter une nouvelle tâche
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return service.addTodo(todo);
    }

    // DELETE /api/todos/{id} : Supprimer une tâche
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    // PATCH /api/todos/{id}/complete : Marquer comme terminée
    @PatchMapping("/{id}/complete")
    public Todo markAsCompleted(@PathVariable Long id) {
        return service.markAsCompleted(id);
    }
}