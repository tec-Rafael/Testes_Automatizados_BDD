package A1.disponibilidadeLivro;


import A1.cadastrar.livro.Livro;

import java.util.List;

public class ConsultarDisponibilidade {

    private final List<Livro> livros;

    public ConsultarDisponibilidade(List<Livro> livros) {
        this.livros = livros;
    }

    public StatusDisponibilidade consultar(String codigo) {
        return null; // ainda não implementado — o teste deve falhar aqui, não no build
    }
}