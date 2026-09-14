package A1.cadastrar.livro;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivroTestes {

    @Test
    void deveCadastrarLivroComoDisponivel() {

        // Arrange
        Livro livro = new Livro(
                "Dom Casmurro",
                "Machado de Assis",
                "9788535902778"
        );

        // Action
        boolean resultado = livro.cadastrar();

        // Assert
        assertTrue(resultado);
        assertTrue(livro.isDisponivel());
    }

    @Test
    void naoDeveCadastrarLivroSemTitulo() {

        // Arrange
        Livro livro = new Livro(
                "",
                "Machado de Assis",
                "9788535902778"
        );

        // Action
        boolean resultado = livro.cadastrar();

        // Assert
        assertFalse(resultado);
    }




}