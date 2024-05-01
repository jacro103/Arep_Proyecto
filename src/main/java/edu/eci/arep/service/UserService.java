package edu.eci.arep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arep.domain.Usuario;
import edu.eci.arep.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public Usuario addUsuario(Usuario usuario) {
		return userRepository.save(usuario);
	}
	
	public Usuario getUsuario(Long userId) {
		return userRepository.findById(userId).get();
	}
	
	public List<Usuario> getAllUsuarios() {
		return userRepository.findAll();
	}
	
	public Usuario updateUsuario(Usuario usuario) {
		if(userRepository.existsById(usuario.getId())) {
			return userRepository.save(usuario);
		}
		
		return null;
	}
	
	public void deleteUsuario(Long userId) {
		userRepository.deleteById(userId);
	}	
}