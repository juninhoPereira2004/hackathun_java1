package hackathun_java1.hackathun.service;



import hackathun_java1.hackathun.model.Turma;
import hackathun_java1.hackathun.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    private final TurmaRepository repo;
    public TurmaService(TurmaRepository repo) { this.repo = repo; }

    public List<Turma> listar() { return repo.findAll(); }
    public Optional<Turma> buscarPorId(Long id) { return repo.findById(id); }
    public Turma salvar(Turma t) { return repo.save(t); }
    public void excluir(Long id) { repo.deleteById(id); }
}
