/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4.model;



import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cosmetics")
public class Cosmetics {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String name;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;

}
