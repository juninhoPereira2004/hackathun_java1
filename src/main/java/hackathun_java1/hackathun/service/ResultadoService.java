package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.model.*;
import hackathun_java1.hackathun.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoService {

    private final ResultadoRepository resultadoRepository;

    public ResultadoService(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    public List<Resultado> listarTodos() {
        return resultadoRepository.findAll();
    }

    public List<Resultado> listarResultadosPorAluno(Long idAluno) {
        return resultadoRepository.findByAlunoId(idAluno);
    }

    public List<Resultado> listarResultadosPorProva(Long idProva) {
        return resultadoRepository.findByProvaId(idProva);
    }

    public Optional<Resultado> buscarPorId(Long id) {
        return resultadoRepository.findById(id);
    }

    public Resultado salvar(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    public Optional<Resultado> atualizar(Long id, Resultado resultadoAtualizado) {
        return resultadoRepository.findById(id).map(resultado -> {
            resultado.setAluno(resultadoAtualizado.getAluno());
            resultado.setProva(resultadoAtualizado.getProva());
            resultado.setAcertos(resultadoAtualizado.getAcertos());
            resultado.setErros(resultadoAtualizado.getErros());
            resultado.setNota(resultadoAtualizado.getNota());
            return resultadoRepository.save(resultado);
        });
    }

    public boolean deletar(Long id) {
        return resultadoRepository.findById(id).map(resultado -> {
            resultadoRepository.delete(resultado);
            return true;
        }).orElse(false);
    }
}
