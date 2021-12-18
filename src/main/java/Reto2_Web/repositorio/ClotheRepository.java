/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.repositorio;

import Reto2_Web.interfaces.ClotheInterface;
import Reto2_Web.modelo.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class ClotheRepository {
    @Autowired
    private ClotheInterface crudInterface;

    public List<Clothe> getAll() {
        return crudInterface.findAll();
    }

    public Optional<Clothe> getClothe(String reference) {
        return crudInterface.findById(reference);
    }

    public Clothe create(Clothe clothe) {
        return crudInterface.save(clothe);
    }

    public void update(Clothe clothe) {
        crudInterface.save(clothe);
    }

    public void delete(Clothe clothe) {
        crudInterface.delete(clothe);
    }

    public List<Clothe> getByPrice(double price){
        return crudInterface.findByPrice(price);
    }

    public List<Clothe> getByDescriptionContains(String description){
        return crudInterface.findByDescriptionContainingIgnoreCase(description);
    }

}
