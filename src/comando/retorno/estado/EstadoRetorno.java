package comando.retorno.estado;

import comando.retorno.IRetornoComando;
import comando.retorno.RetornoComando;

import java.util.concurrent.atomic.AtomicBoolean;

public interface EstadoRetorno {
    public void imprimirRetorno(RetornoComando retornoComando);
}
