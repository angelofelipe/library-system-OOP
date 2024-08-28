package comando.entrada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Entrada {
    private String comandoString;
    private List<String> parametros = new ArrayList<String>();

    public Entrada() {}

    public void processarComando(String comando) {
        List<String> partes = Arrays.stream(comando.split(" ")).collect(Collectors.toList());
        comandoString = partes.get(0);
        partes.remove(0);
        if (!partes.isEmpty()) {
            parametros.clear();
            parametros.addAll(partes);
        }
    }

    // Get parâmetros entradas
    public String getComandoString() {
        return comandoString;
    }

    public String getParametro0() {
        return parametros.get(0);
    }

    public String getParametro1() {
        return parametros.get(1);
    }

}
