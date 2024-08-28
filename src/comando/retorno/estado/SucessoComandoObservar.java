package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class SucessoComandoObservar extends Sucesso {
    public void imprimirRetorno(RetornoComando retorno) {
        System.out.println("Sucesso para concluir comando 'obs' (observar).");
        System.out.println("Usuário: " + retorno.getUsuarioNome());
        System.out.println("Livro: " + retorno.getLivroTitulo() + "\n");
    }
}
