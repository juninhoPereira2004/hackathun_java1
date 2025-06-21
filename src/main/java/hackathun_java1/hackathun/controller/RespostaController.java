package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping("/importar")
    public ResultadoProcessamento importarRespostas(@RequestBody RespostaImportacao importacao) {
        return respostaService.processarRespostas(importacao);
    }

    public static class RespostaImportacao {
        public Long idProva;
        public Long idAluno;
        public String[] respostas;
    }

    public static class ResultadoProcessamento {
        public double nota;
        public int acertos;
        public int erros;
    }
}
