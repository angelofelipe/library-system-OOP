package comando.retorno;

import comando.retorno.estado.EstadoRetorno;
import geral.Livro;
import usuario.Usuario;

import java.util.concurrent.atomic.AtomicBoolean;

public class RetornoComando implements IRetornoComando {
    protected EstadoRetorno estado;
    protected String mensagem;
    protected Usuario usuario;
    protected Livro livro;

    public RetornoComando(){};

    public void imprimirRetorno(AtomicBoolean bool) {
            estado.imprimirRetorno(this);
    }

    public String getUsuarioNome(){
        return usuario.getNome();
    }

    public String getLivroTitulo() {
        return livro.getTitulo();
    }

    // Geters and Seters
    public EstadoRetorno getEstado() {
        return estado;
    }

    public void setEstado(EstadoRetorno estado) {
        this.estado = estado;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
