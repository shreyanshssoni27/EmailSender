package com.aditya.emailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.emailservice.model.Mail;
import com.aditya.emailservice.service.MailService;

@RestController
public class EmailController {

	@Autowired
	MailService mailService;

	@PostMapping("/sendmail")
	public void sendEmail(@RequestParam String mailTo, @RequestParam String subject,@RequestParam String Content) {
		System.out.println(mailTo  +  subject + Content);
		Mail mail = new Mail();
		mail.setMailFrom("shreyanshjava2711@gmail.com");
		mail.setMailTo(mailTo);
		mail.setMailSubject(subject);
		mail.setMailContent(Content);
		try {
			mailService.sendEmail(mail);
		} catch (Exception e) {
			System.out.println("error occured while sending email" + e.getMessage());
		}

	}

}
