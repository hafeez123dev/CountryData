package com.psoft.SpringProject1.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.psoft.SpringProject1.service.Service1;

@Component
public class EmailScheduler {

	@Autowired
	private Service1 emailService;

    @Scheduled(fixedRate = 60000) // 300000 ms = 5 minutes
    public void sendScheduledEmail() {
        emailService.sendEmail("mdabdulhafeez012@gmail.com");
        System.out.println("Scheduled email sent.");
    }
}
