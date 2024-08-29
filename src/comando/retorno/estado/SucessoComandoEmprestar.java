package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class SucessoComandoEmprestar extends Sucesso {
    public void imprimirRetorno(RetornoComando retorno) {
        System.out.println("Sucesso para concluir comando 'emp' (emprestar).");
        System.out.println("Usuário: " + retorno.getUsuarioNome());
        System.out.println("Livro: " + retorno.getLivroTitulo() + "\n");
    }
}
