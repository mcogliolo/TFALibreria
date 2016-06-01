/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Agustin
 */
public class ManupuladorIMG {
    public boolean capturarPantalla(WebDriver browser, String path){
                
        try {
            Robot robot = new Robot(); //maneja mi compu
                        
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rectangle = new Rectangle(dimension);
            BufferedImage image = robot.createScreenCapture(rectangle); //guardo la captura en la variable dinamica
            
            ImageIO.write(image, "png", new File(path)); //llamo al metodo write de la clase estatica IO

            return true; 
            
        } catch (AWTException ex) {
            System.out.println("No se encontro un dispositivo gráfico)");
            return false;
        } catch (IOException ex) {
            System.out.println("No se puede guardar la imagen en " + path);
            return false;
        } catch (Exception ex) {
            System.out.println("Error inesperado");
            return false;
        }
 }
}
