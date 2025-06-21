package hackathun_java1.hackathun.config;

import hackathun_java1.hackathun.model.User;
import hackathun_java1.hackathun.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRole("ADMIN");
                userRepository.save(admin);

                User professor = new User();
                professor.setUsername("professor");
                professor.setEmail("professor@example.com");
                professor.setPassword(encoder.encode("prof123"));
                professor.setRole("PROFESSOR");
                userRepository.save(professor);

                User aluno = new User();
                aluno.setUsername("aluno");
                aluno.setEmail("aluno@example.com");
                aluno.setPassword(encoder.encode("aluno123"));
                aluno.setRole("ALUNO");
                userRepository.save(aluno);
            }
        };
    }
}
