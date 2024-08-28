package comando.retorno;

public class FabricaRetorno {
    public static RetornoComando retornarComando() {
        return new RetornoComando();
    }

    public static RetornoComando retornarSair() {
        return new RetornoSair();
    }

}
