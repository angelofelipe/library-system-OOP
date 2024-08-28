package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class InSucessoComandoObserver extends InSucesso {
    public void imprimirRetorno(RetornoComando retorno) {

        if (retorno.getUsuario() != null && retorno.getLivro() != null) {
            System.out.println("Insucesso para concluir comando 'obs'(observar).");
            System.out.println("Usuário: " + retorno.getUsuarioNome());
            System.out.println("Livro: " + retorno.getLivroTitulo());
            System.out.println("Mensagem de erro: " + retorno.getMensagem() + "\n");
        } else {
            System.out.println("Insucesso para concluir comando 'obs'(observar).");
            System.out.println("Mensagem de erro: " + retorno.getMensagem() + "\n");
        }

    }
}
