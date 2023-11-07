package io.gitHub.AugustoMello09.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.gitHub.AugustoMello09.email.entities.Email;
import io.gitHub.AugustoMello09.email.entities.enums.StatusEmail;
import io.gitHub.AugustoMello09.email.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository repository;

	@Autowired
	private JavaMailSender emailSender;

	@Value(value = "${spring.mail.username}")
	private String emailFrom;

	@Transactional
	public Email sendEmail(Email emailModel) {
		try {
			emailModel.setSendDateEmail(LocalDateTime.now());
			emailModel.setEmailFrom(emailFrom);
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			emailSender.send(message);
			emailModel.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERROR);
		} finally {
			repository.save(emailModel);
		}
		return emailModel;
	}

}
