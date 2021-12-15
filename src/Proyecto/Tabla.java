
package Proyecto;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Tabla implements Serializable{
    private String nombre;
    private String creador;
    private String fecha_creacion;
    private ArrayList <String> Atributos = new ArrayList();
    private ArrayList <String> Values = new ArrayList();
    private String directorio;

    public Tabla(String nombre, String creador, String fecha_creacion) {
        this.nombre = nombre;
        this.creador = creador;
        this.fecha_creacion = fecha_creacion;
    }

    public ArrayList<String> getAtributos() {
        return Atributos;
    }

    public void setAtributos(ArrayList<String> Atributos) {
        this.Atributos = Atributos;
    }

    public ArrayList<String> getValues() {
        return Values;
    }

    public void setValues(ArrayList<String> Values) {
        this.Values = Values;
    }
    
    public void addValue(String v){
        this.Values.add(v);
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }
    
     private static final long SerialVersionUID=444L;
    public Tabla() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }
    
    public void setFechaFormato(Date date){
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        this.fecha_creacion = (sd.format(date));
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    public void addAtributo(String a){
        this.Atributos.add(a);
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
}
