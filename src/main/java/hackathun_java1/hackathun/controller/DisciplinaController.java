package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.Disciplina;
import hackathun_java1.hackathun.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> listarDisciplinas() {
        return disciplinaService.listar();
    }

    @PostMapping
    public Disciplina criarDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaService.salvar(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizada) {
        Disciplina existente = disciplinaService.buscarPorId(id);
        existente.setNome(disciplinaAtualizada.getNome());
        return disciplinaService.salvar(existente);
    }

    @DeleteMapping("/{id}")
    public void deletarDisciplina(@PathVariable Long id) {
        disciplinaService.excluir(id);
    }
}