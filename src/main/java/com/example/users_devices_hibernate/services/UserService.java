package com.example.users_devices_hibernate.services;

import com.example.users_devices_hibernate.models.Device;
import com.example.users_devices_hibernate.models.User;
import com.example.users_devices_hibernate.repositories.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Data
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User save(User user) {
        user = userRepository.save(user);
        return user;
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User readUserById(int id) {
        return userRepository.readUserById(id);
    }

    public void updateUserById(User user, int id) {
        String phone = user.getPhone();
        String name = user.getName();
        String lastname = user.getLastname();
        String gender = user.getGender();
        userRepository.updateUserById(phone, name, lastname, gender, id);
    }
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public  List<Device> getUserDevices(Integer user_id) {
        User user = readUserById(user_id);
        if(user != null) {
            return user.getDevices();
        }
        return null;
    }


}
