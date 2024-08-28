package usuario;

import comando.retorno.RetornoComando;
import geral.Livro;

public class Professor extends Usuario{
    public Professor(String codigo, String nome) {
        super(codigo, nome, Integer.MAX_VALUE, 7);
    }

    public RetornoComando pegarLivroEmprestado(Usuario usuario, Livro livro, RetornoComando retorno) {

        return retorno;
    }
}
