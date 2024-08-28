package exemplar;

import geral.Livro;

public class Exemplar {
    Integer codigo;
    boolean disponivel;
    Livro livro;

    public Exemplar(Integer codigo, Livro livro) {
        this.codigo = codigo;
        this.disponivel = true;
        this.livro = livro;
    }

    public boolean mesmoLivro(Livro livro) {
        return this.livro == livro;
    }

    // Geters e Seters
    public Integer getCodigo() {
        return codigo;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
