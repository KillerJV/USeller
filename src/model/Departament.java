/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author Vinicius
 */
@Data
@Entity
public class Departament implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepartament;
    
    private String nameDepartament;
    
    @OneToMany
    private Set<Sector> sectorList = new HashSet<>();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idDepartament);
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
        final Departament other = (Departament) obj;
        if (!Objects.equals(this.idDepartament, other.idDepartament)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departament{" + "nameDepartament=" + nameDepartament + ", sectorList=" + sectorList + '}';
    }
    
    
}
