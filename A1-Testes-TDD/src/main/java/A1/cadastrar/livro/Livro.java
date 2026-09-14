package A1.cadastrar.livro;

public class Livro {

    private final String titulo;
    private final String autor;
    private final String codigo;
    private boolean disponivel;

    public Livro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponivel = false;
    }

    public boolean cadastrar() {
        if (!tituloValido()) {
            return false;
        }

        disponivel = true;
        return true;
    }

    private boolean tituloValido() {
        return titulo != null && !titulo.isBlank();
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCodigo() {
        return codigo;
    }
}