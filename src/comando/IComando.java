package comando;

import comando.entrada.Entrada;
import comando.retorno.RetornoComando;

public interface IComando {
    public RetornoComando executar(Entrada entrada);
}
