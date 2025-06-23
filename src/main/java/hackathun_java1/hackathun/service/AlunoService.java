package hackathun_java1.hackathun.service;

import hackathun_java1.hackathun.model.Aluno;
import hackathun_java1.hackathun.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setIdade(alunoAtualizado.getIdade());
        aluno.setRa(alunoAtualizado.getRa());
        return alunoRepository.save(aluno);
    }

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // ... outros métodos ...

    /**
     * Busca um Aluno pelo ID do User associado.
     * Este método assume que sua entidade Aluno tem um campo que referencia o User.
     * @param userId O ID do User autenticado.
     * @return Um Optional contendo o Aluno, se encontrado.
     */
    public Optional<Aluno> buscarPorIdDoUsuario(Long userId) {
        // ASSUMIR A LÓGICA DE BUSCA AQUI
        // Exemplo 1: Se Aluno.id é o mesmo que User.id
        return alunoRepository.findById(userId);

        // Exemplo 2: Se Aluno tem um campo 'user' do tipo User (ManyToOne ou OneToOne)
        // return alunoRepository.findByUser(new User(userId)); // Cuidado: pode precisar de um User mock ou carregar o User completo

        // Exemplo 3: Se Aluno tem um campo 'userId' (Long) que armazena o ID do User
        // return alunoRepository.findByUserId(userId);
    }

    // Se o ID do User de segurança é o mesmo ID da sua entidade Aluno,
    // o método buscarPorId(Long id) acima já serve para buscar o aluno pelo ID do User.
    // Se não for o caso, você precisaria de um método como este:
    // public Optional<Aluno> buscarAlunoPorUserId(Long userId) {
    //     return alunoRepository.findByUserId(userId); // Exige findByUserId no AlunoRepository
    // }
}