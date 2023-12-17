package link.wafflebox.api.user.service;

import link.wafflebox.api.user.dto.User;
import link.wafflebox.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(new User(user.getNo(), user.getId(), user.getNickname())));
        return users;
    }


}
