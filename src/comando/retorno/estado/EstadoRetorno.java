package comando.retorno.estado;

import comando.retorno.RetornoComando;

public interface EstadoRetorno {
    public void imprimirRetorno(RetornoComando retornoComando);
    public boolean teveSucesso();
}
