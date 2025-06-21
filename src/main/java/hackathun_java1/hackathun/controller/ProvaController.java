package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.Prova;
import hackathun_java1.hackathun.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provas")
public class ProvaController {

    @Autowired
    private ProvaService provaService;

    @GetMapping
    public List<Prova> listarProvas() {
        return provaService.listar();
    }

    @PostMapping
    public Prova criarProva(@RequestBody Prova prova) {
        return provaService.salvar(prova);
    }

    @PutMapping("/{id}")
    public Prova atualizarProva(@PathVariable Long id, @RequestBody Prova provaAtualizada) {
        Prova provaExistente = provaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Prova não encontrada"));

        provaExistente.setTitulo(provaAtualizada.getTitulo());
        provaExistente.setData(provaAtualizada.getData());
        provaExistente.setTurma(provaAtualizada.getTurma());
        provaExistente.setDisciplina(provaAtualizada.getDisciplina());
        provaExistente.setQuestoes(provaAtualizada.getQuestoes());

        return provaService.salvar(provaExistente);
    }

    @DeleteMapping("/{id}")
    public void deletarProva(@PathVariable Long id) {
        provaService.excluir(id);
    }
}

