package link.wafflebox.api.user.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @Column(name="userId", unique = true)
    private String userId;
    @Column(name="hashed_password")
    private String hashedPassword;
    @Column(name="nickname")
    private String nickname;

    @Builder
    public UserEntity(String userId, String hashedPassword, String nickname) {
        this.userId = userId;
        this.hashedPassword = hashedPassword;
        this.nickname = nickname;
    }
}
