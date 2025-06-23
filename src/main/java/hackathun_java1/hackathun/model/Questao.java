package hackathun_java1.hackathun.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enunciado;

    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;

    private String alternativaCorreta;

    private int numero; // posição da questão na prova

    @ManyToOne
    @JoinColumn(name = "prova_id")
    private Prova prova;
}
