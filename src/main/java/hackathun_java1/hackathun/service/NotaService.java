package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.model.Nota;
import hackathun_java1.hackathun.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Nota> listarTodas() {
        return notaRepository.findAll();
    }

    public Nota salvar(Nota nota) {
        return notaRepository.save(nota);
    }
}
