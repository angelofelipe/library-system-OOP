package comando.retorno.estado;

import comando.retorno.RetornoComando;

public abstract class Sucesso implements EstadoRetorno {

    public abstract void imprimirRetorno(RetornoComando retornoComando);

    public boolean teveSucesso() { return true; };

}
