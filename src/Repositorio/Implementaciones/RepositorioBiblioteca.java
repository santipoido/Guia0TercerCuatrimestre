package Repositorio.Implementaciones;


import Excepciones.FechaLanzamientoNula;
import Excepciones.IdentificadorDuplicadoExcepcion;
import Excepciones.ItemNoExiste;
import Excepciones.VersionNegativa;
import Modelo.Implementaciones.Expansion;
import Modelo.Implementaciones.Juego;
import Modelo.Interfaces.Media;
import Repositorio.Interfaces.RepositorioInterfaz;
import java.util.ArrayList;
import java.util.Comparator;

public class RepositorioBiblioteca <T extends Media> implements RepositorioInterfaz<T> {
    private ArrayList<T> listaItems;
    private String nombreBiblioteca;

    public RepositorioBiblioteca(String nombreBiblioteca) {
        this.listaItems = new ArrayList<>();
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    @Override
    public String toString() {
        return "RepositorioBiblioteca{" +
                "nombreBiblioteca='" + nombreBiblioteca + '\'' +
                '}';
    }

    public int buscarItem (int id){
        int pos = -1;
        for (T item : listaItems) {
            if(item.getId() == id){
                pos = listaItems.indexOf(item);
                return pos;
            }
        }
        return pos;
    }

    public boolean agregarItem(T item) throws VersionNegativa, FechaLanzamientoNula, IdentificadorDuplicadoExcepcion {
        if (item instanceof Juego) { //Validar la versión en caso de ser Juego
             if (!validarVersion((Juego) item)){
                 throw new VersionNegativa();
             }
        }

        if (item instanceof Expansion) { //Validar la fecha de lanzamiento en caso de ser Expansión
            if (!validarFechaLanzamiento((Expansion) item)){
                throw new FechaLanzamientoNula();
            }
        }

        int pos = buscarItem(item.getId()); //Validar que no exista en la lista
        if (pos != -1){
            throw new IdentificadorDuplicadoExcepcion();
        }
        listaItems.add(item);
        return true;
    }

    public boolean eliminarItem(int id){
        int pos = buscarItem(id);
        if (pos == -1){
            throw new ItemNoExiste();
        }
        listaItems.remove(pos);
        return true;
    }

    public String listarItems(){
        listaItems.sort(Comparator.comparing(T::getTitulo));
        StringBuilder sb = new StringBuilder();
        for (T item : listaItems) {
            sb.append(item.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String filtrarObjetosGenero(String genero){
        StringBuilder sb = new StringBuilder();
        for (T item : listaItems) {
            if (item.getGenero().equalsIgnoreCase(genero)){
                sb.append(item);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public boolean validarVersion(Juego juego){
        return juego.getNumVersion() > 0;
    }

    public boolean validarFechaLanzamiento(Expansion expansion){
        return expansion.getFecha() != null;
    }
}
