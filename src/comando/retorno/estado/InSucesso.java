package comando.retorno.estado;

import comando.retorno.RetornoComando;

public abstract class InSucesso implements EstadoRetorno {

    public abstract void imprimirRetorno(RetornoComando retorno);

    public boolean teveSucesso() { return false; };

}
