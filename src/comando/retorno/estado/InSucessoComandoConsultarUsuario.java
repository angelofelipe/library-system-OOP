package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class InSucessoComandoConsultarUsuario extends InSucesso {
    public void imprimirRetorno(RetornoComando retorno) {

        System.out.println("Insucesso para concluir comando 'usu'(consultar usuario).");
        System.out.println("Mensagem de erro:\n\t" + retorno.getMensagem() + "\n");

    }
}
