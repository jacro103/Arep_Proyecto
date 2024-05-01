package edu.eci.arep.domain;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	
	@Id
    /**
     * el atributo id es el nombre del usuario
     */
	@Column(name = "name",unique = true)
	private String id;
    @Column(name = "password")
	private String password;


    public Usuario(){
    }

    public Usuario(String name, String password) {
        this.id = name;
        this.password = password;
    }




    
    public String getId(){
        return this.id;
    }

    
    public String getPassword(){
        return this.password;
    }


    
    public void setId(String name){
        this.id = name;
    }
  
    
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario Usuario = (Usuario) o;
        return Objects.equals(getId(), Usuario.getId());
    }   
    @Override
    public String toString() {
    return String.format("Usuario [id=%s, password=%s]",
    id,password);
    }
}