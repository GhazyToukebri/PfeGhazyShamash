package tn.Shamash.Pfe.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class confirmationMailTokenEntity {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String token;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private User user;

    public confirmationMailTokenEntity(String token,
                                       LocalDateTime createdAt,
                                       LocalDateTime expiresAt,
                                       User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }

}