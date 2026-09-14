// src/main/java/A1/consultar/disponibilidade/ConsultarDisponibilidade.java (refatorado)
package A1.disponibilidadeLivro;

import A1.cadastrar.livro.Livro;

import java.util.List;
import java.util.Optional;

public class ConsultarDisponibilidade {

    private final List<Livro> livros;

    public ConsultarDisponibilidade(List<Livro> livros) {
        this.livros = livros;
    }

    public StatusDisponibilidade consultar(String codigo) {
        return buscarPorCodigo(codigo)
                .map(this::statusDoLivro)
                .orElse(StatusDisponibilidade.LIVRO_NAO_ENCONTRADO);
    }

    private Optional<Livro> buscarPorCodigo(String codigo) {
        return livros.stream()
                .filter(livro -> livro.getCodigo().equals(codigo))
                .findFirst();
    }

    private StatusDisponibilidade statusDoLivro(Livro livro) {
        return livro.isDisponivel()
                ? StatusDisponibilidade.DISPONIVEL
                : StatusDisponibilidade.INDISPONIVEL;
    }
}