package edu.eci.arep.domain;

import java.util.Objects;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONSULTAS")
public class Consulta {
    @Id
    @Column(name = "CORREO",unique = true)
    public String id;
    @Column(name = "NOMBRE")
    public String nombre;
    @Column(name = "APELLIDO")
    public String apellido;
    @Column(name = "TELEFONO")
    public String telefono;
    @Column(name = "HORARIO")
    public Date horario;
    @Column(name = "OBSERVACION")
    public String observacion;
    @Column(name = "ESTADO")
    public String estado;
    @Column(name = "FIRMA", length = 60000)
    public String firma;

    public Consulta(){
    }

    public Consulta(String nombre, String apellido, String id, String telefono, Date horario, String observacion, String estado,String firma){
        this.nombre=nombre;
        this.apellido=apellido;
        /*
         * El atributo id es el correo con el que se registra la consulta.
         */
        this.id=id;
        this.telefono=telefono;
        this.horario=horario;
        this.observacion=observacion;
        this.estado=estado;
        this.firma=firma;
    }

    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getId(){
        return id;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getObservacion(){
        return observacion;
    }
    public String getEstado(){
        return estado;
    }
    public Date getHorario(){
        return horario;
    }
    public String getFirma(){
        return firma;
    }
    public void setFirma(String firma){
        this.firma=firma;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setObservacio(String observacion){
        this.observacion=observacion;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    public void setHorario(Date horario){
        this.horario=horario;
    }

    public void changeEstadoAtendido(){
        setEstado("ATENDIDO");
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Consulta)) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(getId(), consulta.getId());
    }
}