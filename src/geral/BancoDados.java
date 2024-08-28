package geral;

import usuario.AlunoGraduacao;
import usuario.AlunoPosGraduacao;
import usuario.Professor;
import usuario.Usuario;

import java.util.Arrays;
import java.util.HashSet;

public class BancoDados {
    public static void criarBanco(){
        Biblioteca biblioteca = Biblioteca.getInstance();
        Usuario usuario;
        Livro livro;
        Exemplar exemplar;
        HashSet<String> autores;

        // Adicionando Usuarios
        usuario = new AlunoGraduacao("123", "João da Silva");
        biblioteca.addUsuario(usuario);
        usuario = new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues");
        biblioteca.addUsuario(usuario);
        usuario = new AlunoGraduacao("789", "Pedro Paulo");
        biblioteca.addUsuario(usuario);
        usuario = new Professor("100", "Carlos Lucena");
        biblioteca.addUsuario(usuario);

        //Adicionando Livros e Exemplares
        // ADIÇÃO DO PRIMEIRO LIVRO E DE SEU PRIMEIRO EXEMPLAR
        // ADICIONAR TODOS OS EXEMPLARES EM SEGUIDA AO SEU LIVRO, PARA NÃO PERDER A REFERÊNCIA DO LIVRO
        autores = new HashSet<>(Arrays.asList("Ian Sommervile"));
        livro = new Livro("100", "Engenharia de Software", "AddisonWesley", 6,2000, autores);
        biblioteca.addLivro(livro);
        exemplar = new Exemplar("100",livro);
        biblioteca.addExemplar(exemplar);

    }
}
