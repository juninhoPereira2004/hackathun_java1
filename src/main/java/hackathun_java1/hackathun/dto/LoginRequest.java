// src/main/java/hackathun_java1/hackathun/dto/LoginRequest.java
package hackathun_java1.hackathun.dto;

// DTO para a requisição de login, contendo usuário e senha
public class LoginRequest {
    private String username;
    private String password;

    // Construtor padrão é necessário para desserialização JSON
    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
