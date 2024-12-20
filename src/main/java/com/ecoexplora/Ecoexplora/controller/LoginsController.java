package com.ecoexplora.Ecoexplora.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecoexplora.Ecoexplora.model.Logins;
import com.ecoexplora.Ecoexplora.repository.EcoexploraRepositoryLogins;

@RestController
public class LoginsController {

	@Autowired
	EcoexploraRepositoryLogins ecoexploraRepository;
	
	@GetMapping("/getAllUsers")
	public List<Logins> getAllUsers(){
		return ecoexploraRepository.findAll();
	}
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<Logins> getUserById(@PathVariable("id") Integer id) {
	    Optional<Logins> user = ecoexploraRepository.findById(id);
	    if (user.isPresent()) {
	        return ResponseEntity.ok(user.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}

	@GetMapping("/getUser/{user}")
	public ResponseEntity<Logins> getUserByUsername(@PathVariable("user") String user) {
	    Optional<Logins> username = ecoexploraRepository.findByUser(user);
	    
	    if (username.isPresent()) {
	        return ResponseEntity.ok(username.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	@GetMapping("/findUser/{user}")
	public boolean findByUsername(@PathVariable("user") String user) {
	    Optional<Logins> username = ecoexploraRepository.findByUser(user);
	    return username.isPresent();
	}


	
    @DeleteMapping("/removeUser/{identity}")
    public boolean deleteRow(@PathVariable("identity") Integer id){
        if(!ecoexploraRepository.findById(id).equals(Optional.empty())){
        	ecoexploraRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    @PutMapping("/updateUser/{identity}")
    public Logins updateAddress(@PathVariable("identity") Integer id,
                                 @RequestBody Map<String, String> body){

        Logins current = ecoexploraRepository.findById(id).get();
        current.setUser(body.get("user"));
        current.setPassword(body.get("password"));
        ecoexploraRepository.save(current);
        return current;
    }
    
    @PostMapping("/addUser")
    public Logins create(@RequestBody Map<String, String> body){

        String user = body.get("user");
        String password = body.get("password");
        Logins newLogins = new Logins(user, password);

        return ecoexploraRepository.save(newLogins);
    }
    
}

