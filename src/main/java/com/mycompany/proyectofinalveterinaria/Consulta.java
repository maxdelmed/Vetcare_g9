package com.mycompany.proyectofinalveterinaria;

public class Consulta {

    private String codigoCita;
    private String motivo;
    private String fecha;
    private String hora;

    public Consulta(String codigoCita, String motivo, String fecha, String hora) {
        this.codigoCita = codigoCita;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getCodigoCita() {
        return codigoCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Codigo cita: " + codigoCita
                + " | Motivo: " + motivo
                + " | Fecha: " + fecha
                + " | Hora: " + hora;
    }
}
