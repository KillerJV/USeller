/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author E-Commerce
 */
@Data
@Entity
public class Item_product implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Item_product;
    
    private Integer amount;
    
    private double price_Unit;
    
    @ManyToOne
    private Product product;
    
    @ManyToOne
    private Salesman salesmanList;
    
    
    
    
}
