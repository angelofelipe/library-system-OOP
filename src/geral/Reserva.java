package geral;

import usuario.Usuario;

import java.time.LocalDate;

public class Reserva {
    Usuario usuario;
    Livro livro;
    LocalDate dataReserva;

    public Reserva(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataReserva = LocalDate.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public String toStringComandoUsuario() {
        String mensagem = "";

        mensagem += "\n\tTítulo: " + livro.getTitulo() + "\n";
        mensagem += "\tData em que foi reservado: " + toStringDataReservada() + "\n";

        return mensagem;
    }

    public String toStringDataReservada() {
        return FabricaGeral.dataToString(dataReserva);
    }

}
