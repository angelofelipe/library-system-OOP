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
}
