package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.Prova;
import hackathun_java1.hackathun.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provas")
public class ProvaController {

    @Autowired
    private ProvaService provaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("provas", provaService.listarTodas());
        return "provas/list";
    }

    @GetMapping("/nova")
    public String novaProva(Model model) {
        model.addAttribute("prova", new Prova());
        return "provas/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Prova prova) {
        provaService.salvar(prova);
        return "redirect:/provas";
    }
}
