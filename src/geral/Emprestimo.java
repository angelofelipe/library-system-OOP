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
        // IMPLEMENTAR - USAR FABRICA GERAL PARA CONVERTER DATA
        return "";
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
