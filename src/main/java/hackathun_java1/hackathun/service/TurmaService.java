package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.model.Turma;
import hackathun_java1.hackathun.model.Usuario;
import hackathun_java1.hackathun.repository.TurmaRepository;
import hackathun_java1.hackathun.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final UsuarioRepository usuarioRepository;

    public TurmaService(TurmaRepository turmaRepository, UsuarioRepository usuarioRepository) {
        this.turmaRepository = turmaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Turma> listar() {
        return turmaRepository.findAll();
    }

    public Turma criar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Optional<Turma> buscarPorId(Long id) {
        return turmaRepository.findById(id);
    }

    public void excluir(Long id) {
        turmaRepository.deleteById(id);
    }

    public Turma associarAlunos(Long turmaId, Set<Long> idsAlunos) {
        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        Set<Usuario> alunos = usuarioRepository.findAllById(idsAlunos).stream().filter(u -> u.getPerfil() == Usuario.Perfil.ALUNO).collect(java.util.stream.Collectors.toSet());

        turma.setAlunos(alunos);

        return turmaRepository.save(turma);
    }
}