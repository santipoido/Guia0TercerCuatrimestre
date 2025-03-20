package Excepciones;

public class IdentificadorDuplicadoExcepcion extends Exception {
    public IdentificadorDuplicadoExcepcion() {

    }

    @Override
    public String getMessage() {
      return "El identificador ya existe";
    }
}
