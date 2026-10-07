package com.linkout.post.model;

import com.linkout.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3000, nullable = false)
    private String content;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;

    @Column(nullable = false, updatable = false)
    private LocalDateTime updateAt;

    @PrePersist
    void onCreate(){
        LocalDateTime agora = LocalDateTime.now();
        createAt = agora;
        updateAt = agora;
    }

    @PreUpdate
    void onUpdate(){
        updateAt = LocalDateTime.now();
    }
}
