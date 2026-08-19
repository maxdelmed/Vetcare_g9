package com.mycompany.proyectofinalveterinaria;

public class Cita {

    private String codigoCita;
    private Mascota mascota;
    private String motivo;
    private String fecha;
    private String hora;
    private String estado;

    public Cita(String codigoCita, Mascota mascota, String motivo,
            String fecha, String hora, String estado) {

        this.codigoCita = codigoCita;
        this.mascota = mascota;
        this.motivo = motivo;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public String getCodigoCita() {
        return codigoCita;
    }

    public Mascota getMascota() {
        return mascota;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {

        return "Codigo cita: " + codigoCita
                + " | Mascota: " + mascota.getNombre()
                + " | Motivo: " + motivo
                + " | Fecha: " + fecha
                + " | Hora: " + hora
                + " | Estado: " + estado;
    }
}