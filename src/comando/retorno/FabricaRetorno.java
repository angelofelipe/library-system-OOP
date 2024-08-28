package comando.retorno;

public class FabricaRetorno {
    public static RetornoComando retornarComando() {
        return new RetornoComando();
    }

    public static RetornoComando retornarSair() {
        return new RetornoSair();
    }

//    public static RetornoComando verificarUsuarioIsNull(Usuario usuario, RetornoComando retorno) {
//        if (usuario == null) {
//            RetornoComando retorno = FabricaRetorno.retornarComando();
//            EstadoRetorno estadoRetorno = FabricaEstadoRetorno.inSucessoEmprestar();
//            String mensagem = "Este usuario não consta no sistema.";
//            retorno.setMensagem(mensagem);
//            retorno.setEstado(estadoRetorno);
//            return retorno;
//        }
//        return retorno;
//    }
//
//    public static RetornoComando verificarLivroIsNull(Livro livro, RetornoComando retorno) {
//
//        return retorno;
//    }
}
