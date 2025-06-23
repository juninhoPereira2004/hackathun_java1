// src/main/java/hackathun_java1/hackathun/dto/LoginResponse.java
package hackathun_java1.hackathun.dto;

// DTO para a resposta do login, indicando sucesso e uma mensagem
public class LoginResponse {
    private boolean success;
    private String message;
    // Em uma aplicação real, você poderia adicionar um token JWT aqui.

    // Construtor
    public LoginResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters (Setters não são estritamente necessários para DTOs de resposta,
    // mas podem ser adicionados se houver necessidade de manipulação após a criação)
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
