package Excepciones;

public class ItemNoExiste extends RuntimeException {
    public ItemNoExiste() {

    }

    @Override
    public String getMessage() {
      return "El item no existe";
    }
}
