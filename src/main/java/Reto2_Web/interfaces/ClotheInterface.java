/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto2_Web.interfaces;


import Reto2_Web.modelo.Clothe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface ClotheInterface extends MongoRepository<Clothe, String> {

    public List<Clothe> findByPrice(double price);
    public List<Clothe> findByDescriptionContainingIgnoreCase(String description);
    
}
