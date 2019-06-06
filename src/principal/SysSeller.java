package principal;

import dao.ProfessionalDAO;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Professional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author E-Commerce
 */
public class SysSeller {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Professional p = new Professional();
        Date now = Date.from(Instant.now());
        p.setNameProfessional("TestName666");
        //p.setIdProfessional(1L);
        p.setCpf("TestCpf");
        p.setEmail("TestEmail");
        p.setPhone("TestPhone");
        p.setDateRegister(now);
        p.setOfficeHour("Free");
        
        ProfessionalDAO pdao = new ProfessionalDAO();
        JOptionPane.showMessageDialog(null, "Salvando pessoa");
        p = pdao.salvar(p);
    }
}
