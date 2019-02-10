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
public class Functions {

    public void printSizeOption() {
        System.out.println("Introduce el tamaño del tablero EJ:(10 = tablero de 10x10)  Tamaño minimo 9 --->");
    }

    public void printIterationsOption() {
        System.out.println("Introduce el numero de turnos que durara el programa:");
    }
    
    /*
    Rellena el tablero con la configuración inicial.
    Como no especificabais el estado inicial elegí el patron "acorn"
    por su gran numero de iteraciones hasta que se estabiliza.
    */
    public void fillBoardAcorn(Board board) {                       
        int size = board.getSize();
        int halfSize = (size / 2) - 1;
        Cell[][] cellMatrix = new Cell[size][size];
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                cellMatrix[i][j] = new Cell(false, false);
            }
        }
        cellMatrix[halfSize][halfSize] = new Cell(true, false);
        cellMatrix[halfSize + 1][halfSize + 1] = new Cell(true, false);
        cellMatrix[halfSize + 1][halfSize + 2] = new Cell(true, false);
        cellMatrix[halfSize + 1][halfSize + 3] = new Cell(true, false);
        cellMatrix[halfSize + 1][halfSize - 2] = new Cell(true, false);
        cellMatrix[halfSize + 1][halfSize - 3] = new Cell(true, false);
        cellMatrix[halfSize - 1][halfSize - 2] = new Cell(true, false);
        board.setCell(cellMatrix);
    }
    
    /*
    Recibe el tablero y lo muestra por consola, ademas inica el turno y el 
    numero de celulas vivas.
    */
    public void printBoard(Board board, int iterations) {
        int liveCells = 0;
        for (int i = 0; i < board.getSize(); i++) {
            System.out.println("");
            for (int j = 0; j < board.getSize(); j++) {
                if ((board.getCell()[i][j]).getPresentState() == false) {
                    System.out.print("|");
                    System.out.print(" ");
                    if (j == board.getSize() - 1) {
                        System.out.print("|");
                    }
                } else {
                    System.out.print("|");
                    System.out.print("O");
                    if (j == board.getSize() - 1) {
                        System.out.print("|");
                    }
                    liveCells++;
                }
            }
        }
        System.out.println("");
        System.out.println("Alive Cells: " + liveCells);
        System.out.println("Iteration: " + iterations);
        System.out.println("");
        System.out.println("");
    }
    /*
    Recibe el tablero, comprueba el numero de vecinos de todas las celulas, 
    modifica su estado futuro y realiza los cambios en el tablero
    */
    public void checkCellNeighbours(Board board) {
        boolean auxiliar = false;
        int neighbours = 0;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    if ((board.getCell()[i - 1][j - 1]).getPresentState() == true) {
                        neighbours++;
                    }
                }
                if (i - 1 >= 0) {
                    if ((board.getCell()[i - 1][j]).getPresentState() == true) {
                        neighbours++;
                    }
                }
                if (i - 1 >= 0 && j + 1 < board.getSize()) {
                    if ((board.getCell()[i - 1][j + 1]).getPresentState() == true) {
                        neighbours++;
                    }
                }
                if (j + 1 < board.getSize()) {
                    if ((board.getCell()[i][j + 1]).getPresentState() == true) {
                        neighbours++;
                    }
                }
                if (j - 1 >= 0) {
                    if ((board.getCell()[i][j - 1]).getPresentState() == true) {
                        neighbours++;
                    }
                }
                if (i + 1 < board.getSize() && j - 1 >= 0) {
                    if ((board.getCell()[i + 1][j - 1]).getPresentState() == true) {
                        neighbours++;
                    }
                }
                if (i + 1 < board.getSize()) {
                    if ((board.getCell()[i + 1][j]).getPresentState() == true) {
                        neighbours++;
                    }
                }
                if (i + 1 < board.getSize() && j + 1 < board.getSize()) {
                    if ((board.getCell()[i + 1][j + 1]).getPresentState() == true) {
                        neighbours++;
                    }
                }
                changeCellState(board, i, j, neighbours);
                neighbours = 0;
            }
        }

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                auxiliar = board.getCell()[i][j].getFutureState();
                board.getCell()[i][j].setPresentState(auxiliar);
                board.getCell()[i][j].setFutureState(false);
            }
        }
    }
    /*
    Recibe el tablero la posicion de una celula y el numero de vecinos de la misma.
    segun el numero de vecinos modifica el estado futuro de la celula
    */
    private void changeCellState(Board board, int i, int j, int neighbours) {
        
        if (neighbours == 2 && board.getCell()[i][j].getPresentState() == true) {
            board.getCell()[i][j].setFutureState(true);
        }
        
        if (neighbours == 3) {
            board.getCell()[i][j].setFutureState(true);
        }
        
        if (neighbours != 3 && neighbours != 2) {
            board.getCell()[i][j].setFutureState(false);
        }
    }
}
