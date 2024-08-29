package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class InSucessoComandoConsultarLivro extends InSucesso {
    public void imprimirRetorno(RetornoComando retorno) {

        System.out.println("Insucesso para concluir comando 'liv'(consultar livro).");
        System.out.println("Mensagem de erro: " + retorno.getMensagem() + "\n");

    }
}
