import java.util.ArrayList;
import java.util.List;

public class Membro {
    private int id;
    private String nome;
    private List<Livro> livrosEmprestados;

    public Membro(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.livrosEmprestados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void emprestarLivro(Livro livro) {
        if (!livro.isEmprestado()) {
            livro.setEmprestado(true);
            livrosEmprestados.add(livro);
        } else {
            System.out.println("O livro já está emprestado.");
        }
    }

    public void retornarLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livro.setEmprestado(false);
            livrosEmprestados.remove(livro);
        } else {
            System.out.println("Este membro não tem este livro emprestado.");
        }
    }
}
