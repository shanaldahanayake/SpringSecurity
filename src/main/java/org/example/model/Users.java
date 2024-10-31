package org.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name = "users")
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
}
