package Modelo.Implementaciones;

public class Juego extends Item {
    private int numVersion;

    public Juego(String titulo, String creador, String genero, int numVersion) {
        super(titulo, creador, genero);
        this.numVersion = numVersion;
    }

    public Juego(){}

    public int getNumVersion() {
        return numVersion;
    }

    public void setNumVersion(int numVersion) {
        this.numVersion = numVersion;
    }



    @Override
    public String toString() {
        return "Juego{" +
                super.toString()+
                "numVersion=" + numVersion +
                '}';
    }
}
