package hackathun_java1.hackathun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private String enunciado;

    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;

    private String respostaCorreta;

    @ManyToOne
    private Prova prova;
}
