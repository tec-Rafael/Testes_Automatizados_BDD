package A1.cadastrar.livro.realizar.emprestimo;

import A1.cadastrar.livro.Livro;

public class RealizarEmprestimo {

    private final Livro livro;
    private boolean emprestado;

    public RealizarEmprestimo(Livro livro) {
        this.livro = livro;
        this.emprestado = false;
    }

    public boolean realizar() {
        if (!livro.isDisponivel()) {
            return false;
        }

        emprestado = true;
        return true;
    }

    public boolean devolver() {
        if (!emprestado) {
            return false;
        }

        emprestado = false;
        return true;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public Livro getLivro() {
        return livro;
    }
}