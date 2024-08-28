package comando;

import comando.entrada.Entrada;
import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import geral.Biblioteca;
import geral.Livro;
import usuario.Usuario;

public class Emprestar implements IComando {
    @Override
    public RetornoComando executar(Entrada entrada) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Usuario usuario = biblioteca.encontrarUsuarioPorCodigo(entrada.getParametro0());
        Livro livro = biblioteca.encontrarLivroPorCodigo(entrada.getParametro1());
        return biblioteca.emprestarLivro(usuario, livro);
    }
}
