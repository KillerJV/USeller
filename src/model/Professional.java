/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author E-Commerce
 */
@Data
@Entity
public class Professional implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessional;

    @Column(length = 60, nullable = false)
    private String nameProfessional;

    @Column(length = 60, nullable = false)
    private String cpf;
    
    private String service;
    
    private String officeHour;

    //@Temporal(value = TemporalType.DATE)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegister;

    @Column(length = 60, nullable = false)
    private String phone;

    @Column(length = 100, nullable = false)
    private String email;
    
    //@OneToOne(cascade = CascadeType.ALL, optional = true)
    private Login login;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idProfessional);
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
        final Professional other = (Professional) obj;
        if (!Objects.equals(this.idProfessional, other.idProfessional)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Professional{" 
                + "nameProfessional=" + nameProfessional 
                + ", cpf=" + cpf 
                + ", service=" + service + '}';
    }
    
    
    
}
