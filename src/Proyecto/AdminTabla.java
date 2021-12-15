package Proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminTabla {

    private ArrayList<Tabla> listaT = new ArrayList();
    private File archivo = null;

    public AdminTabla(String path) {
        archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<Tabla> getListaT() {
        return listaT;
    }

    public void setListaT(ArrayList<Tabla> listaT) {
        this.listaT = listaT;
    }

    public void addListaT(Tabla t) {
        this.listaT.add(t);
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            bw.write("#Encabezado;");
            bw.newLine();

            for (Tabla t : listaT) {
                bw.write("Nombre: " + t.getNombre() + ";");
                bw.newLine();
                bw.write("Creador: " + t.getCreador() + ";");
                bw.newLine();
                bw.write("Fecha de creacion: " + t.getFecha_creacion() + ";");
                if (!t.getAtributos().isEmpty()) {
                    bw.newLine();
                    for (String atributo : t.getAtributos()) {
                        bw.write(atributo + ",");
                    }
                }
                if (!t.getValues().isEmpty()) {
                    bw.newLine();
                    bw.newLine();
                    bw.write("Detalle;");
                    bw.newLine();
                    for (String v : t.getValues()) {
                        bw.write(v + ",");
                    }
                }

            }

            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaT = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    sc.next();
                    listaT.add(new Tabla(sc.next(),
                            sc.next(),
                            sc.next()
                    )
                    );
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }

}
