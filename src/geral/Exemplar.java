package geral;

public class Exemplar {
    String codigo;
    Livro livro;
    Emprestimo emprestimo;

    public Exemplar(String codigo, Livro livro) {
        this.codigo = codigo;
        this.livro = livro;
        this.emprestimo = null;
    }

    public boolean mesmoLivro(Livro livro) {
        return this.livro == livro;
    }

    public String toStringParaLivro() {
        String mensagem = "\n\tCódigo: " + getCodigo() + "\n";

        if (isDisponivel()) {
            mensagem += "\tStatus: Disponível\n\n";
        } else {
            mensagem += "\tStatus: Indisponível\n";
            mensagem += "\tEmprestado para: " + emprestimo.emprestadoPara() + "\n";
            mensagem += "\tData emprestimo: " + emprestimo.toStrinDataEmprestimo() + "\n";
            mensagem += "\tData prevista devolução: " + emprestimo.toStrinDataDevolucao() + "\n";
        }

        return mensagem;
    }

    public void devolverExemplarLivro(Emprestimo emprestimoDevolucao) {
        livro.devolverExemplarLivro(emprestimoDevolucao);
        emprestimo = null;
    }

    public String getTituloLivro() {
        return livro.getTitulo();
    }

    // Geters e Seters
    public String getCodigo() {
        return codigo;
    }

    public Livro getLivro() {
        return livro;
    }

    public boolean isDisponivel() {
        return emprestimo == null;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
}
