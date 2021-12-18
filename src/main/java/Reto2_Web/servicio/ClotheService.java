/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto2_Web.servicio;

import Reto2_Web.modelo.Clothe;
import Reto2_Web.repositorio.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ClotheService {
    @Autowired
    private ClotheRepository clotheRepository;

    public List<Clothe> getAll() {
        return clotheRepository.getAll();
    }

    public Optional<Clothe> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Clothe create(Clothe accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Clothe update(Clothe clothe){
        if (clothe.getReference()!= null){
            Optional<Clothe> clotheDb = clotheRepository.getClothe(clothe.getReference());
            if (!clotheDb.isEmpty()){
                if (clothe.getReference()!=null){
                    clotheDb.get().setReference(clothe.getReference());
                }
                if (clothe.getCategory()!=null){
                    clotheDb.get().setCategory(clothe.getCategory());
                }
                if (clothe.getSize()!=null){
                    clotheDb.get().setSize(clothe.getSize());
                }
                if (clothe.getDescription()!=null){
                    clotheDb.get().setDescription(clothe.getDescription());
                }
                if (clothe.getPrice()!= 0.0){
                    clotheDb.get().setPrice(clothe.getPrice());
                }
                if (clothe.getQuantity()!=0){
                    clotheDb.get().setQuantity(clothe.getQuantity());
                }
                if (clothe.getPhotography()!=null){
                    clotheDb.get().setPhotography(clothe.getPhotography());
                }
                clotheDb.get().setAvailability(clothe.isAvailability());
                clotheRepository.update(clotheDb.get());
                return clotheDb.get();
            }else{
                return clothe;
            }
        }else{
            return clothe;
        }
    }

    public boolean delete(String reference){
        boolean del = getClothe(reference).map(clothe -> {
            clotheRepository.delete(clothe);
            return true;
        }).orElse(false);
        return del;
    }

    public List<Clothe> getByPrice(double price){
        return clotheRepository.getByPrice(price);
    }

    public List<Clothe> getByDescriptionContains(String description){
        return clotheRepository.getByDescriptionContains(description);
    }
    
    
}
