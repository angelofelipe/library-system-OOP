package geral;

import usuario.IObserver;

import java.util.ArrayList;
import java.util.HashSet;

public class Livro {
    private String codigo;
    private String titulo;
    private String editora;
    private Integer edicao;
    private Integer anoPublicacao;
    private HashSet<String> autores;
    private ArrayList<Emprestimo> emprestimos;
    private HashSet<Reserva> reservas;
    private HashSet<Exemplar> exemplares;
    private HashSet<IObserver> observadores;

    public Livro(String codigo, String titulo, String editora, Integer edicao, Integer anoPublicacao, HashSet<String> autores) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.autores = autores;
        this.emprestimos = new ArrayList<Emprestimo>();
        this.reservas = new HashSet<Reserva>();
        this.exemplares = new HashSet<Exemplar>();
        this.observadores = new HashSet<>();
    }

    public boolean estaDisponivel() {
        return emprestimos.size() < exemplares.size();
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void addExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }


    public void removeReservas(Reserva reserva) {
        reservas.remove(reserva);
    }

    public void removeEmprestimos(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
    }

    public Integer quantasReservas() { return reservas.size(); }

    public Integer quantosEmprestimos() { return emprestimos.size(); }

    public String toStrinConsulta() {
        String mensagem;
        Integer qtdReservas = quantasReservas();

        mensagem = "Título: " + getTitulo() + "\n";
        mensagem += "Código: " + getCodigo() + "\n";
        mensagem += "Quantidade de reservas: " + quantasReservas() + "\n";

        if (qtdReservas > 0) {
            mensagem += "Pessoas que fizeram reservas:\n";
            mensagem += toStringNomesPessoasFizeramReservas();
        }

        mensagem += "Exemplares: \n";
        String retirarUltimaQuebraLinha = toStringExemplar();
        mensagem += retirarUltimaQuebraLinha.substring(0, retirarUltimaQuebraLinha.length() - 1);

        return mensagem;
    }

    // Privates para função toStringConsulta
    private String toStringNomesPessoasFizeramReservas() {
        StringBuilder mensagem = new StringBuilder();

        for (Reserva reserva : reservas)
            mensagem.append("\t").append(reserva.getUsuario().getNome()).append("\n");

        return mensagem.toString();
    }

    private String toStringExemplar() {
        StringBuilder mensagem = new StringBuilder();

        for (Exemplar exemplar : exemplares)
            mensagem.append(exemplar.toStringParaLivro());

        return mensagem.toString();
    }

    // Implementa IObserver
    public void updateObservers() {
        for (IObserver observador : observadores)
            observador.updateObservadorLivro(this);
    }

    public void addObserver(IObserver observador) { observadores.add(observador); }

    // Geters e Seters
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public HashSet<String> getAutores() {
        return autores;
    }
}
