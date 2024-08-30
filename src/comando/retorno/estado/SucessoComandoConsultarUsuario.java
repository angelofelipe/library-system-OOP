package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class SucessoComandoConsultarUsuario extends Sucesso {
    public void imprimirRetorno(RetornoComando retorno) {
        System.out.println("Sucesso para concluir comando 'usu' (usuario).");
        System.out.println(retorno.getMensagem() + "\n");
    }
}
