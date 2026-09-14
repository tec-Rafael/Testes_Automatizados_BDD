package A1.cadastrar.livro;

public class Livro {

    private String titulo;
    private String autor;
    private String isbn;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public boolean cadastrar() {
        return true;
    }

    public boolean isDisponivel() {
        return false;
    }
}