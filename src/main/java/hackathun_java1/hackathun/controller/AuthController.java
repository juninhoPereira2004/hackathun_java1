// src/main/java/hackathun_java1/hackathun/controller/AuthController.java
package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.dto.LoginRequest;
import hackathun_java1.hackathun.dto.LoginResponse;
import hackathun_java1.hackathun.model.User;
import hackathun_java1.hackathun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login") // Define que este método responde a requisições POST para /api/auth/login
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Tenta autenticar o usuário usando o UserService
        User authenticatedUser = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (authenticatedUser != null) {
            // Se a autenticação foi bem-sucedida, retorna 200 OK com uma mensagem de sucesso
            return ResponseEntity.ok(new LoginResponse(true, "Login bem-sucedido!"));
        } else {
            // Se a autenticação falhou, retorna 401 UNAUTHORIZED com uma mensagem de erro
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(false, "Usuário ou senha inválidos."));
        }
    }

    // Você pode adicionar outros endpoints aqui, como registro de usuário.
    // @PostMapping("/register")
    // public ResponseEntity<LoginResponse> register(@RequestBody User user) {
    //     // ... lógica de registro ...
    // }
}
