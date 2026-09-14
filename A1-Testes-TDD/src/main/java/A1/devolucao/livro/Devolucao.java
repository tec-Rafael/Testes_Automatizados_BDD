package A1.devolucao.livro;

import A1.cadastrar.livro.Livro;

import java.time.LocalDate;


public class Devolucao {

    private final Livro livro;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataDevolucaoPrevista;
    private boolean registrada;
    private boolean multaGerada;

    public Devolucao(Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.registrada = false;
        this.multaGerada = false;
    }


    public boolean registrarDevolucao() {
        livro.devolver();
        registrada = true;
        multaGerada = LocalDate.now().isAfter(dataDevolucaoPrevista);

        return true;
    }

    public boolean isRegistrada() {
        return registrada;
    }

    public boolean isMultaGerada() {
        return multaGerada;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }
}