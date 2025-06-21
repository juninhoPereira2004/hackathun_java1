package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.model.Prova;
import hackathun_java1.hackathun.repository.ProvaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvaService {

    private final ProvaRepository provaRepository;

    public ProvaService(ProvaRepository provaRepository) {
        this.provaRepository = provaRepository;
    }

    public List<Prova> listar() {
        return provaRepository.findAll();
    }

    public Prova salvar(Prova prova) {
        return provaRepository.save(prova);
    }

    public Optional<Prova> buscarPorId(Long id) {
        return provaRepository.findById(id);
    }

    public void excluir(Long id) {
        provaRepository.deleteById(id);
    }
}