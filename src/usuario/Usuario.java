package usuario;

import java.util.HashSet;
import java.util.List;
import emprestimo.Emprestimo;
import geral.Livro;
import geral.Reserva;

public abstract class Usuario implements IUsuario, IObserver {
    protected String codigo;
    protected String nome;
    protected Integer limiteEmprestimos;
    protected Integer tempoEmprestimos;
    protected Integer notificacoes;
    protected List<Emprestimo> emprestimosPassados;
    protected List<Emprestimo> emprestimosCorrentes;
    protected HashSet<Reserva> reservas;

    public Usuario(String codigo, String nome, Integer limiteEmprestimos, Integer tempoEmprestimos) {
        this.codigo = codigo;
        this.nome = nome;
        this.notificacoes = 0;
        this.limiteEmprestimos = limiteEmprestimos;
        this.tempoEmprestimos = tempoEmprestimos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getTempoEmprestimos(){ return tempoEmprestimos; }

    public void update() { notificacoes++; }

    public boolean eDevedor() {
        for (Emprestimo emprestimo : emprestimosCorrentes) {
            if (emprestimo.estaAtrasado())
                return true;
        }
        return false;
    }

    public boolean chegouLimiteEmprestimos() {
        return limiteEmprestimos <= emprestimosCorrentes.size();
    }

    public boolean estouComEsteLivroEmprestado(Livro livro) {
        for (Emprestimo emprestimo : emprestimosCorrentes) {
            if (emprestimo.temMesmoLivro(livro))
                return true;
        }
        return false;
    }

}
