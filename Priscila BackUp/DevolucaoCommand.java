class DevolucaoCommand implements Command {
    private Usuario usuario;
    private Livro livro;

    public DevolucaoCommand(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    @Override
    public void execute() {
        if (usuario.temEmprestimoDoLivro(livro)) {
            Exemplar exemplar = usuario.devolverLivro(livro);
            exemplar.setDisponivel(true);
            System.out.println("Devolução realizada com sucesso: " + usuario.getNome() + " - " + livro.getTitulo());
        } else {
            System.out.println("Devolução não pode ser realizada. Não há empréstimo deste livro para " + usuario.getNome());
        }
    }
}
