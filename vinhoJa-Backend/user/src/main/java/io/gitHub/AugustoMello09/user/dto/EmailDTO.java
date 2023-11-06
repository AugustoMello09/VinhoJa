package io.gitHub.AugustoMello09.user.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class EmailDTO {

	private UUID idUser;
	
	private String emailTo;
}
