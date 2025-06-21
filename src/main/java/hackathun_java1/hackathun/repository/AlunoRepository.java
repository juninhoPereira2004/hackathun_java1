package hackathun_java1.hackathun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hackathun_java1.hackathun.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
