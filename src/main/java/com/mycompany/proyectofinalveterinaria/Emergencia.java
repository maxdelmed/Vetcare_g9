package com.mycompany.proyectofinalveterinaria;

public class Emergencia {

    private Mascota mascota;
    private String sintomas;
    private String nivelUrgencia;
    private String horaIngreso;

    public Emergencia(Mascota mascota, String sintomas,
            String nivelUrgencia, String horaIngreso) {

        this.mascota = mascota;
        this.sintomas = sintomas;
        this.nivelUrgencia = nivelUrgencia;
        this.horaIngreso = horaIngreso;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public String getSintomas() {
        return sintomas;
    }

    public String getNivelUrgencia() {
        return nivelUrgencia;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    @Override
    public String toString() {

        return "Mascota: " + mascota.getNombre()
                + " | Sintomas: " + sintomas
                + " | Nivel de urgencia: " + nivelUrgencia
                + " | Hora de ingreso: " + horaIngreso;
    }
}