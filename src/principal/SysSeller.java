package principal;

import preload.PreloadConfig;
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
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
        
        PreloadConfig config = new PreloadConfig();
        config.initialConfig();
        
        
    }
}
