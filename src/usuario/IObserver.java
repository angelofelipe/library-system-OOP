package usuario;

import geral.Livro;

public interface IObserver {
    public void addLivroObservado(LivroObservado livroObservado);
    public void updateObservadorLivro(Livro livro);
}
