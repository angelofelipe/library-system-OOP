package geral;

import comando.retorno.FabricaRetorno;
import comando.retorno.RetornoComando;
import comando.retorno.estado.FabricaEstadoRetorno;
import usuario.LivroObservado;
import usuario.Usuario;

import java.util.HashSet;

public class Biblioteca {
    private static Biblioteca instance;
    private Livro ultimoLivroReservado;
    private final HashSet<Usuario> usuarios;
    private final HashSet<Livro> livros;

    private Biblioteca(){
        this.ultimoLivroReservado = null;
        this.usuarios = new HashSet<>();
        this.livros = new HashSet<>();
    }

    public static Biblioteca getInstance() {
        if (instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }

    // Funções para adicionar dados - BancoDados
    // No futuro podem ser mudadas para serem chamadas por IComando e não hard coded
    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public void addExemplar(Exemplar exemplar) {
        Livro livro = exemplar.getLivro();
        if (temEsteLivro(livro))
            livro.addExemplar(exemplar);
    }

    public boolean temEsteLivro(Livro livro) {
        for (Livro livroLocal : livros)
            if (livroLocal.equals(livro))
                return true;
        return false;
    }

    // Funções intermediárias chamadas por IComando
    public Usuario encontrarUsuarioPorCodigo(String codigo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equals(codigo))
                return usuario;
        }
        return null;
    }

    public Livro encontrarLivroPorCodigo(String codigo) {
        for (Livro livro : livros)
            if (livro.getCodigo().equals(codigo))
                return livro;
        return null;
    }

    // Funções de comando chamadas por IComando
    public RetornoComando emprestarLivro(Usuario usuario, Livro livro) {
        boolean disponivel = livro.estaDisponivel();

        if (disponivel) {
            return usuario.pegarLivroEmprestado(usuario, livro);
        } else {
            RetornoComando retorno = FabricaRetorno.retornarComando();
            retorno.setUsuario(usuario);
            retorno.setLivro(livro);
            String mensagem = "Livro indisponível...";
            mensagem +=  "\n\tTente outro dia quando alguém poderá ter devolvido um exemplar.\n";
            retorno.setMensagem(mensagem);
            retorno.setEstado(FabricaEstadoRetorno.inSucessoEmprestar());
            return retorno;

        }
    }

    public RetornoComando devolverLivro(Usuario usuario, Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();

        if (usuario.estouComEsteLivroEmprestado(livro))
            usuario.devolverExemplarLivro(livro);

        retorno.setUsuario(usuario);
        retorno.setLivro(livro);
        retorno.setEstado(FabricaEstadoRetorno.sucessoDevolver());
        return retorno;
    }

    public RetornoComando reservarLivro(Usuario usuario, Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        retorno.setUsuario(usuario);
        retorno.setLivro(livro);
        String mensagem = "";

        Integer numReservas = usuario.quantasReservas();
        if (numReservas < 3) {
            if (!usuario.tenhoReservaDoLivro(livro)) {
                Reserva reserva = new Reserva(usuario, livro);
                livro.addReserva(reserva);
                usuario.addReserva(reserva);
                retorno.setEstado(FabricaEstadoRetorno.sucessoReservar());

                if (ultimoLivroReservado != null) {
                    if (ultimoLivroReservado.equals(livro))
                        ultimoLivroReservado.updateObservers();
                }
                ultimoLivroReservado = livro;

                return retorno;
            } else {
                mensagem = "Você já possui reserva para este Livro.";
            }
        } else {
            mensagem = "Você já atingiu o número máximo de reservas.";
        }

        retorno.setMensagem(mensagem);
        retorno.setEstado(FabricaEstadoRetorno.inSucessoReservar());
        return retorno;
    }

    public RetornoComando observarLivro(Usuario usuario, Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        livro.addObserver(usuario);
        LivroObservado livroObservado = new LivroObservado(livro);
        usuario.addLivroObservado(livroObservado);

        retorno.setUsuario(usuario);
        retorno.setLivro(livro);
        retorno.setEstado(FabricaEstadoRetorno.sucessoObservar());
        return retorno;
    }

    public RetornoComando consultarLivro(Livro livro) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        String mensagem = livro.toStrinConsulta();
        retorno.setMensagem(mensagem);
        retorno.setLivro(livro);
        retorno.setEstado(FabricaEstadoRetorno.sucessoConsultarLivro());
        return retorno;
    }

    public RetornoComando consultarUsuario(Usuario usuario) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        String mensagem = usuario.toStringConsulta();
        retorno.setMensagem(mensagem);
        retorno.setUsuario(usuario);
        retorno.setEstado(FabricaEstadoRetorno.sucessoConsultarUsuario());
        return retorno;
    }

    public RetornoComando consultarNotificacao(Usuario usuario) {
        RetornoComando retorno = FabricaRetorno.retornarComando();
        Integer qtdNotificacoes = usuario.quantasNotificacoes();
        retorno.setMensagem(qtdNotificacoes.toString());
        retorno.setUsuario(usuario);
        retorno.setEstado(FabricaEstadoRetorno.sucessoConsultarNotificacao());
        return retorno;
    }

    public RetornoComando sair() {
        return FabricaRetorno.retornarSair();
    }

}
