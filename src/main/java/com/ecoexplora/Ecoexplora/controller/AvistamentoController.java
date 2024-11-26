package com.ecoexplora.Ecoexplora.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecoexplora.Ecoexplora.model.AnimaisExtintos;
import com.ecoexplora.Ecoexplora.model.Avistamento;
import com.ecoexplora.Ecoexplora.repository.EcoExploraRepositoryAvistamentos;

@RestController

public class AvistamentoController {
	@Autowired
	EcoExploraRepositoryAvistamentos ecoexploraRepositoryAvistamento;
	
	@GetMapping("/getAllAvistamento")
	public List<Avistamento> getAllAnimais(){
		return ecoexploraRepositoryAvistamento.findAll();
	}
	
    @DeleteMapping("/removeAvistamento/{identity}")
    public boolean deleteRow(@PathVariable("identity") Integer id){
        if(!ecoexploraRepositoryAvistamento.findById(id).equals(Optional.empty())){
        	ecoexploraRepositoryAvistamento.deleteById(id);
            return true;
        }
        return false;
    }
    
    @PutMapping("/updateAvistamento/{identity}")
    public Avistamento updateAnimal(@PathVariable("identity") Integer id,
                                        @RequestBody Map<String, Object> body) {

        Avistamento current = ecoexploraRepositoryAvistamento.findById(id).get();
        
        current.setUser((String) body.get("user"));
        current.setLocal((String) body.get("local"));
        current.setData((String) body.get("data"));
        
        ecoexploraRepositoryAvistamento.save(current);
        
        return current;
    }

    
    @PostMapping("/addAvistamento")
    public Avistamento create(@RequestBody Map<String, Object> body) {

        String user = (String) body.get("user");
        String local = (String) body.get("local");
        String data = (String) body.get("data");

        Avistamento newAvistamento = new Avistamento(user, local, data);

        return ecoexploraRepositoryAvistamento.save(newAvistamento);
    }

}
