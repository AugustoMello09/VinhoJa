package io.gitHub.AugustoMello09.email.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import io.gitHub.AugustoMello09.email.entities.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "emailId")
@Entity
@Table(name = "tb_email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID emailId;
   
    private UUID userId;
    private String emailFrom;
    private String emailTo;
    private String subject;
    
    @Column(columnDefinition = "TEXT")
    private String text;
    
    private LocalDateTime sendDateEmail;
    
    private StatusEmail statusEmail;

}
