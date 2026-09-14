package A1.cadastrar.livro.realizar.emprestimo;

import A1.cadastrar.livro.Livro;

public class RealizarEmprestimo {

    private final Livro livro;

    public RealizarEmprestimo(Livro livro) {
        this.livro = livro;
    }

    public boolean realizar() {
        return false;
    }

    public boolean devolver() {
        return true;
    }

    public boolean isEmprestado() {
        return true;
    }

    public Livro getLivro() {
        return livro;
    }
}
