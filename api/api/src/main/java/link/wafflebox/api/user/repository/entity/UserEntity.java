package link.wafflebox.api.user.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    
    private String id;

    private String nickname;

    @Builder
    public UserEntity(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
