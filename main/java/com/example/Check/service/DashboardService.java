package com.example.Check.service;

import com.example.Check.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.example.Check.entity.Task;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final TaskRepository taskRepository;

    public DashboardService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Map<String, Long> getSummary() {
        List<Task> tasks = taskRepository.findAll();
        long total = tasks.size();
        long completed = tasks.stream().filter(t -> t.getStatus().name().equals("COMPLETED")).count();
        long pending = total - completed;

        Map<String, Long> summary = new HashMap<>();
        summary.put("totalTasks", total);
        summary.put("completedTasks", completed);
        summary.put("pendingTasks", pending);

        return summary;
    }
}
