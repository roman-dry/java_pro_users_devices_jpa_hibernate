package com.example.users_devices_hibernate.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String phone;
    private String name;
    private String lastname;
    private String gender;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Device> devices;

}