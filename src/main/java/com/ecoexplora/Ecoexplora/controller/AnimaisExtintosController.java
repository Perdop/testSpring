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
import com.ecoexplora.Ecoexplora.model.Logins;
import com.ecoexplora.Ecoexplora.repository.EcoExploraRepositoryAnimals;

@RestController

public class AnimaisExtintosController {
	@Autowired
	EcoExploraRepositoryAnimals ecoexploraRepositoryAnimals;
	
	@GetMapping("/getAllAnimais")
	public List<AnimaisExtintos> getAllAnimais(){
		return ecoexploraRepositoryAnimals.findAll();
	}
	
    @DeleteMapping("/removeAnimal/{identity}")
    public boolean deleteRow(@PathVariable("identity") Integer id){
        if(!ecoexploraRepositoryAnimals.findById(id).equals(Optional.empty())){
        	ecoexploraRepositoryAnimals.deleteById(id);
            return true;
        }
        return false;
    }
    
    @PutMapping("/updateAnimal/{identity}")
    public AnimaisExtintos updateAnimal(@PathVariable("identity") Integer id,
                                        @RequestBody Map<String, Object> body) {

        AnimaisExtintos current = ecoexploraRepositoryAnimals.findById(id).get();
        
        current.setNome((String) body.get("nome"));
        current.setSobre((String) body.get("sobre"));
        current.setClasse((Integer) body.get("classe"));
        current.setExistentes((Integer) body.get("existentes"));
        current.setEstado((String) body.get("estado"));
        current.setImg((String) body.get("img"));
        
        ecoexploraRepositoryAnimals.save(current);
        
        return current;
    }

    
    @PostMapping("/addAnimal")
    public AnimaisExtintos create(@RequestBody Map<String, Object> body) {

        String nome = (String) body.get("nome");
        String sobre = (String) body.get("sobre");
        Integer classe = (Integer) body.get("classe");
        Integer existentes = (Integer) body.get("existentes");
        String estado = (String) body.get("estado");
        String img = (String) body.get("img");

        AnimaisExtintos newAnimal = new AnimaisExtintos(nome, sobre, classe, existentes, estado, img);

        return ecoexploraRepositoryAnimals.save(newAnimal);
    }

}
