package com.example.Check.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Check.entity.Task;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedEmployeeId(Long employeeId);
    List<Task> findByStatus(String status);
}
