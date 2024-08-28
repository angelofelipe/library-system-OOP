package comando.retorno.estado;

import comando.retorno.IRetornoComando;
import comando.retorno.RetornoComando;

public class InSucessoComandoErrado implements EstadoRetorno {
    public void imprimirRetorno(RetornoComando retornoComando) {
        System.out.println(retornoComando.getMensagem());
    }
}
