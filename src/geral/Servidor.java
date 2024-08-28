package geral;

import comando.FabricaComando;
import comando.IComando;
import comando.entrada.Entrada;
import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.FabricaEstadoRetorno;

import java.util.HashMap;

public class Servidor {
    private HashMap<String, IComando> comandos;

    public Servidor() {
        comandos = new HashMap<>();
        iniciarComandos();
    }

    public void iniciarComandos() {
        comandos.put("emp", FabricaComando.retornarComandoEmprestar());
        comandos.put("dev", FabricaComando.retornarComandoDevolver());
        comandos.put("res", FabricaComando.retornarComandoReservar());
        comandos.put("liv", FabricaComando.retornarComandoConsultarLivro());
        comandos.put("usu", FabricaComando.retornarComandoConsultarUsuario());
        comandos.put("ntf", FabricaComando.retornarComandoConsultarNotificacao());
        comandos.put("sai", FabricaComando.retornarComandoSair());
    }

    public RetornoComando invocarComando(Entrada entrada) {
        String comandoString = entrada.getComandoString();
        IComando comando = comandos.get(comandoString);

        if (comando != null) {
            return comando.executar(entrada);
        } else {
            RetornoComando retorno = FabricaRetorno.retornarComando();
            retorno.setEstado(FabricaEstadoRetorno.inSucessoComandoErrado());
            retorno.setMensagem("Comando não encontrado.\n");
            return retorno;
        }

    }

}
