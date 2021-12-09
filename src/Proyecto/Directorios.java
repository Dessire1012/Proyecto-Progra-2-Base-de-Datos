
package Proyecto;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Directorios implements Serializable{
    private File directorio;
    private ArrayList <Usuarios> listaU = new ArrayList();
    private ArrayList <Tabla> Tablas = new ArrayList();

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

    public ArrayList<Tabla> getTablas() {
        return Tablas;
    }

    public void setTablas(ArrayList<Tabla> Tablas) {
        this.Tablas = Tablas;
    }
    
    public void addTabla(Tabla t){
        this.Tablas.add(t);
    }

    @Override
    public String toString() {
        return directorio.getName();
    }


}
