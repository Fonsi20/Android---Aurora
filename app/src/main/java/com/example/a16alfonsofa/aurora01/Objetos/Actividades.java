package com.example.a16alfonsofa.aurora01.Objetos;

import java.util.Date;

public class Actividades {
    private int id;
    private String nombreA, descripcionA,tipoA, respuesta;
    private Date fechayhora;

    public Actividades() {
    }

    public Actividades(int id, String nombreA, String descripcionA, String tipoA, String respuesta, Date fechayhora) {
        this.id = id;
        this.nombreA = nombreA;
        this.descripcionA = descripcionA;
        this.tipoA = tipoA;
        this.respuesta = respuesta;
        this.fechayhora = fechayhora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getDescripcionA() {
        return descripcionA;
    }

    public void setDescripcionA(String descripcionA) {
        this.descripcionA = descripcionA;
    }

    public String getTipoA() {
        return tipoA;
    }

    public void setTipoA(String tipoA) {
        this.tipoA = tipoA;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(Date fechayhora) {
        this.fechayhora = fechayhora;
    }
}
