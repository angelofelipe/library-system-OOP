package usuario;

import comando.retorno.RetornoComando;
import geral.Livro;

public interface IUsuario {
    public boolean eDevedor();
    public boolean chegouLimiteEmprestimos();
    public boolean estouComEsteLivroEmprestado(Livro livro);
    public RetornoComando pegarLivroEmprestado(Usuario usuario, Livro livro);
}
