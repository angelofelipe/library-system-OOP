package usuario;

import comando.retorno.RetornoComando;
import geral.Livro;

public interface IUsuario {
    public boolean eDevedor();
    public boolean chegouLimiteEmprestimos();
    public boolean estouComEsteLivroEmprestado(Livro livro);

    // Só chama se  Livro estiver disponível - Livro esta disponível ? Metodo biblioteca

    // Entrada processa a String de entrada
    // Quem passa a String de entrada para ela ?

    // Passar Livro achado, e o usuario achado chama esta função
    // Livro metodo Usuario tem reserva?
    // Livro metodo qual quantidade de Livros disponíveis - quantosLivrosDisponiveis()
    // Usuario -> tenho reserva e tem livros pra pegar ?
    // Livro -> Qual a quantidade de reservas ?
//    public RetornoComando pegarLivroEmprestado(Livro livro);


}
