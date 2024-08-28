package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class InSucessoComandoErrado extends InSucesso {
    public void imprimirRetorno(RetornoComando retorno) {
        System.out.print("Insucesso para concluir comando '");
        System.out.println(retorno.getMensagem() + "'(" + retorno.getMensagem() + ").");
        System.out.println("Comando não encontrado, tente novamente...\n");
    }
}
