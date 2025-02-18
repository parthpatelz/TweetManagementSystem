package com.example.TweetManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tweets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tweetId;
    private String description;
    private LocalDateTime localDateTime;

    @JoinColumn(name = "userId")
    @ManyToOne
    @JsonBackReference
    private Person person;
}
