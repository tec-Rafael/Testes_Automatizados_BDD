package A1.realizar.emprestimo;

import A1.cadastrar.livro.Livro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RealizarEmprestimoTestes {

    @Test
    void deveRealizarEmprestimoQuandoLivroDisponivel() {

        // Arrange
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "9788535902778");
        livro.cadastrar();
        RealizarEmprestimo emprestimo = new RealizarEmprestimo(livro);

        // Action
        boolean resultado = emprestimo.realizar();

        // Assert
        assertTrue(resultado);
        assertTrue(emprestimo.isEmprestado());
    }

    @Test
    void naoDeveRealizarEmprestimoQuandoLivroIndisponivel() {

        // Arrange
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "9788535902778");
        // livro não foi cadastrado -> continua indisponível
        RealizarEmprestimo emprestimo = new RealizarEmprestimo(livro);

        // Action
        boolean resultado = emprestimo.realizar();

        // Assert
        assertFalse(resultado);
        assertFalse(emprestimo.isEmprestado());
    }

    @Test
    void deveDevolverLivroQuandoEstaEmprestado() {

        // Arrange
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "9788535902778");
        livro.cadastrar();
        RealizarEmprestimo emprestimo = new RealizarEmprestimo(livro);
        emprestimo.realizar();

        // Action
        boolean resultado = emprestimo.devolver();

        // Assert
        assertTrue(resultado);
        assertFalse(emprestimo.isEmprestado());
    }

    @Test
    void naoDeveDevolverLivroQueNaoFoiEmprestado() {

        // Arrange
        Livro livro = new Livro("Dom Casmurro", "Machado de Assis", "9788535902778");
        livro.cadastrar();
        RealizarEmprestimo emprestimo = new RealizarEmprestimo(livro);

        // Action
        boolean resultado = emprestimo.devolver();

        // Assert
        assertFalse(resultado);
    }
}