package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.Prova;
import hackathun_java1.hackathun.model.Questao;
import hackathun_java1.hackathun.service.QuestaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    private final QuestaoService questaoService;

    public QuestaoController(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    @PostMapping
    public ResponseEntity<Questao> criarQuestao(@RequestBody Questao questao) {
        Questao criada = questaoService.criarQuestao(questao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> buscarPorId(@PathVariable Long id) {
        return questaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/prova/{provaId}")
    public ResponseEntity<List<Questao>> listarPorProva(@PathVariable Long provaId) {
        Prova prova = new Prova();
        prova.setId(provaId);
        List<Questao> questoes = questaoService.listarPorProva(prova);
        return ResponseEntity.ok(questoes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        questaoService.deletarQuestao(id);
        return ResponseEntity.noContent().build();
    }
}
