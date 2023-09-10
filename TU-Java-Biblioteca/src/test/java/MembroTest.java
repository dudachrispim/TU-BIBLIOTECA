
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MembroTest {

    private Membro membro;
    private Livro livro;

    @BeforeEach
    public void setUp() {
        membro = new Membro(1, "João");
        livro = new Livro(1, "Harry Potter", "J.K. Rowling");
    }

    @Test
    public void testCriarMembro() {
        assertNotNull(membro);
        assertEquals(1, membro.getId());
        assertEquals("João", membro.getNome());
        assertTrue(membro.getLivrosEmprestados().isEmpty());
    }

    @Test
    public void testMembroPegaEmprestado() {
        membro.emprestarLivro(livro);
        assertTrue(livro.isEmprestado());
        assertEquals(1, membro.getLivrosEmprestados().size());
        assertTrue(membro.getLivrosEmprestados().contains(livro));
    }

    @Test
    public void testMembroRetornaLivro() {
        membro.emprestarLivro(livro);
        membro.retornarLivro(livro);
        assertFalse(livro.isEmprestado());
        assertTrue(membro.getLivrosEmprestados().isEmpty());
    }

    @Test
    public void testMembroTentaDevolverLivroNaoEmprestado() {
        membro.retornarLivro(livro);
        assertFalse(livro.isEmprestado());
        assertTrue(membro.getLivrosEmprestados().isEmpty());
    }
}
