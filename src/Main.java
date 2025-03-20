import Excepciones.IdentificadorDuplicadoExcepcion;
import Excepciones.ItemNoExiste;
import Modelo.Implementaciones.Expansion;
import Modelo.Implementaciones.Juego;
import Repositorio.Implementaciones.RepositorioBiblioteca;
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args){
        Juego j1 = new Juego("FTA 5", "David", "Pelea", 5);
        Expansion e1 = new Expansion("Exp1", "Testeo", "Mundo Abierto", LocalDateTime.of(2025, Month.SEPTEMBER, 10, 21, 0));
        Juego j2 = new Juego("Zula", "John", "Pelea", 3);
        Expansion e2 = new Expansion("Parche 2.0", "DevelopersTeam", "Pruebas", LocalDateTime.of(2024, Month.JULY, 20, 22, 0));
        RepositorioBiblioteca repo = new RepositorioBiblioteca("Libreria Testeo");

        try{
            repo.agregarItem(e1);
        }catch (IdentificadorDuplicadoExcepcion e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            repo.agregarItem(j1);
        }catch (IdentificadorDuplicadoExcepcion e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            repo.agregarItem(j2);
        }catch (IdentificadorDuplicadoExcepcion e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            repo.agregarItem(e2);
        }catch (IdentificadorDuplicadoExcepcion e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nLISTAR ITEMS:\n");
        System.out.println(repo.listarItems());
        System.out.println(repo.filtrarObjetosGenero("Mundo abierto"));

        System.out.println("\nELIMINAR ITEM:\n");
        try{
            System.out.println(repo.eliminarItem(1));
        }catch (ItemNoExiste e){
            System.out.println(e.getMessage());
        }

        System.out.println(repo.listarItems());
        System.out.println(repo);
    }
}