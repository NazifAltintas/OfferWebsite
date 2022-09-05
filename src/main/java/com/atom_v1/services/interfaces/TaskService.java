package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task getTaskByOffer(Offer offer);

    List<Task> getTasksByUser(User user);

    List<Task> getTasksByCategory(Category category);

    List<Task> getTasksByLocation(Location location);

    void createAddress(Address address);

    void deleteAddress(Address address);
}
