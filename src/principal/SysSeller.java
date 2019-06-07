package principal;

import dao.LoginDAO;
import dao.ProfessionalDAO;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Login;
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
        Login login = new Login();
        ProfessionalDAO pdao1 = new ProfessionalDAO();
        LoginDAO dAO = new LoginDAO();
        
        Date now = Date.from(Instant.now());
        
        p.setNameProfessional("TestName666");
        p.setCpf("TestCpf");
        p.setEmail("TestEmail");
        p.setPhone("TestPhone");
        p.setDateRegister(now);
        p.setOfficeHour("Free");
        p.setService("vendante");
        
        pdao1.salvar(p);
        
        login.setUserLogin("killer");
        login.setPassword("123666");
        
        login.setProfessional(p);
        p.setLogin(login);
        
        JOptionPane.showMessageDialog(null, "Salvando pessoa");
        
        
        dAO.salvar(login);
       
        
    }
}
