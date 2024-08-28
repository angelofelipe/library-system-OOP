package geral;

import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.FabricaEstadoRetorno;
import usuario.Usuario;

import java.util.HashSet;

public class Biblioteca {
    private static Biblioteca instance;
    private HashSet<Usuario> usuarios;
    private HashSet<Livro> livros;

    private Biblioteca(){
        this.usuarios = new HashSet<>();
        this.livros = new HashSet<>();
    }

    public static Biblioteca getInstance() {
        if (instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }

    // FUNÇÕES QUE SERÃO CHAMADAS PELAS CLASSES DE COMANDO
    // FUNÇÕES GERAIS PARA SEREM UTILIZADAS EM OUTRAS FUNÇÕES
    // IMPLEMENTAR
    public Usuario encontrarUsuarioPorCodigo(String codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equals(codigo))
                return usuario;
        }
        return null;
    }

    //IMPLEMENTAR
    public Livro encontrarLivroPorCodigo(String codigo) {
        for (Livro livro : livros)
            if (livro.getCodigo().equals(codigo))
                return livro;
        return null;
    }

    public RetornoComando emprestarLivro(Usuario usuario, Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        // IMPLEMENTAR LÓGICA DE VERIFICAÇÃO DE RETORNO
        // ADICIONAR INFORMAÇÕES EM RETORNO PARA SEREM IMPRESSAS POR RETORNO
        boolean disponivel = livro.estaDisponivel();
        if (disponivel) {

        } else {
            String mensagem = "Livro indisponível...\n";
            mensagem +=  "Tente outro dia quando alguém poderá ter devolvido um exemplar.\n";
            retorno.setMensagem(mensagem);
            retorno.setUsuario(usuario);
            retorno.setLivro(livro);
            retorno.setEstado(FabricaEstadoRetorno.inSucessoEmprestar());
        }

        return retorno;
    }

    public RetornoComando devolverLivro(Usuario usuario, Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        // IMPLEMENTAR LÓGICA DE VERIFICAÇÃO DE RETORNO
        // ADICIONAR INFORMAÇÕES EM RETORNO PARA SEREM IMPRESSAS POR RETORNO
        return retorno;
    }

    public RetornoComando reservarLivro(Usuario usuario, Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        // IMPLEMENTAR LÓGICA DE VERIFICAÇÃO DE RETORNO
        // ADICIONAR INFORMAÇÕES EM RETORNO PARA SEREM IMPRESSAS POR RETORNO
        return retorno;
    }

    public RetornoComando consultarLivro(Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        // IMPLEMENTAR LÓGICA DE VERIFICAÇÃO DE RETORNO
        // ADICIONAR INFORMAÇÕES EM RETORNO PARA SEREM IMPRESSAS POR RETORNO
        return retorno;
    }

    public RetornoComando consultarUsuario(Usuario usuario) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        // IMPLEMENTAR LÓGICA DE VERIFICAÇÃO DE RETORNO
        // ADICIONAR INFORMAÇÕES EM RETORNO PARA SEREM IMPRESSAS POR RETORNO
        return retorno;
    }

    public RetornoComando consultarNotificacao(Usuario usuario) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        // IMPLEMENTAR LÓGICA DE VERIFICAÇÃO DE RETORNO
        // ADICIONAR INFORMAÇÕES EM RETORNO PARA SEREM IMPRESSAS POR RETORNO
        return retorno;
    }

    public RetornoComando sair() {
        return FabricaRetorno.retornarSair();
    }

}
