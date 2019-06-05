package principal;

import preload.InitialPreLoad;
import view.TelaLogin;

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
        InitialPreLoad dB = new InitialPreLoad();
        dB.initialDB();
        
        TelaLogin tl = new TelaLogin();
        tl.setVisible(true);
        tl.setResizable(false);
  
    }

}
