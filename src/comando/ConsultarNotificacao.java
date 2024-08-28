package comando;

import comando.entrada.Entrada;
import comando.retorno.RetornoComando;
import geral.Biblioteca;
import usuario.Usuario;

public class ConsultarNotificacao implements IComando {
    @Override
    public RetornoComando executar(Entrada entrada) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Usuario usuario = biblioteca.encontrarUsuarioPorCodigo(entrada.getParametro0());
        return biblioteca.consultarNotificacao(usuario);
    }
}
