import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void registrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void emprestarLivro(int livroId, int membroId) {
        Livro livro = encontrarLivroPorId(livroId);
        if (livro != null && !livro.isEmprestado()) {
            Membro membro = encontrarMembroPorId(membroId);
            if (membro != null) {
                livro.setEmprestado(true);
                membro.adicionarLivroEmprestado(livro);
            }
        }
    }

    public void retornarLivro(int livroId, int membroId) {
        Livro livro = encontrarLivroPorId(livroId);
        if (livro != null && livro.isEmprestado()) {
            Membro membro = encontrarMembroPorId(membroId);
            if (membro != null) {
                livro.setEmprestado(false);
                membro.removerLivroEmprestado(livro);
            }
        }
    }

    private Livro encontrarLivroPorId(int livroId) {
        for (Livro livro : livros) {
            if (livro.getId() == livroId) {
                return livro;
            }
        }
        return null;
    }

    private Membro encontrarMembroPorId(int membroId) {
        // Implemente a busca de membros se necessário
        return null;
    }
}
