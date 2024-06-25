package com.horizon.to_do_app.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "items")

public class Item implements Serializable {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private boolean done;

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    public Item() {
    }

    public Item(String name, String description, boolean done) {
        this.name = name;
        this.description = description;
        this.done = done;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

}