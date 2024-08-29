package usuario;

import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.FabricaEstadoRetorno;
import geral.Emprestimo;
import geral.Livro;

public class Professor extends Usuario{
    public Professor(String codigo, String nome) {
        super(codigo, nome, Integer.MAX_VALUE, 7);
    }

    public RetornoComando pegarLivroEmprestado(Usuario usuario, Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        retorno.setEstado(FabricaEstadoRetorno.inSucessoEmprestar());
        retorno.setUsuario(usuario);
        retorno.setLivro(livro);

        if (!usuario.eDevedor()) {
            Emprestimo emprestimo = livro.emprestarLivro(usuario);
            if (emprestimo != null){
                emprestimosCorrentes.add(emprestimo);
                seUsuarioTiverReservaRemove(livro);
            } else {
                retorno.setMensagem("Erro inesperado, não foi achado nenhum exemplar.");
                return retorno;
            }

        } else {
            String mensagem = usuario.livrosAtrasados();
            retorno.setMensagem("Você está precisando entregar algum(ns) livro(s): " + mensagem);
            return retorno;
        }

        retorno.setEstado(FabricaEstadoRetorno.sucessoEmprestar());
        return retorno;
    }

}
