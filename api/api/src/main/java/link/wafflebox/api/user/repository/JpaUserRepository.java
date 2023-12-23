package link.wafflebox.api.user.repository;

import link.wafflebox.api.user.repository.entity.UserEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public interface JpaUserRepository extends UserRepository, JpaRepository<UserEntity, Integer> {
    UserEntity findByUserId(String userId);
}
