package hackathun_java1.hackathun.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Prova prova;
}
