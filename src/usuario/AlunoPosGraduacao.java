package usuario;

import comando.retorno.RetornoComando;
import geral.Livro;

public class AlunoPosGraduacao extends Usuario{
    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome, 4, 5);
    }

    public RetornoComando pegarLivroEmprestado(Usuario usuario, Livro livro, RetornoComando retorno) {

        return retorno;
    }
}
