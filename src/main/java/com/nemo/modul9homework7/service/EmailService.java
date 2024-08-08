package com.nemo.modul9homework7.service;

import com.nemo.modul9homework7.entity.Todo;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final FreeMarkerConfigurer freemarkerConfigurer;

    public void sendActivationEmail(String to, String profile) throws Exception {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject("Profile Activation");

        Template template = freemarkerConfigurer.getConfiguration().getTemplate("activation.ftl");

        Map<String, Object> model = new HashMap<>();
        model.put("profile", profile);

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        helper.setText(html, true);

        mailSender.send(message);
    }

    public void sendTodoReminder(List<Todo> pendingTodos) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo("recipient@example.com");  // Replace with actual recipient
            helper.setSubject("Pending TODOs Reminder");

            // Prepare the data model for Freemarker
            Map<String, Object> model = new HashMap<>();
            model.put("todos", pendingTodos);

            // Load and process the Freemarker template
            String templateContent = FreeMarkerTemplateUtils.processTemplateIntoString(
                    freemarkerConfigurer.getConfiguration().getTemplate("todoReminder.ftl"), model);

            // Set the HTML content
            helper.setText(templateContent, true);

            // Send the email
            mailSender.send(message);

            System.out.println("TODO reminder email sent successfully.");
        } catch (Exception e) {
            System.err.println("Error while sending TODO reminder email: " + e.getMessage());
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}

