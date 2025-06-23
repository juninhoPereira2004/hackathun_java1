package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.model.Prova;
import hackathun_java1.hackathun.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository provaRepository;

    public List<Prova> listarTodas() {
        return provaRepository.findAll();
    }

    public Prova salvar(Prova prova) {
        return provaRepository.save(prova);
    }
}
