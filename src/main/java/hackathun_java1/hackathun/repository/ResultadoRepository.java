package hackathun_java1.hackathun.repository;

import hackathun_java1.hackathun.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
    List<Resultado> findByAlunoId(Long alunoId);
    List<Resultado> findByProvaId(Long provaId);
}
