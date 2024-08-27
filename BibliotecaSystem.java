class BibliotecaSystem {
    private static BibliotecaSystem instance;
    private List<Usuario> usuarios;
    private List<Livro> livros;

    private BibliotecaSystem() {
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
    }

    public static BibliotecaSystem getInstance() {
        if (instance == null) {
            instance = new BibliotecaSystem();
        }
        return instance;
    }

    public void processarComando(String comando) {
        String[] partes = comando.split(" ");
        String acao = partes[0];
        String codigoUsuario = partes[1];
        String codigoLivro = partes.length > 2 ? partes[2] : null;

        Usuario usuario = encontrarUsuarioPorCodigo(codigoUsuario);
        Livro livro = encontrarLivroPorCodigo(codigoLivro);

        Command cmd = null;

        switch (acao) {
            case "emp":
                cmd = new EmprestimoCommand(usuario, livro);
                break;
            case "dev":
                cmd = new DevolucaoCommand(usuario, livro);
                break;
            case "res":
                cmd = new ReservaCommand(usuario, livro);
                break;
            case "obs":
                cmd = new ObservacaoCommand(usuario, livro);
                break;
            case "sai":
                System.out.println("Saindo do sistema...");
                return;
            default:
                System.out.println("Comando não reconhecido.");
                return;
        }

        if (cmd != null) {
            cmd.execute();
        }
    }

    private Usuario encontrarUsuarioPorCodigo(String codigo) {
        // Implementação para encontrar o usuário pelo código
    }

    private Livro encontrarLivroPorCodigo(String codigo) {
        // Implementação para encontrar o livro pelo código
    }

    // Métodos adicionais para gerenciar usuários e livros
}
