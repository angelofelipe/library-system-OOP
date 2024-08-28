package comando;

import comando.entrada.Entrada;
import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;

public class Sair implements IComando {
    @Override
    public RetornoComando executar(Entrada entrada) {
        return FabricaRetorno.retornarSair();
    }
}
