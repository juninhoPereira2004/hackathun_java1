package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.Disciplina;
import hackathun_java1.hackathun.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Change to @Controller
import org.springframework.ui.Model; // Import Model
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView; // Import ModelAndView

import java.util.List;

@Controller // Use @Controller for serving HTML views
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    // Displays the list of disciplines
    @GetMapping("/list") // New mapping for listing disciplines
    public String listarDisciplinas(Model model) {
        List<Disciplina> disciplinas = disciplinaService.listar();
        model.addAttribute("disciplinas", disciplinas);
        return "disciplinas/list"; // Corresponds to src/main/resources/templates/disciplinas/list.html
    }

    // Displays the form for creating a new discipline
    @GetMapping("/form") // New mapping for the form
    public String showFormForAdd(Model model) {
        Disciplina disciplina = new Disciplina();
        model.addAttribute("disciplina", disciplina);
        return "disciplinas/form"; // Corresponds to src/main/resources/templates/disciplinas/form.html
    }

    // Displays the form for editing an existing discipline
    @GetMapping("/form/{id}") // Mapping for editing
    public String showFormForUpdate(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaService.buscarPorId(id);
        model.addAttribute("disciplina", disciplina);
        return "disciplinas/form";
    }

    // Handles form submission (create and update)
    @PostMapping
    public String salvarDisciplina(@ModelAttribute("disciplina") Disciplina disciplina) {
        disciplinaService.salvar(disciplina);
        return "redirect:/disciplinas/list"; // Redirect to the list after saving
    }

    // Handles deletion of a discipline
    @PostMapping("/deletar/{id}") // Use um caminho diferente, por exemplo, /deletar/{id}
    public String deletarDisciplina(@PathVariable Long id) {
        disciplinaService.excluir(id);
        return "redirect:/disciplinas/list"; // Redireciona para a lista após a exclusão
    }

    // The @RestController methods are typically used for pure API endpoints.
    // If you intend to use this for the Flutter app as well, you'd keep the @RestController above
    // and create separate @Controller methods for the web views.
    // For simplicity, I've transformed the existing methods to serve views.
    // If you need both, consider having a separate RestController or using different paths
    // (e.g., /api/disciplinas for REST and /disciplinas for views).
}