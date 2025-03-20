package Repositorio.Interfaces;

import Excepciones.FechaLanzamientoNula;
import Excepciones.IdentificadorDuplicadoExcepcion;
import Excepciones.VersionNegativa;

public interface RepositorioInterfaz <T>{
    boolean agregarItem(T item) throws IdentificadorDuplicadoExcepcion, VersionNegativa, FechaLanzamientoNula;
    boolean eliminarItem(int id);
    String listarItems();

}
