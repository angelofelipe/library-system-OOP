package usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import comando.retorno.RetornoComando;
import geral.Emprestimo;
import geral.Livro;
import geral.Reserva;

public abstract class Usuario implements IUsuario, IObserver {
    protected String codigo;
    protected String nome;
    protected Integer limiteEmprestimos;
    protected Integer tempoEmprestimos;
    protected HashSet<LivroObservado> livrosObservados;
    protected List<Emprestimo> emprestimosPassados;
    protected List<Emprestimo> emprestimosCorrentes;
    protected HashSet<Reserva> reservas;

    public Usuario(String codigo, String nome, Integer limiteEmprestimos, Integer tempoEmprestimos) {
        this.codigo = codigo;
        this.nome = nome;
        this.livrosObservados = new HashSet<>();
        this.limiteEmprestimos = limiteEmprestimos;
        this.tempoEmprestimos = tempoEmprestimos;
        emprestimosPassados = new ArrayList<>();
        emprestimosCorrentes = new ArrayList<>();
        reservas = new HashSet<>();
    }

    // Implementação de IObserver
    public abstract RetornoComando pegarLivroEmprestado(Usuario usuario, Livro livro, RetornoComando retorno);

    public void addLivroObservado(LivroObservado livroObservado) {
        livrosObservados.add(livroObservado);
    }

    public void updateObservadorLivro(Livro livro) {
       for (LivroObservado livroObservado : livrosObservados) {
           if (livroObservado.getLivro().equals(livro)) {
               livroObservado.incrementarNotificacao();
               return;
           }
       }
    }

    // Funções gerais
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

    public String toStringConsulta() {
        String mensagem = "";

        mensagem += "Nome: " + nome + "\n";
        if (emprestimosCorrentes.size() > 0) {
            mensagem += "Empréstimos correntes: \n";
            mensagem += toStringEmprestimosCorrentes();
        }
        if (emprestimosPassados.size() > 0) {
            mensagem += "Empréstimos passados: \n";
            mensagem += toStringEmprestimosPassados();
        }
        if (reservas.size() > 0) {
            mensagem += "Reservas: \n";
            mensagem += toStringReservas();
        }

        return  mensagem;
    }

    private String toStringEmprestimosCorrentes(){
        StringBuilder mensagem = new StringBuilder();

        for (Emprestimo emprestimo : emprestimosCorrentes) {
            mensagem.append(emprestimo.toStringComandoUsuario());
        }

        return mensagem.toString();
    }

    private String toStringEmprestimosPassados(){
        StringBuilder mensagem = new StringBuilder();

        for (Emprestimo emprestimo : emprestimosPassados) {
            mensagem.append(emprestimo.toStringComandoUsuario());
        }

        return mensagem.toString();
    }

    public String toStringReservas() {
        StringBuilder mensagem = new StringBuilder();

        for (Reserva reserva : reservas)
            mensagem.append(reserva.toStringComandoUsuario());

        return mensagem.toString();
    }

    public Integer quantasReservas(){ return reservas.size(); }

    public boolean tenhoReservaDoLivro(Livro livro) {
        for (Reserva reserva : reservas) {
            if (reserva.getLivro().equals(livro))
                return true;
        }
        return false;
    }

    // Geters
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
}
