package comando.retorno.estado;

import comando.retorno.RetornoComando;

public class SucessoComandoConsultarLivro extends Sucesso {
    public void imprimirRetorno(RetornoComando retorno) {
        System.out.println("Sucesso para concluir comando 'liv' (livro).");
        System.out.println(retorno.getMensagem() + "\n");
    }
}
