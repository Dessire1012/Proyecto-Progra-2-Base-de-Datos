
package Proyecto;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Directorios implements Serializable{
    private File directorio;
    private ArrayList <Usuarios> listaU = new ArrayList();

    public Directorios() {
    }
    
    private static final long SerialVersionUID=444L;

    public Directorios(File directorio, ArrayList listaU) {
        this.directorio = directorio;
        this.listaU = listaU;
    }

    public ArrayList<Usuarios> getListaU() {
        return listaU;
    }

    public void setListaU(ArrayList<Usuarios> listaU) {
        this.listaU = listaU;
    }

    public File getDirectorio() {
        return directorio;
    }

    public void setDirectorio(File directorio) {
        this.directorio = directorio;
    }
    
    public void addU (Usuarios u){
        this.listaU.add(u);
    }

    @Override
    public String toString() {
        return directorio.getName();
    }


}
