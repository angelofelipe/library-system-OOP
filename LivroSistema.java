class Livro {
    private String codigo;
    private String titulo;
    private String editora;
    private String autores;
    private int edicao;
    private int anoPublicacao;
    private List<Exemplar> exemplares;

    public Livro(String codigo, String titulo, String editora, String autores, int edicao, int anoPublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
        this.exemplares = new ArrayList<>();
    }

    public void adicionarExemplar(Exemplar exemplar) {
        exemplares.add(exemplar);
    }

    // Métodos para gerenciar empréstimos, reservas, etc.
}

class Exemplar {
    private String codigoExemplar;
    private boolean disponivel;

    public Exemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
