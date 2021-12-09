
package Proyecto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tabla implements Serializable{
    private String nombre;
    private String creador;
    private String fecha_creacion;

    public Tabla(String nombre, String creador, String fecha_creacion) {
        this.nombre = nombre;
        this.creador = creador;
        this.fecha_creacion = fecha_creacion;
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

    @Override
    public String toString() {
        return "Tabla{" + "nombre=" + nombre + ", creador=" + creador + ", fecha_creacion=" + fecha_creacion + '}';
    }
    
    
}
