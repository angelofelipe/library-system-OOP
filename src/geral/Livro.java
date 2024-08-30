package geral;

import usuario.IObserver;
import usuario.Usuario;

import java.util.ArrayList;
import java.util.HashSet;

public class Livro {
    private final String codigo;
    private final String titulo;
    private final String editora;
    private final Integer edicao;
    private final Integer anoPublicacao;
    private final HashSet<String> autores;
    private final ArrayList<Emprestimo> emprestimos;
    private final HashSet<Reserva> reservas;
    private final HashSet<Exemplar> exemplares;
    private final HashSet<IObserver> observadores;

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

    private void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    // Futuro - implementar se existe algum exemplar cadastrado
    public Emprestimo emprestarLivro(Usuario usuario) {
        Exemplar exemplar = getExemplarDisponivel();
        if (exemplar != null) {
            Emprestimo emprestimo = new Emprestimo(exemplar, usuario, usuario.getTempoEmprestimos());
            addEmprestimo(emprestimo);
            seUsuarioTiverReservaRemove(usuario);
            return emprestimo;
        }
        return null;
    }

    private void seUsuarioTiverReservaRemove(Usuario usuario) {
        reservas.removeIf(reserva -> reserva.getUsuario() == usuario);
    }

    private Exemplar getExemplarDisponivel() {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel())
                return exemplar;
        }
        return null;
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

    public Integer quantosExemplaresDisponiveis(){
        return quantosExemplares() - quantosEmprestimos() - quantasReservas();
    }

    public Integer quantasReservas() { return reservas.size(); }

    public Integer quantosExemplares() { return exemplares.size(); }

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

    public void devolverExemplarLivro(Emprestimo emprestimoDevolucao) {
        Emprestimo emprestimoRemover = null;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo == emprestimoDevolucao) {
                emprestimoRemover = emprestimoDevolucao;
                break;
            }
        }
        if (emprestimoRemover != null)
            emprestimos.remove(emprestimoDevolucao);
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
