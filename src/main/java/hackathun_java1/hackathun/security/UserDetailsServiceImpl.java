package hackathun_java1.hackathun.security;

import hackathun_java1.hackathun.model.User;
import hackathun_java1.hackathun.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository repo) {
        this.userRepository = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(usernameOrEmail);

        if (userOptional.isEmpty()) {
            userOptional = userRepository.findByEmail(usernameOrEmail);
        }

        User user = userOptional.orElseThrow(() ->
                new UsernameNotFoundException("Usuário não encontrado com username ou email: " + usernameOrEmail));

        return new UserDetailsImpl(user);
    }
}
