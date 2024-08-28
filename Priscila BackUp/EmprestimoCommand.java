class EmprestimoCommand implements Command {
    private Usuario usuario;
    private Livro livro;

    public EmprestimoCommand(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    @Override
    public void execute() {
        if (usuario instanceof AlunoGraduacao || usuario instanceof AlunoPosGraduacao) {
            if (podeEmprestarAluno()) {
                efetivarEmprestimo();
            } else {
                System.out.println("Empréstimo não pode ser realizado para " + usuario.getNome());
            }
        } else if (usuario instanceof Professor) {
            if (podeEmprestarProfessor()) {
                efetivarEmprestimo();
            } else {
                System.out.println("Empréstimo não pode ser realizado para " + usuario.getNome());
            }
        }
    }

    private boolean podeEmprestarAluno() {
        // Regras específicas para Alunos de Graduação e Pós-Graduação
        // (i) Disponibilidade do exemplar
        if (!livro.possuiExemplarDisponivel()) return false;
        // (ii) Usuário não deve estar em dívida
        if (usuario.estaDevedor()) return false;
        // (iii) Obedecer o limite de empréstimos
        if (usuario.getEmprestimosAtuais().size() >= usuario.getLimiteEmprestimos()) return false;
        // (iv) Regras de reserva
        if (livro.getReservas().size() >= livro.getExemplaresDisponiveis() && !livro.isReservadoPeloUsuario(usuario)) {
            return false;
        }
        // (vi) Nenhum empréstimo em curso do mesmo livro
        if (usuario.temEmprestimoDoLivro(livro)) return false;

        return true;
    }

    private boolean podeEmprestarProfessor() {
        // Regras específicas para Professores
        // (i) Disponibilidade do exemplar
        if (!livro.possuiExemplarDisponivel()) return false;
        // (ii) Usuário não deve estar em dívida
        if (usuario.estaDevedor()) return false;

        return true;
    }

    private void efetivarEmprestimo() {
        // Lógica para efetivar o empréstimo do livro
        Exemplar exemplar = livro.getExemplarDisponivel();
        exemplar.setDisponivel(false);
        usuario.adicionarEmprestimo(livro, exemplar);
        System.out.println("Empréstimo realizado com sucesso: " + usuario.getNome() + " - " + livro.getTitulo());
    }
}
