package comando.retorno;

import java.util.concurrent.atomic.AtomicBoolean;

public class RetornoSair extends RetornoComando {
    @Override
    public void imprimirRetorno(AtomicBoolean bool) {
        bool.set(false);
    }
}
