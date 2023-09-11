import org.junit.Assert;
import org.junit.Test;

public class BibliotecaTest {

    @Test
    public void testRegistrarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien");
        biblioteca.registrarLivro(livro);
        Assert.assertEquals(1, biblioteca.getLivros().size());
    }

    @Test
    public void testEmprestarLivroParaMembro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien");
        Membro membro = new Membro(1, "João");
        biblioteca.registrarLivro(livro);
        biblioteca.emprestarLivro(1, 1);
        Assert.assertTrue(livro.isEmprestado());
        Assert.assertEquals(1, membro.getLivrosEmprestados().size());
    }

    @Test
    public void testRetornarLivroDeMembro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien");
        Membro membro = new Membro(1, "João");
        biblioteca.registrarLivro(livro);
        biblioteca.emprestarLivro(1, 1);
        biblioteca.retornarLivro(1, 1);
        Assert.assertFalse(livro.isEmprestado());
        Assert.assertEquals(0, membro.getLivrosEmprestados().size());
    }

    @Test
    public void testEmprestarLivroNaoDisponivel() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien");
        Membro membro1 = new Membro(1, "João");
        Membro membro2 = new Membro(2, "Maria");
        biblioteca.registrarLivro(livro);
        biblioteca.emprestarLivro(1, 1);
        biblioteca.emprestarLivro(1, 2); // Tentativa de empréstimo para outro membro
        Assert.assertTrue(livro.isEmprestado()); // O livro ainda deve estar emprestado para o primeiro membro
        Assert.assertEquals(1, membro1.getLivrosEmprestados().size());
        Assert.assertEquals(0, membro2.getLivrosEmprestados().size());
    }
}
