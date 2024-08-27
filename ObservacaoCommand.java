class ObservacaoCommand implements Command {
    private Usuario professor;
    private Livro livro;

    public ObservacaoCommand(Usuario professor, Livro livro) {
        this.professor = professor;
        this.livro = livro;
    }

    @Override
    public void execute() {
        livro.adicionarObservador(professor);
        System.out.println("Observação registrada para " + professor.getNome() + " - " + livro.getTitulo());
    }
}
