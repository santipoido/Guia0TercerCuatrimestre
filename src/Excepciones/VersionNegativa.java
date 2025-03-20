package Excepciones;

public class VersionNegativa extends RuntimeException {
    public VersionNegativa() {

    }

    @Override
  public String getMessage() {
      return "La version es negativa";
    }
}
