package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class InSucessoComandoEmprestar extends InSucesso {
    public void imprimirRetorno(RetornoComando retorno) {

        if (retorno.getUsuario() != null && retorno.getLivro() != null) {
            System.out.println("Insucesso para concluir comando 'emp'(emprestar).");
            System.out.println("Usuário: " + retorno.getUsuarioNome());
            System.out.println("Livro: " + retorno.getLivroTitulo());
            System.out.println("Mensagem de erro:\n\t" + retorno.getMensagem() + "\n");
        } else {
            System.out.println("Insucesso para concluir comando 'emp'(emprestar).");
            System.out.println("Mensagem de erro:\n\t" + retorno.getMensagem() + "\n");
        }

    }
}
