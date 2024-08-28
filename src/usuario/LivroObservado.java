package usuario;

import geral.Livro;

public class LivroObservado {
    private Integer notificacoes;
    private Livro livro;

    public LivroObservado(Livro livro) {
        this.notificacoes = 0;
        this.livro = livro;
    }


    public void incrementarNotificacao() {
        notificacoes++;
    }

    // Geters
    public Integer getNotificacoes() {
        return notificacoes;
    }

    public Livro getLivro() {
        return livro;
    }
}
