package com.example.users_devices_hibernate.controllers;

import com.example.users_devices_hibernate.models.Device;
import com.example.users_devices_hibernate.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService deviceservice;

    @Autowired
    public DeviceController(DeviceService deviceservice) {
        this.deviceservice = deviceservice;
    }

    @GetMapping()
    public String readAllDevices(Model model) {
        model.addAttribute("devices", deviceservice.findAll());
        return "index1";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("device", deviceservice.readDeviceById(id));
        return "show1";
    }

    @GetMapping("/new")
    public String newDevice(Model model) {
        model.addAttribute("device", new Device());
        return "new1";
    }

    @PostMapping()
    public String create(@ModelAttribute("device") Device device) {
        deviceservice.save(device);
        return "redirect:/devices";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("device", deviceservice.readDeviceById(id));
        return "edit1";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("device") Device device, @PathVariable("id") int id) {
        deviceservice.updateDeviceById(device, id);
        return "redirect:/devices";
    }
    @DeleteMapping("/{id}")
    public  String delete(@PathVariable("id") int id) {
        deviceservice.deleteDeviceById(id);
        return "redirect:/devices";
    }

    @GetMapping("/{deviceId}/user")
    public String getDeviceUser(@PathVariable("deviceId")  Integer device_id, Model model) {
        model.addAttribute("user", deviceservice.getDevicesOfUser(device_id));
        return "show4";

    }
}

