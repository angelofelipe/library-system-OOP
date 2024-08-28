package comando;

import comando.entrada.Entrada;
import comando.retorno.RetornoComando;
import geral.Biblioteca;
import geral.Livro;
import usuario.Usuario;

public class ConsultarLivro implements IComando {
    @Override
    public RetornoComando executar(Entrada entrada) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Livro livro = biblioteca.encontrarLivroPorCodigo(entrada.getParametro0());
        return biblioteca.consultarLivro(livro);
    }
}
