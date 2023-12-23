package link.wafflebox.api.user.repository;

import link.wafflebox.api.user.repository.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    UserEntity findByUserId(String userId);
}
