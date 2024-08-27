class ReservaCommand implements Command {
    private Usuario usuario;
    private Livro livro;

    public ReservaCommand(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    @Override
    public void execute() {
        if (usuario.getReservas().size() < 3 && !usuario.temReservaDoLivro(livro)) {
            livro.adicionarReserva(usuario);
            usuario.adicionarReserva(livro);
            System.out.println("Reserva realizada com sucesso: " + usuario.getNome() + " - " + livro.getTitulo());
        } else {
            System.out.println("Reserva não pode ser realizada para " + usuario.getNome());
        }
    }
}
