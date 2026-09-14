package A1.consultarDisponibilidade;

import org.junit.jupiter.api.Test;

import java.util.List;

import A1.cadastrar.livro.Livro;
import A1.disponibilidadeLivro.ConsultarDisponibilidade;
import A1.disponibilidadeLivro.StatusDisponibilidade;

import static org.junit.jupiter.api.Assertions.assertEquals;

class disponibilidadeTeste {

    @Test
    void deveInformarDisponivelQuandoLivroNaoPossuiEmprestimoAtivo() {
        // Arrange
        Livro livro = new Livro("Clean Code", "Robert C. Martin", "L001");
        livro.cadastrar(); // fica disponivel = true

        ConsultarDisponibilidade consulta = new ConsultarDisponibilidade(List.of(livro));

        // Action
        StatusDisponibilidade status = consulta.consultar("L001");

        // Assert
        assertEquals(StatusDisponibilidade.DISPONIVEL, status);
    }

    @Test
    void deveInformarIndisponivelQuandoLivroEstaEmprestado() {
        // Arrange
        Livro livro = new Livro("Effective Java", "Joshua Bloch", "L002");
        // não chamamos cadastrar(): disponivel permanece false, simulando empréstimo ativo

        ConsultarDisponibilidade consulta = new ConsultarDisponibilidade(List.of(livro));

        // Action
        StatusDisponibilidade status = consulta.consultar("L002");

        // Assert
        assertEquals(StatusDisponibilidade.INDISPONIVEL, status);
    }

    @Test
    void deveInformarNaoEncontradoQuandoCodigoNaoCadastrado() {
        // Arrange
        ConsultarDisponibilidade consulta = new ConsultarDisponibilidade(List.of());

        // Action
        StatusDisponibilidade status = consulta.consultar("L999");

        // Assert
        assertEquals(StatusDisponibilidade.LIVRO_NAO_ENCONTRADO, status);
    }
}