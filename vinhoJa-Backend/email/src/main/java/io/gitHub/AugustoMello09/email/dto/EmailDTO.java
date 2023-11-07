package io.gitHub.AugustoMello09.email.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class EmailDTO {

	private UUID userId;
	private String emailTo;
	private String subject;
	private String text;
}
