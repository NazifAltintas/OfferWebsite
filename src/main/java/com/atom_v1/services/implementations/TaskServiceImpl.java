package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.OfferRepository;
import com.atom_v1.repository.TaskRepository;
import com.atom_v1.services.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;
    private OfferRepository offerRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, OfferRepository offerRepository) {
        this.taskRepository = taskRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            return taskRepository.findById(id).get();
        }
        return new Task();
    }

    @Override
    public Task getTaskByOfferId(Long id) {
        if (offerRepository.findById(id).isPresent()) {
            Offer offer = offerRepository.findById(id).get();
            return offer.getTask();
        }
        return new Task();
    }

    @Override
    public List<Task> getTasksByUserEmail(String email) {
        List<Task> tasks, taskList;
        taskList = new ArrayList<>();
        tasks = taskRepository.findAll();
        User user;
        for (Task task : tasks) {
            user = task.getUserDetails();
            if (user.getEmail().equalsIgnoreCase(email)) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    @Override
    public List<Task> getTasksByCategoryName(String name) {
        List<Task> tasks, taskList;
        taskList = new ArrayList<>();
        tasks = taskRepository.findAll();
        Category category;
        for (Task task : tasks) {
            category = task.getCategory();
            if (category.getCategoryName().equalsIgnoreCase(name)) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    @Override
    public List<Task> getTasksByLocationName(String name) {
        List<Task> tasks, taskList;
        taskList = new ArrayList<>();
        tasks = taskRepository.findAll();
        Location location;
        for (Task task : tasks) {
            location = task.getLocation();
            if (location.getLocationName().equalsIgnoreCase(name)) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    @Override
    public List<Task> findTasksByContext(String word) {
        List<Task> taskList = new ArrayList<>();
        List<Task> tasks = taskRepository.findAll();
        String taskContext;
        for (Task task : tasks) {
            taskContext = task.getDetails();
            if (!taskContext.isBlank() && taskContext.toLowerCase().contains(word.toLowerCase())) {
                taskList.add(task);
            }
        }
        return taskList;
    }

    @Override
    public String createTask(Task task) {
        taskRepository.save(task);
        if (taskRepository.existsById(task.getTaskId())) return "task is created successfully";
        return "task couldn't  be created";
    }

    @Override
    public String deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalStateException(id + " does not exist ");
        } else {
            taskRepository.deleteById(id);
            return "Task with id is " + id + " is successfully deleted";
        }
    }

    @Override
    public List<Task> sortTaskByDate() {
        List<Task> tasks = taskRepository.findAll();
        tasks.stream()
                .sorted(Comparator.comparing(Task::getTimeStamp))
                .collect(Collectors.toList());
        //Collections.reverse(blogs);
        return tasks;
    }

    @Override
    public List<Task> getTaskByPageNum(int num) {
        List<Task> tasks = taskRepository.findAll();
        List<Task> taskList = new ArrayList<>();
        int value = num * 12;
        int index1 = 0;

        if (num != 1) {
            index1 = value / num;
        }
        int index2 = index1 + 12;
        if (index2 >= tasks.size())
            index2 = tasks.size();
        return tasks.subList(index1, index2);
    }
}



