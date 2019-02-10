/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciopractico_hiberus;
import ejerciciopractico_hiberus.Cell;
/**
 *
 * @author A10
 */
public class Board {
    
    private int size;
    private Cell[][] cell;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getCell() {
        return cell;
    }

    public void setCell(Cell[][] cell) {
        this.cell = cell;
    }

    public Board (int size){
        this.size = size;
        this.cell = new Cell[size][size];
    }
}
