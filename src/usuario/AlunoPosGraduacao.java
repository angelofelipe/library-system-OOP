package usuario;

import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.FabricaEstadoRetorno;
import geral.Emprestimo;
import geral.Livro;

public class AlunoPosGraduacao extends Usuario{
    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome, 4, 5);
    }

    public RetornoComando pegarLivroEmprestado(Usuario usuario, Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        retorno.setEstado(FabricaEstadoRetorno.inSucessoEmprestar());
        retorno.setUsuario(usuario);
        retorno.setLivro(livro);

        if (!usuario.eDevedor()) {
            if (!chegouLimiteEmprestimos()) {
                Integer exemplaresDisponiveis = livro.quantosExemplaresDisponiveis();
                boolean tenhoReserva = tenhoReservaDoLivro(livro);

                if (exemplaresDisponiveis >= 1 || tenhoReserva) {
                    boolean jaEstouComUmExemplar = estouComEsteLivroEmprestado(livro);
                    if (!jaEstouComUmExemplar) {
                        Emprestimo emprestimo = livro.emprestarLivro(usuario);
                        if (emprestimo != null){
                            emprestimosCorrentes.add(emprestimo);
                            seUsuarioTiverReservaRemove(livro);
                        } else {
                            retorno.setMensagem("Erro inesperado, não foi achado nenhum exemplar.");
                            return retorno;
                        }

                    } else {
                        retorno.setMensagem("Você já está com o livro " + livro.getTitulo() + " emprestado.");
                        return retorno;
                    }

                } else {
                    retorno.setMensagem("Você não tem reserva para este livro, faça uma e aguarde na fila de espera...");
                    return retorno;
                }

            } else {
                retorno.setMensagem("Você já alcançou seu limite de emprestimos que é " + getLimiteEmprestimos() + ".");
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
