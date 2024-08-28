package comando.retorno.estado;

public class FabricaEstadoRetorno {
    public static EstadoRetorno sucessoReservar(){
        return new SucessoComandoReservar();
    }

    public static EstadoRetorno inSucessoReservar(){
        return new InSucessoComandoReservar();
    }

    public static EstadoRetorno sucessoEmprestar(){
        return new SucessoComandoEmprestar();
    }

    public static EstadoRetorno inSucessoEmprestar(){
        return new InSucessoComandoEmprestar();
    }

    public static EstadoRetorno sucessoDevolver(){
        return new SucessoComandoDevolver();
    }

    public static EstadoRetorno inSucessoDevolver(){
        return new InSucessoComandoDevolver();
    }

    public static EstadoRetorno sucessoConsultarUsuario(){
        return new SucessoComandoConsultarUsuario();
    }

    public static EstadoRetorno inSucessoConsultarUsuario(){
        return new InSucessoComandoConsultarUsuario();
    }

    public static EstadoRetorno sucessoConsultarNotificacao(){
        return new SucessoComandoConsultarNotificacao();
    }

    public static EstadoRetorno inSucessoConsultarNotificacao(){
        return new InSucessoComandoConsultarNotificacao();
    }

    public static EstadoRetorno sucessoConsultarLivro(){
        return new SucessoComandoConsultarLivro();
    }

    public static EstadoRetorno inSucessoConsultarLivro(){
        return new InSucessoComandoConsultarLivro();
    }

    public static EstadoRetorno inSucessoComandoErrado(){
        return new InSucessoComandoErrado();
    }
}
