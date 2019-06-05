/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author E-Commerce
 */

@Data
@Entity
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSale;

    private Integer CodeProduct;

    private String description;

    private Integer amount;

    private Double price;
    
    private Date DateSale; 

    @JoinColumn(name = "id_customer")
    @ManyToOne(optional = false)
    private Customer customer;
    
    @JoinColumn(name = "id_professional")
    @ManyToOne(optional = false)
    private Professional professional;
    
    @ManyToOne
    private Salesman salesman;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idSale);
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
        final Sale other = (Sale) obj;
        if (!Objects.equals(this.idSale, other.idSale)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sale{" + "CodeProduct=" + CodeProduct + ", description=" + description + '}';
    }

}
