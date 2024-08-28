import comando.entrada.Entrada;
import comando.retorno.RetornoComando;
import geral.BancoDados;
import geral.Servidor;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        BancoDados.criarBanco();

        AtomicBoolean rodarPrograma = new AtomicBoolean(true);
        Scanner scanner = new Scanner(System.in);
        String line;
        Entrada entrada = new Entrada();
        Servidor servidor = new Servidor();
        RetornoComando retorno = null;

        while (rodarPrograma.get()) {

            System.out.println("Digite um comando: ");
            line = scanner.nextLine();
            entrada.processarComando(line);
            retorno = servidor.invocarComando(entrada);
            retorno.imprimirRetorno(rodarPrograma);

        }

    }

}
