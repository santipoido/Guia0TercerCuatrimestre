package Excepciones;

public class FechaLanzamientoNula extends RuntimeException {
    public FechaLanzamientoNula() {

    }

    @Override
    public String getMessage() {
      return "La fecha de lanzamiento esta nula";
    }
}
