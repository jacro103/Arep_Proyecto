package edu.eci.arep.component;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import edu.eci.arep.domain.Usuario;
import edu.eci.arep.repository.UserRepository;
import edu.eci.arep.service.UserService;




@Component
@ManagedBean(name = "loginUser")
@SessionScoped
public class LoginUser implements Serializable{
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    UserService userService;
    
    private String name;
    private String password;

    private List<Usuario> userList;

    public LoginUser(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public String getName(){
        return this.name;
    }


    public String getPassword(){
        return this.password;
    }
    public void setName(String name){
        this.name = name;
    }


    public void setPassword(String password){
        this.password = password;
    }
    public List<Usuario> getUserList(){
        userList=userService.getAllUsuarios();
        return userList;
    }
    public String login(){ 
        Usuario usuario = userRepository.findById(name); 
        if(usuario == null || !usuario.getPassword().equals(password)){ 
            FacesContext.getCurrentInstance().addMessage("@all", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Los Datos No Coinciden",null)); 
            return null; }else{ return "admin.xhtml"; } } 
    
    @Bean 
    public CommandLineRunner establecerUsuarios() throws Exception{ 
        return args -> { userService.addUsuario(new Usuario("jose", "123")); 
        userService.getAllUsuarios().forEach(System.out::println); 
        }; 
    }
}
