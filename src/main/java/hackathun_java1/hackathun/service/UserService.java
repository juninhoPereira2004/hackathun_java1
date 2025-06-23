// src/main/java/hackathun_java1/hackathun/service/UserService.java
package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.model.User;
import hackathun_java1.hackathun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired // Injeta o repositório de usuários
    private UserRepository userRepository;

    /**
     * Tenta autenticar um usuário com base no nome de usuário e senha.
     * @param username O nome de usuário.
     * @param password A senha.
     * @return O objeto User se a autenticação for bem-sucedida, caso contrário, null.
     */
    public User authenticate(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        // Verifica se o usuário existe
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // TODO: MUITO IMPORTANTE! Em uma aplicação de produção, NUNCA compare senhas em texto puro.
            // Use um encoder de senhas (ex: BCryptPasswordEncoder do Spring Security) para comparar senhas hash.
            // Exemplo (com Spring Security): passwordEncoder.matches(password, user.getPassword())
            if (user.getPassword().equals(password)) { // Comparação simples para demonstração
                return user; // Autenticação bem-sucedida
            }
        }
        return null; // Usuário não encontrado ou senha inválida
    }

    /**
     * Salva um novo usuário no banco de dados.
     * @param user O objeto User a ser salvo.
     * @return O objeto User salvo.
     */
    public User registerUser(User user) {
        // TODO: Antes de salvar, a senha também deve ser hashed aqui.
        return userRepository.save(user);
    }
}
