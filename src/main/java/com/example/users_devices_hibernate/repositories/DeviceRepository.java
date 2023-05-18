package com.example.users_devices_hibernate.repositories;

import com.example.users_devices_hibernate.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    @Modifying
    @Query("UPDATE Device d SET d.name = :name, d.mac_address = :mac_address, d.user_id = :user_id WHERE d.id = :id")
    void updateDeviceById(@Param("name") String name, @Param("mac_address") String mac_address,
                        @Param("user_id") Integer user_id, @Param("id") int id);


    @Query("from Device d where d.id = :id ")
    Device readDeviceById(@Param("id") int id);
}
