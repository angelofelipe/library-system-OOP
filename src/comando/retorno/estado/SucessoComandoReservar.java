package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class SucessoComandoReservar extends Sucesso {
    public void imprimirRetorno(RetornoComando retorno) {
        System.out.println("Sucesso para concluir comando 'res' (reservar).");
        System.out.println("Usuário: " + retorno.getUsuarioNome());
        System.out.println("Livro: " + retorno.getLivroTitulo() + "\n");
    }
}
