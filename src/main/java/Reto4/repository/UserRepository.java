/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.repository;

import Reto4.model.User;
import Reto4.repository.Interface.UserInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
    @Autowired
    private UserInterface userInterface;
    
    public List<User> getAll(){
        return userInterface.findAll();
    }
    
    public Optional<User> getUser(Integer id){
        return userInterface.findById(id);
    }
    
    public boolean ExisteEmail(String email){
        Optional<User> usuario = userInterface.findByEmail(email);
         
        return usuario.isPresent();
    }
    
    public Optional<User> autenticarUser(String email, String password){
        return userInterface.findByEmailAndPassword(email, password);
    }
    
    public User save(User user){
        return userInterface.save(user);
    }
    
    public void update(User user){
        userInterface.save(user);
    }
    
    public void delete(User user){
        userInterface.delete(user);
    }

     /**
     * This method returns a user by its monthBirthDay
     * @param month
     * @return
     */
    public List<User> getByMonthBirthDay(String month){
        return userInterface.findByMonthBirthtDay(month);
    }
    
}
