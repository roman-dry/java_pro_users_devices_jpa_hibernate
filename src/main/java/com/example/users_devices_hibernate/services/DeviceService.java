package com.example.users_devices_hibernate.services;

import com.example.users_devices_hibernate.models.Device;
import com.example.users_devices_hibernate.models.User;
import com.example.users_devices_hibernate.repositories.DeviceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Data
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
    public Device save(Device device) {
        device = deviceRepository.save(device);
        return device;
    }
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }
    public Device readDeviceById(int id) {
        return deviceRepository.readDeviceById(id);
    }
    @Transactional
    public void updateDeviceById(Device device, int id) {
        String name = device.getName();
        String mac_address = device.getMac_address();
        Integer user_id  = device.getUser_id();
        deviceRepository.updateDeviceById(name, mac_address, user_id, id);
    }
    public void deleteDeviceById(int id) {
        deviceRepository.deleteById(id);
    }

    public User getDevicesOfUser(Integer device_id) {
        Device device = readDeviceById(device_id);
        if(device != null) {
            return device.getUser();
        }
        return null;
    }


}
