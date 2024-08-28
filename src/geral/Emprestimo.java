package geral;

import usuario.Usuario;

import java.time.LocalDate;

public class Emprestimo {
    Exemplar exemplar;
    Usuario usuario;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;
    LocalDate dataEntregue;

    public Emprestimo(Exemplar exemplar, Usuario usuario, Integer diasEmprestados) {
        this.exemplar = exemplar;
        this.usuario = usuario;
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

//    public String toStringComandoLivro(){
//        // IMPLEMENTAR - USAR FABRICA GERAL PARA CONVERTER DATA
//        String mensagem;
//
//        mensagem = "\n\tCódigo:" + exemplar.getCodigo() + "\n";
//        mensagem += "\t"
//
//        return mensagem;
//    }

    public String toStringComandoUsuario(){
        String mensagem = "";

        mensagem += "\n\tTítulo livro: " + exemplar.getLivro().getTitulo() + "\n";
        mensagem += "\tData emprestimo: " + toStrinDataEmprestimo();
        if (dataEntregue == null) {
            mensagem += "\tStatus: Em curso.\n";
            mensagem += "\tData devolução: " + toStrinDataDevolucao() + "\n";
        } else {
            mensagem += "\tStatus: Finalizado.\n";
            mensagem += "\tData entregue: " + toStrinDataEntregue() + "\n";
        }

        return mensagem;
    }

    public String emprestadoPara() {
        return usuario.getNome();
    }

    public String toStrinDataEmprestimo() {
        return FabricaGeral.dataToString(dataEmprestimo);
    }

    public String toStrinDataDevolucao() {
        return FabricaGeral.dataToString(dataDevolucao);
    }

    public String toStrinDataEntregue() {
        return FabricaGeral.dataToString(dataEntregue);
    }
}
