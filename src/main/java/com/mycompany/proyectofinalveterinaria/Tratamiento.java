package com.mycompany.proyectofinalveterinaria;

public class Tratamiento {

    private String codigo;
    private Mascota mascota;
    private String medicamento;
    private String dosis;
    private String duracion;
    private String veterinarioResponsable;

    public Tratamiento(String codigo, Mascota mascota, String medicamento,
            String dosis, String duracion, String veterinarioResponsable) {

        this.codigo = codigo;
        this.mascota = mascota;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.duracion = duracion;
        this.veterinarioResponsable = veterinarioResponsable;
    }

    public String getCodigo() {
        return codigo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getVeterinarioResponsable() {
        return veterinarioResponsable;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + " | Mascota: " + mascota.getNombre()
                + " | Medicamento: " + medicamento
                + " | Dosis: " + dosis
                + " | Duracion: " + duracion
                + " | Veterinario: " + veterinarioResponsable;
    }
}
