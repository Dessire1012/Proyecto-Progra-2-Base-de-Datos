
package Proyecto;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdminDirectorio {
     private ArrayList <Directorios> listaDir = new ArrayList();
    private File archivo = null;

    public AdminDirectorio(String path) {
        archivo = new File(path);
    }
    

    public ArrayList<Directorios> getListaDir() {
        return listaDir;
    }

    public void setListaDir(ArrayList<Directorios> listaDir) {
        this.listaDir = listaDir;
    }
    
     public void addListaDir(Directorios Dir) {
        this.listaDir.add(Dir);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    
    public void cargarArchivo() {
        try {            
            listaDir = new ArrayList();
            Directorios temp;
            if (archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Directorios) objeto.readObject()) != null) {
                        listaDir.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
           
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Directorios d : listaDir) {
                bw.writeObject(d);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
    
    
}
