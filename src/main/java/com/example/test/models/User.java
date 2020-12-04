package com.example.test.models;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = {"email"})
@Table(name = "users", schema = "public")
public class User{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "position")
    private String position;
    @Column(name = "phone")
    private Integer phone;
    @Column(name = "registration_date")
    private Date date;

    public User(String email, String password, String fullName, String position, Integer phone, Date date) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.position = position;
        this.phone = phone;
        this.date = date;
    }
}
