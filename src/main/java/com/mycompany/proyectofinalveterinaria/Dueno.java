package com.mycompany.proyectofinalveterinaria;

public class Dueno {

    private String identificacion;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correo;

    public Dueno(String identificacion, String nombre, String telefono,
            String direccion, String correo) {

        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Identificacion: " + identificacion
                + " | Nombre: " + nombre
                + " | Telefono: " + telefono
                + " | Direccion: " + direccion
                + " | Correo: " + correo;
    }
}