/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author E-Commerce
 */
@Data
@Entity
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;
   
    private String nameCustomer;
    
    private String cpfCustomer;
    
    private String email;
    
    private String address;
    
    private Date dateRegister;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idCustomer);
        hash = 19 * hash + Objects.hashCode(this.nameCustomer);
        hash = 19 * hash + Objects.hashCode(this.cpfCustomer);
        hash = 19 * hash + Objects.hashCode(this.email);
        hash = 19 * hash + Objects.hashCode(this.address);
        hash = 19 * hash + Objects.hashCode(this.dateRegister);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.idCustomer, other.idCustomer)) {
            return false;
        }
        if (!Objects.equals(this.nameCustomer, other.nameCustomer)) {
            return false;
        }
        if (!Objects.equals(this.cpfCustomer, other.cpfCustomer)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.dateRegister, other.dateRegister)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer 
                + ", nameCustomer=" + nameCustomer 
                + ", cpfCustomer=" + cpfCustomer 
                + ", email=" + email 
                + ", address=" + address 
                + ", dateRegister=" + dateRegister 
                + '}';
    }
    
    
}
