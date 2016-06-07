/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
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
        
        public boolean capturarPantallaMaximizada(WebDriver browser, String path){
                
        try {
            browser.manage().window().maximize(); //manege: manipula el browser
            
            Thread.sleep(10000);
		browser.findElement(By.tagName("body")).click();
		Actions action = new Actions(browser);
		action.sendKeys(Keys.F11).perform();
            
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
            
        public boolean capturarPantallaMaxYScroll(WebDriver browser, String path){
                
        try {
            browser.manage().window().maximize(); //manege: manipula el browser
            
            Thread.sleep(10000);
		browser.findElement(By.tagName("body")).click();
		Actions action = new Actions(browser);
		action.sendKeys(Keys.F11).perform();
            
            Robot robot = new Robot(); //maneja mi compu
            robot.mouseMove(450, 450);
            robot.mouseWheel(-500);
            Thread.sleep(1500);
                                    
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
        
        private Resultado compararImagenes(BufferedImage img1, BufferedImage img2, String path) throws IOException {
		boolean isEqual;
                Resultado resultado;
                int cont = 0;
                int pxIgual = 0;
                int pxDiff = 0;
                
                if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
			BufferedImage bi = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_RGB);
                        
			for (int x = 0; x < img1.getWidth(); x++) {
				for (int y = 0; y < img1.getHeight(); y++) {
					if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
						isEqual = false;
						bi.setRGB(x, y, Color.ORANGE.getRGB());
                                                pxDiff++;
					}
                                        cont++;
				}
			}
			ImageIO.write(bi, "png", new File(path));
		} else {
			isEqual = false;
		}
		isEqual = true;
                
                resultado = new Resultado(isEqual, pxDiff, cont);

		return resultado;
	}
        
         private Resultado compararImagenes(BufferedImage img1, BufferedImage img2) throws IOException {
		boolean isEqual;
                Resultado resultado;
                int cont = 0;
                int pxIgual = 0;
                int pxDiff = 0;

		if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
			
			for (int x = 0; x < img1.getWidth(); x++) {
				for (int y = 0; y < img1.getHeight(); y++) {
					if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
						isEqual = false;
						pxDiff++;
					}
                                        cont++;
				}
			}
                } else {
			isEqual = false;
		}

		isEqual = true;
                
                resultado = new Resultado(isEqual, pxDiff, cont);

		return resultado;
	}
         
          public static void crearReporte(String path, String browser1, String browser2, String nombre, String fecha, int pxIgual, int pixDiff) throws IOException {
        
            String fechaYhora = "Fecha: " + fecha.replaceAll(" ", " - Hora: ");
        
            File templateReportes =  new File("src/recursos/templateReportes.html"); 
            String htmlString = FileUtils.readFileToString(templateReportes);
            String htmlReemplazado = htmlString.replaceAll("pxIgual", String.valueOf(pxIgual))
                                           .replaceAll("pxIgual", String.valueOf(pxIgual))
                                           .replaceAll("pxDiff", String.valueOf(pixDiff))
                                           .replaceAll("browser1", browser1)
                                           .replaceAll("browser2", browser2)
                                           .replaceAll("nombre", nombre)
                                           .replaceAll("fecha", fechaYhora);
            File newHtmlFile = new File(path);
            FileUtils.writeStringToFile(newHtmlFile, htmlReemplazado);
            
            
            
        
          }
          
          
         
 }

