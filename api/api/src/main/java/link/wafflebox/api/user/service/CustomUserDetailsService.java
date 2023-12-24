package link.wafflebox.api.user.service;

import link.wafflebox.api.user.repository.UserRepository;
import link.wafflebox.api.user.repository.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private  final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserId(userId);

        UserDetails userDetails = User.builder()
                .username(userEntity.getUserId())
                .password(userEntity.getHashedPassword())
                .roles(userEntity.getRole().getRoleName())
                .build();

        return userDetails;
    }
}
