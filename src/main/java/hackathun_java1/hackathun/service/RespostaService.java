package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.controller.RespostaController;
import hackathun_java1.hackathun.model.Prova;
import hackathun_java1.hackathun.model.Questao;
import hackathun_java1.hackathun.model.RespostaAluno;
import hackathun_java1.hackathun.model.User;
import hackathun_java1.hackathun.repository.ProvaRepository;
import hackathun_java1.hackathun.repository.RespostaAlunoRepository;
import hackathun_java1.hackathun.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RespostaService {

    private final RespostaAlunoRepository respostaAlunoRepository;
    private final ProvaRepository provaRepository;
    private final UserRepository usuarioRepository;

    public RespostaService(RespostaAlunoRepository respostaAlunoRepository,
                           ProvaRepository provaRepository,
                           UserRepository usuarioRepository) {
        this.respostaAlunoRepository = respostaAlunoRepository;
        this.provaRepository = provaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public RespostaController.ResultadoProcessamento processarRespostas(RespostaController.RespostaImportacao importacao) {
        Prova prova = provaRepository.findById(importacao.idProva)
                .orElseThrow(() -> new RuntimeException("Prova não encontrada"));
        User aluno = usuarioRepository.findById(importacao.idAluno)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        List<Questao> questoesOrdenadas = prova.getQuestoes().stream()
                .sorted(Comparator.comparingInt(Questao::getNumero))
                .toList();

        int acertos = 0;
        int erros = 0;

        for (int i = 0; i < questoesOrdenadas.size(); i++) {
            Questao questao = questoesOrdenadas.get(i);
            String respostaAluno = i < importacao.respostas.length ? importacao.respostas[i] : "";

            boolean correta = respostaAluno.equalsIgnoreCase(questao.getAlternativaCorreta());
            if (correta) acertos++;
            else erros++;

            RespostaAluno resposta = RespostaAluno.builder()
                    .aluno(aluno)
                    .questao(questao)
                    .resposta(respostaAluno)
                    .build();

            respostaAlunoRepository.save(resposta);
        }

        double nota = (double) acertos / questoesOrdenadas.size() * 10;

        RespostaController.ResultadoProcessamento resultado = new RespostaController.ResultadoProcessamento();
        resultado.acertos = acertos;
        resultado.erros = erros;
        resultado.nota = nota;

        return resultado;
    }
}
