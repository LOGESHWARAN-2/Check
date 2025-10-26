package com.example.Check.service;

import com.example.Check.entity.Task;
import com.example.Check.entity.Role;
import com.example.Check.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final NotificationService notificationService; // ✅ Add this

    public TaskService(TaskRepository taskRepository, NotificationService notificationService) {
        this.taskRepository = taskRepository;
        this.notificationService = notificationService; // ✅ Inject NotificationService
    }

    public Task createTask(Task task) {
        Task savedTask = taskRepository.save(task);

        // ✅ Auto-create notification for employee
        String message = "New task assigned: " + task.getTitle();
        notificationService.createNotification(message, Role.EMPLOYEE);

        return savedTask;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByEmployeeId(Long empId) {
        return taskRepository.findByAssignedEmployeeId(empId);
    }

    public Task updateTaskStatus(Long id, String status) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setStatus(Enum.valueOf(com.example.Check.entity.TaskStatus.class, status));
            Task updatedTask = taskRepository.save(task);

            // ✅ Auto-create notification for manager when task is completed
            if ("COMPLETED".equals(status)) {
                String message = "Task completed: " + task.getTitle() + " by " +
                        task.getAssignedEmployee().getName();
                notificationService.createNotification(message, Role.MANAGER);
            }

            return updatedTask;
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}