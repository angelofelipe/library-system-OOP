package comando;

public class FabricaComando {
    public static IComando retornarComandoEmprestar() {
        return new Emprestar();
    }

    public static IComando retornarComandoDevolver() {
        return new Devolver();
    }

    public static IComando retornarComandoReservar() {
        return new Reservar();
    }

    public static IComando retornarComandoConsultarLivro() {
        return new ConsultarLivro();
    }

    public static IComando retornarComandoConsultarUsuario() {
        return new ConsultarUsuario();
    }

    public static IComando retornarComandoConsultarNotificacao() {
        return new ConsultarNotificacao();
    }

    public static IComando retornarComandoSair() {
        return new Sair();
    }
}
