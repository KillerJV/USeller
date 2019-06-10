/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preload;

import dao.LoginJpaDAO;
import dao.ProfessionalJpaDAO;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Login;
import model.Professional;

/**
 *
 * @author E-Commerce
 */
public class PreloadConfig {

    public void initialConfig() {

        Professional p = new Professional();
        
        Login login = new Login();
        ProfessionalJpaDAO pdao1 = ProfessionalJpaDAO.getInstance();
        LoginJpaDAO dAO = LoginJpaDAO.getInstance();

        Date now = Date.from(Instant.now());

        p.setNameProfessional("TestName666");
        p.setCpf("TestCpf");
        p.setEmail("TestEmail");
        p.setPhone("TestPhone");
        p.setDateRegister(now);
        p.setOfficeHour("Free");
        p.setService("vendante");

        pdao1.persist(p);

        login.setUserLogin("killer");
        login.setPassword("123666");

        login.setProfessional(p);
        p.setLogin(login);

        JOptionPane.showMessageDialog(null, "Salvando pessoa");

        dAO.persist(login);
    }
}
