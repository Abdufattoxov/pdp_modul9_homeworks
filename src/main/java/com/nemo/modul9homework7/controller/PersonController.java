package com.nemo.modul9homework7.controller;

import com.nemo.modul9homework7.asyncreport.ReportSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PersonController {
    private final ReportSenderService reportSenderService;
    @GetMapping
    public String sayHello(){
         reportSenderService.sendReport("Hello");
         return "Report sented";
    }
}
