package link.wafflebox.api.user.repository;

import link.wafflebox.api.user.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Class using memory for save and get user data. Use for test
 */
@Repository
public class MemoryUserRepository implements UserRepository {
    public UserEntity findByUserId(String userId) {
        return new UserEntity(1L, userId, "abcde", "chj7239");
    }
}
