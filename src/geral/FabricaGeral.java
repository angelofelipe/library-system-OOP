package geral;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FabricaGeral {
    // Formatar data para o padrão pt-br
    public String dataToString(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
