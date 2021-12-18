/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.controlador;

import Reto2_Web.modelo.Clothe;
import Reto2_Web.servicio.ClotheService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/clothe")
@CrossOrigin("*")
public class ClotheController {
    @Autowired
    private ClotheService clotheService;

    @GetMapping("/all")
    public List<Clothe> getAll() {
        return clotheService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Clothe> getClothe(@PathVariable("reference") String reference) {
        return clotheService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe create(@RequestBody Clothe gadget) {
        return clotheService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update(@RequestBody Clothe gadget) {
        return clotheService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return clotheService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Clothe> getByPrice(@PathVariable("price") double price){
        return clotheService.getByPrice(price);
    }

    @GetMapping("/description/{description}")
    public List<Clothe> getByDescriptionContains(@PathVariable("description") String description){
        return clotheService.getByDescriptionContains(description);
    }

}
