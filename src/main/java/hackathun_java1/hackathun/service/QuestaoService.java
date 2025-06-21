package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.model.Prova;
import hackathun_java1.hackathun.model.Questao;
import hackathun_java1.hackathun.repository.QuestaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {

    private final QuestaoRepository questaoRepository;

    public QuestaoService(QuestaoRepository questaoRepository) {
        this.questaoRepository = questaoRepository;
    }

    public Questao criarQuestao(Questao questao) {
        return questaoRepository.save(questao);
    }

    public Optional<Questao> buscarPorId(Long id) {
        return questaoRepository.findById(id);
    }

    public List<Questao> listarPorProva(Prova prova) {
        return questaoRepository.findByProva(prova);
    }

    public void deletarQuestao(Long id) {
        questaoRepository.deleteById(id);
    }
}
