package Modelo.Implementaciones;

import Modelo.Interfaces.Media;

public abstract class Item implements Media {
    private String titulo;
    private String creador;
    private String genero;
    private static int cont = 1;
    private int id;

    public Item(String titulo, String creador, String genero) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
        this.id = cont++;
    }

    public Item() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                ", id=" + id +
                        ", ";
    }

    @Override
    public int compareTo(Media otro) {
        if (this.id < otro.getId()) {
            return -1;
        }else if (this.id > otro.getId()){
            return 1;
        }
        return 0;
    }
}
