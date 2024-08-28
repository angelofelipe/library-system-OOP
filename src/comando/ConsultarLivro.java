package comando;

import comando.entrada.Entrada;
import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.EstadoRetorno;
import comando.retorno.estado.FabricaEstadoRetorno;
import geral.Biblioteca;
import geral.Livro;

public class ConsultarLivro implements IComando {
    @Override
    public RetornoComando executar(Entrada entrada) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Livro livro = biblioteca.encontrarLivroPorCodigo(entrada.getParametro0());

        // Verificação da entrada
        if (livro == null) {
            RetornoComando retorno = FabricaRetorno.retornarComando();
            EstadoRetorno estadoRetorno = FabricaEstadoRetorno.inSucessoConsultarLivro();
            retorno.setEstado(estadoRetorno);
            String mensagem = "Este livro não consta no sistema.";
            retorno.setMensagem(mensagem);
            return retorno;
        }

        return biblioteca.consultarLivro(livro);
    }
}
