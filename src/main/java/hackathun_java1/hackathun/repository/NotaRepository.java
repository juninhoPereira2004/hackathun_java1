package hackathun_java1.hackathun.repository;

import hackathun_java1.hackathun.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
