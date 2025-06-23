package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.Nota;
import hackathun_java1.hackathun.repository.AlunoRepository;
import hackathun_java1.hackathun.repository.ProvaRepository;
import hackathun_java1.hackathun.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProvaRepository provaRepository;

    @GetMapping
    public String listarNotas(Model model) {
        model.addAttribute("notas", notaService.listarTodas());
        return "notas/list";
    }

    @GetMapping("/nova")
    public String novaNotaForm(Model model) {
        model.addAttribute("nota", new Nota());
        model.addAttribute("alunos", alunoRepository.findAll());
        model.addAttribute("provas", provaRepository.findAll());
        return "notas/form";
    }

    @PostMapping("/salvar")
    public String salvarNota(@ModelAttribute Nota nota) {
        notaService.salvar(nota);
        return "redirect:/notas";
    }
}
