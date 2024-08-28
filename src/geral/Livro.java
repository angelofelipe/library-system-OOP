package geral;

import emprestimo.Emprestimo;
import exemplar.Exemplar;

import java.util.ArrayList;
import java.util.HashSet;

public class Livro {
// RETORNAR PARA CLASSE BIBLIOTECA IMPLEMENTANDO FUNÇÃO ACHAR LIVRO POR CODIGO
    private String codigo;
    private String titulo;
    private String editora;
    private Integer edicao;
    private Integer anoPublicacao;
    private HashSet<String> autores;
    private ArrayList<Emprestimo> emprestimos;
    private HashSet<Reserva> reservas;
    private HashSet<Exemplar> exemplares;

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
