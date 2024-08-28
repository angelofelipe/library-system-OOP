package comando;

import comando.entrada.Entrada;
import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.EstadoRetorno;
import comando.retorno.estado.FabricaEstadoRetorno;
import geral.Biblioteca;
import geral.Livro;
import usuario.Usuario;

public class ConsultarNotificacao implements IComando {
    @Override
    public RetornoComando executar(Entrada entrada) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Usuario usuario = biblioteca.encontrarUsuarioPorCodigo(entrada.getParametro0());
        Livro livro = biblioteca.encontrarLivroPorCodigo(entrada.getParametro1());

        // Verificação da entrada
        RetornoComando retorno = FabricaRetorno.retornarComando();
        EstadoRetorno estadoRetorno = FabricaEstadoRetorno.inSucessoConsultarNotificacao();

        if (usuario == null) {
            String mensagem = "Este usuario não consta no sistema.";
            retorno.setMensagem(mensagem);
            retorno.setEstado(estadoRetorno);
            return retorno;
        } else if (livro == null) {
            String mensagem = "Este livro não consta no sistema.";
            retorno.setMensagem(mensagem);
            retorno.setEstado(estadoRetorno);
            return retorno;
        }

        return biblioteca.consultarNotificacao(usuario);
    }
}
