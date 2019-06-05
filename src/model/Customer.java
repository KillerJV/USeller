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
import javax.persistence.*;
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

    @Column(length = 60, nullable = false)
    private String nameCustomer;

    @Column(length = 60, nullable = false, unique = true)
    private String cpf;
    
    //@Temporal(TemporalType.DATE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegister;

    @Column(length = 60, nullable = false)
    private String phone;

    @Column(length = 100, nullable = false)
    private String email;

    @Transient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Sale> saleCollection = new HashSet<>();


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.idCustomer);
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
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "nameCustomer=" + nameCustomer + ", cpf=" + cpf + '}';
    }

}
