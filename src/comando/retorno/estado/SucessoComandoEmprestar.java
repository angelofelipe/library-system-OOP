package comando.retorno.estado;

import comando.retorno.IRetornoComando;
import comando.retorno.RetornoComando;

public class SucessoComandoEmprestar implements EstadoRetorno {
    public void imprimirRetorno(RetornoComando retornoComando) {
        System.out.println("Insucesso para concluir comando 'emp'(emprestar).");
        System.out.println("Usuário: " + retornoComando.getUsuarioNome());
        System.out.println("Livro: " + retornoComando.getLivroTitulo() + "\n");
    }
}
