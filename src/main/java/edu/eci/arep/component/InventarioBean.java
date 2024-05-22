package edu.eci.arep.component;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arep.domain.Consulta;
import edu.eci.arep.domain.Inventario;
import edu.eci.arep.repository.AdministracionRepository;
import edu.eci.arep.repository.InventarioRepository;
import edu.eci.arep.service.InventarioService;

@Component
@ManagedBean(name = "inventarioBean")
@ViewScoped
public class InventarioBean implements Serializable{
    @Autowired
    private final InventarioRepository inventarioRepository;
    @Autowired
    InventarioService inventarioService;

    public String producto;
    private String correo;
    public String unidad;
    public Date horario;
    public String descripcion;
    private String estado;
    private EnviarMail envioCorreo;

    private List<Inventario> inventarioList;

    public InventarioBean(InventarioRepository inventarioRepository){
        this.inventarioRepository=inventarioRepository;
        envioCorreo = new EnviarMail();
    }
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
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

    public List<Inventario> getInventarioList(){
        inventarioList=inventarioService.getAllInventario();
        return inventarioList;
    }
       
    public String agregarInventario(){
        inventarioService.addInventario(new Inventario(producto, correo,  unidad,  horario,  descripcion, "AGENDADA"));
        return "index.xhtml?faces-redirect=true&includeViewParams=true";
    }
}
    

