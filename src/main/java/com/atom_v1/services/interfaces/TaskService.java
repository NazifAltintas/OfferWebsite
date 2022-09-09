package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task getTaskByOfferId(Long id);

    List<Task> getTasksByUserEmail(String email);

    List<Task> getTasksByCategoryName(String name);

    List<Task> getTasksByLocationName(String name);

    List<Task> findTasksByContext(String word);

    String createTask(Task task);

    String deleteTask(Long id);

    List<Task> sortTaskByDate();

    List<Task> getTaskByPageNum(int num);
}
