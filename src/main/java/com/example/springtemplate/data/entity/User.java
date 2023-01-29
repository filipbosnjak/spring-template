package com.example.springtemplate.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", nullable = false)
    private UUID id;

    @Basic(optional = false)
    @Column(name = "username", nullable = false, length = 64)
    private String username;

    @Basic(optional = false)
    @NotNull
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
