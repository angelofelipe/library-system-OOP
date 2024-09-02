package comando.retorno.estado;

import comando.retorno.RetornoComando;

public abstract class Sucesso implements EstadoRetorno {

    public abstract void imprimirRetorno(RetornoComando retorno);

    public boolean teveSucesso() { return true; };

}
