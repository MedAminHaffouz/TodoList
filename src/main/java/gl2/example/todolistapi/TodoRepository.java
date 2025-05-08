package gl2.example.todolistapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Nombre de tâches créées aujourd'hui
    long countByCreationDate(LocalDate today);

    // Nombre de tâches terminées aujourd'hui
    long countByCompletedDate(LocalDate today);

    // Nombre total de tâches créées
    long countAllBy();

    // Pourcentage de complétion quotidien
    default double getDailyCompletionRate() {
        LocalDate today = LocalDate.now();
        long createdToday = countByCreationDate(today);
        long completedToday = countByCompletedDate(today);
        return (createdToday == 0) ? 0 : (completedToday * 100.0) / createdToday;
    }
}