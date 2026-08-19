package com.mycompany.proyectofinalveterinaria;

public class Mascota {

    private String codigo;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private Dueno dueno;
    private String estadoMedico;

    public Mascota(String codigo, String nombre, String especie,
            String raza, int edad, Dueno dueno, String estadoMedico) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.dueno = dueno;
        this.estadoMedico = estadoMedico;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public String getEstadoMedico() {
        return estadoMedico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public void setEstadoMedico(String estadoMedico) {
        this.estadoMedico = estadoMedico;
    }

    @Override
    public String toString() {

        return "Codigo: " + codigo
                + " | Nombre: " + nombre
                + " | Especie: " + especie
                + " | Raza: " + raza
                + " | Edad: " + edad
                + " | Dueno: " + dueno.getNombre()
                + " | Estado medico: " + estadoMedico;
    }
}