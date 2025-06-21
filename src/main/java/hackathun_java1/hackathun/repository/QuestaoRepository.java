package hackathun_java1.hackathun.repository;

import hackathun_java1.hackathun.model.Prova;
import hackathun_java1.hackathun.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    List<Questao> findByProva(Prova prova);
}