package com.nemo.modul9homework7.service;

import com.nemo.modul9homework7.entity.Todo;
import com.nemo.modul9homework7.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 8,20 * * *")
    public void sendPendingTodos() {
        List<Todo> pendingTodos = todoRepository.findByCompletedFalse();

        if (!pendingTodos.isEmpty()) {
            try {
                emailService.sendTodoReminder(pendingTodos);
            } catch (Exception e) {
                e.printStackTrace(); // handle the exception appropriately
            }
        }
    }
}

