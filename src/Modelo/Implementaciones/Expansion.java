package Modelo.Implementaciones;

import java.time.LocalDateTime;

public class Expansion extends Item {
    private LocalDateTime fecha;

    public Expansion(String titulo, String creador, String genero, LocalDateTime fecha) {
        super(titulo, creador, genero);
        this.fecha = fecha;
    }

    public Expansion(){}

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Expansion{" +
                super.toString() +
                "fecha=" + fecha +
                '}';
    }


}
