package usuario;

public class Professor extends Usuario{
    public Professor(String codigo, String nome) {
        super(codigo, nome, Integer.MAX_VALUE, 7);
    }
}
