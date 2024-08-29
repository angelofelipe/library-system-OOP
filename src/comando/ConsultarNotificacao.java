package comando;

import comando.entrada.Entrada;
import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.EstadoRetorno;
import comando.retorno.estado.FabricaEstadoRetorno;
import geral.Biblioteca;
import usuario.Usuario;

public class ConsultarNotificacao implements IComando {
    @Override
    public RetornoComando executar(Entrada entrada) {
        // Verificação da entrada
        RetornoComando retorno = FabricaRetorno.retornarComando();
        EstadoRetorno estadoRetorno = FabricaEstadoRetorno.inSucessoReservar();
        retorno.setEstado(estadoRetorno);
        if (entrada.primeiroParametroInValido()) {
            retorno.setMensagem("Algum parâmetro em falta...");
            return retorno;
        }

        Biblioteca biblioteca = Biblioteca.getInstance();
        Usuario usuario = biblioteca.encontrarUsuarioPorCodigo(entrada.getParametro0());

        if (usuario == null) {
            String mensagem = "Este usuario não consta no sistema.";
            retorno.setMensagem(mensagem);
            retorno.setEstado(estadoRetorno);
            return retorno;
        }

        return biblioteca.consultarNotificacao(usuario);
    }
}
