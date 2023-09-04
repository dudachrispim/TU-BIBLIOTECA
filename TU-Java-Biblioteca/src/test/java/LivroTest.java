package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.java.Livro;

public class LivroTest {
	private Livro livro;
	
	@BeforeEach
	public void setUp() {
		livro = new Livro(1, "Harry Potter", "J.K. Rowling");
	}
	
	@Test
	public void testCriarLivro() {
		assertNotNull(livro);
	}
	
	@Test
	public void testEmprestarLivro() {
		livro.emprestar();
		assertTrue(livro.isEmprestado());
	}
	
	@Test
	public void testRetornarLivro() {
		livro.emprestar();
		livro.retornar();
		assertFalse(livro.isEmprestado());
	}
}
