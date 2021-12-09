package Proyecto;

import java.io.File;
import java.io.Serializable;

public class Usuarios implements Serializable{

    private String nombre;
    private String contraseña;
    private boolean gestionUsuarios;
    private boolean create;
    private boolean select;
    private boolean insert;
    private boolean delete;
    private boolean drop;

    public Usuarios() {
    }

    public Usuarios(String nombre, String contraseña, boolean gestionUsuarios, boolean create, boolean select, boolean insert,
                    boolean delete, boolean drop) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.gestionUsuarios = gestionUsuarios;
        this.create = create;
        this.select = select;
        this.insert = insert;
        this.delete = delete;
        this.drop = drop;
      
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isGestionUsuarios() {
        return gestionUsuarios;
    }

    public void setGestionUsuarios(boolean gestionUsuarios) {
        this.gestionUsuarios = gestionUsuarios;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDrop() {
        return drop;
    }

    public void setDrop(boolean drop) {
        this.drop = drop;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}
