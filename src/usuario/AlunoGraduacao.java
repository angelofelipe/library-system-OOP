package usuario;

import comando.retorno.RetornoComando;
import geral.Livro;

public class AlunoGraduacao extends Usuario{
    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome, 3, 3);
    }

    public RetornoComando pegarLivroEmprestado(Usuario usuario, Livro livro, RetornoComando retorno) {

        return retorno;
    }
}
