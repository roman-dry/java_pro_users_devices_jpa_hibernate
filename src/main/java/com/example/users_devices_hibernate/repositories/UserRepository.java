package com.example.users_devices_hibernate.repositories;

import com.example.users_devices_hibernate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Query("UPDATE User u SET u.phone = :phone, u.name = :name, u.lastname = :lastname, u.gender = :gender WHERE u.id = :id")
    void updateUserById(@Param("phone") String phone, @Param("name") String name,
                        @Param("lastname") String lastname, @Param("gender") String gender,
                        @Param("id") int id);


    @Query("from User u where u.id = :id ")
    User readUserById(@Param("id") int id);
}
