package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.Resultado;
import hackathun_java1.hackathun.service.ResultadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    private final ResultadoService resultadoService;

    public ResultadoController(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }

    @GetMapping
    public List<Resultado> listarTodos() {
        return resultadoService.listarTodos();
    }

    @GetMapping("/aluno/{idAluno}")
    public List<Resultado> listarResultadosPorAluno(@PathVariable Long idAluno) {
        return resultadoService.listarResultadosPorAluno(idAluno);
    }

    @GetMapping("/prova/{idProva}")
    public List<Resultado> listarResultadosPorProva(@PathVariable Long idProva) {
        return resultadoService.listarResultadosPorProva(idProva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultado> buscarPorId(@PathVariable Long id) {
        return resultadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resultado criar(@RequestBody Resultado resultado) {
        return resultadoService.salvar(resultado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultado> atualizar(@PathVariable Long id, @RequestBody Resultado resultado) {
        return resultadoService.atualizar(id, resultado)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletado = resultadoService.deletar(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}