package gl2.example.todolistapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private boolean completed;

    // Date de création (automatique)
    @Column(name = "creation_date")
    private LocalDate creationDate;

    // Date de complétion (null si non terminée)
    @Column(name = "completed_date")
    private LocalDate completedDate;

    // Constructeurs
    public Todo() {
        this.creationDate = LocalDate.now(); // Date de création automatique
    }

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
        this.creationDate = LocalDate.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() { // Ou getCompleted()
        return completed;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
        if (completed) {
            this.completedDate = LocalDate.now(); // Date actuelle
        } else {
            this.completedDate = null; // Réinitialisation
        }
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}