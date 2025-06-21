package hackathun_java1.hackathun.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private LocalDate data;

    @ManyToOne
    private Turma turma;

    @ManyToOne
    private Disciplina disciplina;

    @OneToMany(mappedBy = "prova", cascade = CascadeType.ALL)
    private Set<Questao> questoes;
}