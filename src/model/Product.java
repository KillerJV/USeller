/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author E-Commerce
 */
@Data
@Entity
public class Product implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Product;
    
    private String name_Product;
    
    private String brand_Product;
    
    private double weight_product;
    
    private Date purchase_date_product;
    
    private Integer physical_stock;
    
    private Integer minimum_stock;
    
    private double unit_cost_price;
    
    private double total_cost_price;
    
    private double spot_price;
    
    private String supplier_name;
    
    private String transporter_name;
    
    @OneToMany
    private Set<Item_product> item_productList = new HashSet<>();
    
    @ManyToOne
    private Section section;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id_Product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.id_Product, other.id_Product)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "name_Product=" + name_Product 
                + ", brand_Product=" + brand_Product 
                + ", weight_product=" + weight_product 
                + ", purchase_date_product=" + purchase_date_product
                + ", physical_stock=" + physical_stock
                + ", minimum_stock=" + minimum_stock 
                + ", unit_cost_price=" + unit_cost_price
                + ", total_cost_price=" + total_cost_price 
                + ", spot_price=" + spot_price 
                + ", supplier_name=" + supplier_name 
                + ", transporter_name=" + transporter_name 
                + ", item_productList=" + item_productList 
                + ", section=" + section + '}';
    }
    
    
    
    
}
