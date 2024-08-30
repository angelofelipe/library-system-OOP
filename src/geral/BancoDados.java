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

        exemplar = new Exemplar("01",livro);
        biblioteca.addExemplar(exemplar);
        exemplar = new Exemplar("02",livro);
        biblioteca.addExemplar(exemplar);


        autores = new HashSet<>(Arrays.asList("Grady Booch", "James Rumbaugh", "Ivar Jacobson"));
        livro = new Livro("101", "UML – Guia do Usuário", "Campus", 7,2000, autores);
        biblioteca.addLivro(livro);

        exemplar = new Exemplar("03",livro);
        biblioteca.addExemplar(exemplar);


        autores = new HashSet<>(Arrays.asList("Steve McConnell"));
        livro = new Livro("200", "Code Complete", "Microsoft Press", 2,2014, autores);
        biblioteca.addLivro(livro);

        exemplar = new Exemplar("04",livro);
        biblioteca.addExemplar(exemplar);


        autores = new HashSet<>(Arrays.asList("Robert Martin"));
        livro = new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", 1,2002, autores);
        biblioteca.addLivro(livro);

        exemplar = new Exemplar("05",livro);
        biblioteca.addExemplar(exemplar);


        autores = new HashSet<>(Arrays.asList("Martin Fowler"));
        livro = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", 1,1999, autores);
        biblioteca.addLivro(livro);

        exemplar = new Exemplar("06",livro);
        biblioteca.addExemplar(exemplar);
        exemplar = new Exemplar("07",livro);
        biblioteca.addExemplar(exemplar);


        autores = new HashSet<>(Arrays.asList("Norman Fenton", "James Bieman"));
        livro = new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", 3,2014, autores);
        biblioteca.addLivro(livro);


        autores = new HashSet<>(Arrays.asList("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"));
        livro = new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", 1,1994, autores);
        biblioteca.addLivro(livro);

        exemplar = new Exemplar("08",livro);
        biblioteca.addExemplar(exemplar);
        exemplar = new Exemplar("09",livro);
        biblioteca.addExemplar(exemplar);


        autores = new HashSet<>(Arrays.asList("Martin Fowler"));
        livro = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", 3,2003, autores);
        biblioteca.addLivro(livro);

    }
}
