package A1.devolucao.livro;

import A1.cadastrar.livro.Livro;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class DevolucaoTestes {

    @Test
    void deveRegistrarDevolucaoDentroDoPrazoSemGerarMulta() {

        // Arrange
        // DADO que possuo um livro emprestado
        // E a data de devolução ainda não foi ultrapassada
        Livro livro = new Livro(
                "Dom Casmurro",
                "Machado de Assis",
                "9788535902778"
        );
        Devolucao devolucao = new Devolucao(
                livro,
                LocalDate.now().minusDays(3),
                LocalDate.now().plusDays(4)
        );

        // Act
        // QUANDO devolvo o livro
        boolean devolucaoRealizada = devolucao.registrarDevolucao();

        // Assert
        // ENTÃO o sistema deve registrar a devolução
        assertTrue(devolucaoRealizada, "A devolução deveria ser registrada com sucesso");
        assertTrue(devolucao.isRegistrada(), "A devolução deveria estar marcada como registrada");

        // E o livro deve ficar disponível novamente
        assertTrue(livro.isDisponivel(), "O livro deveria voltar a ficar disponível após a devolução");

        // E nenhuma multa deve ser gerada
        assertFalse(devolucao.isMultaGerada(), "Não deveria ser gerada multa dentro do prazo");
    }
}