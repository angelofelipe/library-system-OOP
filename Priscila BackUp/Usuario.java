// Classe abstrata para usuários
abstract class Usuario {
    protected String codigo;
    protected String nome;
    protected int limiteEmprestimos;

    public Usuario(String codigo, String nome, int limiteEmprestimos) {
        this.codigo = codigo;
        this.nome = nome;
        this.limiteEmprestimos = limiteEmprestimos;
    }

    public abstract int getTempoEmprestimo();

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }
}

// Subclasse para Aluno de Graduação
class AlunoGraduacao extends Usuario {
    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome, 3);
    }

    @Override
    public int getTempoEmprestimo() {
        return 3; // 3 dias de empréstimo
    }
}

// Subclasse para Aluno de Pós-Graduação
class AlunoPosGraduacao extends Usuario {
    public AlunoPosGraduacao(String codigo, String nome) {
        super(codigo, nome, 4);
    }

    @Override
    public int getTempoEmprestimo() {
        return 5; // 5 dias de empréstimo
    }
}

// Subclasse para Professor
class Professor extends Usuario {
    public Professor(String codigo, String nome) {
        super(codigo, nome, Integer.MAX_VALUE); // Sem limite de empréstimos
    }

    @Override
    public int getTempoEmprestimo() {
        return 7; // 7 dias de empréstimo
    }
}
