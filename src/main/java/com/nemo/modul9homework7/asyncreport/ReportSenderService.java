package com.nemo.modul9homework7.asyncreport;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ReportSenderService {

    @Async
    public void sendReport(String message)  {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Report is send");
    }
}
