package comando.retorno.estado;

import comando.retorno.RetornoComando;

public interface EstadoRetorno {
    public void imprimirRetorno(RetornoComando retorno);
    public boolean teveSucesso();
}
