package emprestimo;

import exemplar.Exemplar;
import geral.Livro;

import java.time.LocalDate;

public class Emprestimo {
    Exemplar exemplar;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;
    LocalDate dataEntregue;

    public Emprestimo(Exemplar exemplar, Integer diasEmprestados) {
        this.exemplar = exemplar;
        dataEmprestimo = LocalDate.now();
        dataDevolucao = dataEmprestimo.plusDays(diasEmprestados);
        dataEntregue = null;
    }

    public boolean temMesmoLivro(Livro livro) {
        return exemplar.mesmoLivro(livro);
    }

    public boolean estaAtrasado(){
        LocalDate datahoje = LocalDate.now();
        int comparacao = dataDevolucao.compareTo(datahoje);
        return comparacao < 0;
    }

    public String toStringComandoLivro(){
        // IMPLEMENTAR - USAR FABRICA GERAL PARA CONVERTER DATA
        return "";
    }

    public String toStringComandoUsuario(){
        // IMPLEMENTAR - USAR FABRICA GERAL PARA CONVERTER DATA
        return "";
    }
}
