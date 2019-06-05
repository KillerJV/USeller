/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preload;


import java.time.Instant;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Customer;
import model.Login;
import model.Product;
import model.Professional;
import model.Sale;
import model.Section;
import util.JpaUtil;

/**
 *
 * @author E-Commerce
 */

public class InitialPreLoad {
    
    
    public void initialDB(){
        
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        Date now = Date.from(Instant.now());
        
        //Set<Sale> saleList = new HashSet<>();
        
        Product product = new Product();
        product.setName_Product("Roteador 8P");
        product.setBrand_Product("MULTILASER");
        product.setWeight_product(3.8);
        product.setPurchase_date_product(Date.from(Instant.now()));
        product.setPhysical_stock(2);
        product.setMinimum_stock(0);
        product.setUnit_cost_price(90.00);
        product.setTotal_cost_price(100.00);
        product.setSpot_price(130.00);
        product.setSupplier_name("MULTILASER LTDA.");
        product.setTransporter_name("PRÓPRIA DA LOJA");
        product.setSection(null);
        
        Product product1 = new Product();
        product1.setName_Product("Roteador 5p");
        product1.setBrand_Product("MULTILASER 2");
        product1.setWeight_product(3.8);
        product1.setPurchase_date_product(Date.from(Instant.now()));
        product1.setPhysical_stock(2);
        product1.setMinimum_stock(0);
        product1.setUnit_cost_price(90.00);
        product1.setTotal_cost_price(100.00);
        product1.setSpot_price(130.00);
        product1.setSupplier_name("MULTILASER LTDA2.");
        product1.setTransporter_name("PRÓPRIA DA LOJA2");
        product1.setSection(null);
        
        Section section = new Section();
        section.setNameSection("rede");
        section.setSector(null);
        
        manager.persist(section);
        
        product.setSection(section);
        section.getProductList().add(product);
        
        product1.setSection(section);
        section.getProductList().add(product1);
        
        
////////////////// CUSTOMER 1 ///////////////////////
        Customer c = new Customer();
        c.setNameCustomer("TestCustomer");
        c.setCpf("123.123.123-12");
        c.setDateRegister(now);
        c.setEmail("testecustomer@hotmail.com");
        c.setPhone("(99)99999-9999");
        
////////////////// CUSTOMER 1 ///////////////////////
        Customer c2 = new Customer();
        c2.setNameCustomer("TestCustomer2");
        c2.setCpf("234.123.123-12");
        c2.setDateRegister(now);
        c2.setEmail("testecustomer@hotmail.com");
        c2.setPhone("(99)99999-9999");
        
/////////////////PROFESSIONAL////////////////////////        
        Professional p = new Professional();
        p.setNameProfessional("TestProfessional");
        p.setCpf("321.321.312-21");
        p.setDateRegister(now);
        p.setEmail("testeprofessional@hotmail.com");
        p.setPhone("(99)99999-9999");
        p.setOfficeHour("08:00 - 17:00");
        p.setService("Vendedor");

////////////////// SALE 1 ///////////////////////        
        Sale sale = new Sale();
        sale.setCodeProduct(200);
        sale.setDescription("Alguma descrição de produto aqui");
        sale.setAmount(2345);
        sale.setPrice(200.00);
        sale.setDateSale(now);
        
////////////////// SALE 2 ///////////////////////        
        Sale sale2 = new Sale();
        sale2.setCodeProduct(200);
        sale2.setDescription("Alguma descrição de produto aqui");
        sale2.setAmount(2345);
        sale2.setPrice(200.00);
        sale2.setDateSale(now);
        
        Login login = new Login();
        login.setUser("killer");
        login.setPassword("dra123");
        
        manager.persist(login);
        
        Login login1 = new Login();
        login1.setUser("Dedrick");
        login1.setPassword("h321");
        
        manager.persist(login1);
        //saleList.add(sale);
        //saleList.add(sale2);
        
        //c.setSaleCollection(saleList);
        sale.setCustomer(c);
        sale2.setCustomer(c2);
        //p.setSaleCollection(saleList);
        sale.setProfessional(p);
        sale2.setProfessional(p);
        
        
        manager.persist(product);
        
        manager.persist(section);
        manager.persist(product1);
        manager.flush();
        
        manager.persist(c);
        manager.persist(c2);
        manager.persist(p);
        manager.persist(sale);
        manager.persist(sale2);
                
        tx.commit();
        //manager.close();
        //JpaUtil.close();
        
        
    }
}
