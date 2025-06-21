package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.Turma;
import hackathun_java1.hackathun.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Turma> listarTurmas() {
        return turmaService.listar();
    }

    @PostMapping
    public Turma criarTurma(@RequestBody Turma turma) {
        return turmaService.criar(turma);
    }

    @PutMapping("/{id}")
    public Turma atualizarTurma(@PathVariable Long id, @RequestBody Turma turma) {
        Turma existente = turmaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        existente.setNome(turma.getNome());
        existente.setProfessor(turma.getProfessor());
        return turmaService.criar(existente);
    }

    @DeleteMapping("/{id}")
    public void deletarTurma(@PathVariable Long id) {
        turmaService.excluir(id);
    }

    @PostMapping("/{id}/alunos")
    public Turma associarAlunos(@PathVariable Long id, @RequestBody Set<Long> idsAlunos) {
        return turmaService.associarAlunos(id, idsAlunos);
    }
}
