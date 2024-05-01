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
import edu.eci.arep.repository.AdministracionRepository;
import edu.eci.arep.service.AdministracionService;


@Component
@ManagedBean(name = "administracionBean")
@ViewScoped
public class AdministracionBean implements Serializable{
    @Autowired
    private final AdministracionRepository administracionRepository;
    @Autowired
    AdministracionService administracionService;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private Date horario;
    private String observacion;
    private String estado;
    private String firma;
    private EnviarMail envioCorreo;

    private List<Consulta> consultaList;

    public AdministracionBean(AdministracionRepository administracionRepository){
        this.administracionRepository=administracionRepository;
        envioCorreo = new EnviarMail();
    }

    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getCorreo(){
        return correo;
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

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public void setCorreo(String correo){
        this.correo=correo;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setObservacion(String observacion){
        this.observacion=observacion;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    public void setHorario(Date horario){
        this.horario=horario;
    }

    public void setFirma(String firma){
        this.firma=firma;
    }

    public List<Consulta> getConsultaList(){
        consultaList=administracionService.getAllConsulta();
        return consultaList;
    }
    public String agregarConsulta(){
        administracionService.addConsulta(new Consulta(nombre, apellido, correo, telefono, horario, observacion, "AGENDADA",firma));
        envioCorreo.enviarCorreo(correo);
        return "index.xhtml?faces-redirect=true&includeViewParams=true";
    }
}