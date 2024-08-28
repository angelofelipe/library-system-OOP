package comando;

import comando.entrada.Entrada;
import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.EstadoRetorno;
import comando.retorno.estado.FabricaEstadoRetorno;
import geral.Biblioteca;
import geral.Livro;
import usuario.Usuario;

public class ConsultarUsuario implements IComando {
    @Override
    public RetornoComando executar(Entrada entrada) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Usuario usuario = biblioteca.encontrarUsuarioPorCodigo(entrada.getParametro0());

        // Verificação da entrada
        if (usuario == null) {
            RetornoComando retorno = FabricaRetorno.retornarComando();
            EstadoRetorno estadoRetorno = FabricaEstadoRetorno.inSucessoConsultarUsuario();
            String mensagem = "Este usuario não consta no sistema.";
            retorno.setMensagem(mensagem);
            retorno.setEstado(estadoRetorno);
            return retorno;
        }

        return biblioteca.consultarUsuario(usuario);
    }
}
