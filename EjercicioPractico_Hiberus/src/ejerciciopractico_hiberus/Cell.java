/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopractico_hiberus;

/**
 *
 * @author A10
 */
public class Cell {
    private boolean presentState; //estado presente de la celula
    private boolean futureState;  //estado de la celula en el siguiente turno 
    
    
    public Cell(){
        
    }
    
    public Cell(boolean presentState, boolean futureState) {
        this.presentState = presentState;
        this.futureState = futureState;
    }

    public boolean getPresentState() {
        return presentState;
    }

    public void setPresentState(boolean presentState) {
        this.presentState = presentState;
    }

    public boolean getFutureState() {
        return futureState;
    }

    public void setFutureState(boolean futureState) {
        this.futureState = futureState;
    }
}
