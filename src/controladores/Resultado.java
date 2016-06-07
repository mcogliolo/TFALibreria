/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

/**
 *
 * @author Marie
 */

public class Resultado { 
        private boolean resultado;
        private int pixelesDiferentes;
        private int cantidadPixeles;
        
        public Resultado(boolean resultado , int pixelesDiferentes, int cantidadPixeles){
                this.resultado = resultado;
                this.pixelesDiferentes = pixelesDiferentes;
                this.cantidadPixeles = cantidadPixeles;    
        }

    /**
     * @return the resultado
     */
    public boolean isResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the pixelesDiferentes
     */
    public int getPixelesDiferentes() {
        return pixelesDiferentes;
    }

    /**
     * @param pixelesDiferentes the pixelesDiferentes to set
     */
    public void setPixelesDiferentes(int pixelesDiferentes) {
        this.pixelesDiferentes = pixelesDiferentes;
    }

    /**
     * @return the cantidadPixeles
     */
    public int getCantidadPixeles() {
        return cantidadPixeles;
    }

    /**
     * @param cantidadPixeles the cantidadPixeles to set
     */
    public void setCantidadPixeles(int cantidadPixeles) {
        this.cantidadPixeles = cantidadPixeles;
    }     
}
    
    
    
    
   
        





