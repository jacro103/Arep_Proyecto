package edu.eci.arep.domain;


import java.util.Objects;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventarios")
public class Inventario {
    @Id
    @Column(name = "CORREO",unique = true)
    public String id;
    @Column(name = "PRODUCTO")
    public String producto;
    @Column(name = "UNIDAD")
    public String unidad;
    @Column(name = "HORA")
    public Date horario;
    @Column(name = "DESCRIPCION")
    public String descripcion;
    @Column(name = "ESTADO")
    public String estado;

    public Inventario(){
    }
    public Inventario(String producto, String id, String unidad, Date horario, String descripcion, String estado){
        this.producto=producto;
        this.id=id;
        this.unidad=unidad;
        this.horario=horario;
        this.descripcion=descripcion;
        this.estado=estado;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void changeEstadoAtendido(){
        setEstado("Consultando");
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Inventario)) return false;
        Inventario inventario = (Inventario) o;
        return Objects.equals(getId(), inventario.getId());
    }
}
