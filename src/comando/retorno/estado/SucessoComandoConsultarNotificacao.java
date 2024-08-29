package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class SucessoComandoConsultarNotificacao extends Sucesso {
    public void imprimirRetorno(RetornoComando retorno) {
        System.out.println("Sucesso para concluir comando 'ntf' (notificação).");
        System.out.println("Usuário: " + retorno.getUsuarioNome());
//        System.out.println("Livro: " + retorno.getLivroTitulo());
        System.out.println("Quantidade notificações (todos livros): " + retorno.getMensagem() + "\n");
    }
}
