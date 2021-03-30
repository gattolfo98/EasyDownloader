/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easydownloader;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author gattolfo
 */
public class MainApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x,y;
        System.out.println("richiesta dati schermo:---------");
        x = getX();
        y = getY();
        System.out.println("avvio applicazione:------");
        new MainGestion(x,y);
    }
    
    public static int getX(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int larghezza = (int) screenSize.getWidth();
        return larghezza;
    }
    public static int getY(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int altezza = (int) screenSize.getHeight();
        return altezza;
    }
    
}
