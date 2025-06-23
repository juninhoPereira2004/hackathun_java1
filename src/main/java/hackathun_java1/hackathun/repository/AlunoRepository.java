package hackathun_java1.hackathun.repository;

import hackathun_java1.hackathun.model.Aluno;
import hackathun_java1.hackathun.model.User; // Se Aluno referencia User diretamente
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}