package ejerciciopractico_hiberus;
import ejerciciopractico_hiberus.Functions;
import java.util.Scanner;

/**
 *
 * @author Jesus Navascues Jimenez
 */
public class EjercicioPractico_Hiberus {
    public static void main(String[] args) {
        Functions funciones = new Functions();
        int size = 0;
        int iterations =0;
        Scanner s = new Scanner(System.in);
        funciones.printSizeOption();
        size = s.nextInt();
        while(size<9){
            System.out.println("Tablero demasiado pequeño, tamaño minimo 9 ");
            funciones.printSizeOption();
            size=s.nextInt();
        }
        funciones.printIterationsOption();
        iterations = s.nextInt();
        while(iterations<1){
            System.out.println("El numero de turnos debe ser mayor de 0");
            funciones.printIterationsOption();
            iterations=s.nextInt();
        }
        
        Board board = new Board(size);
        funciones.fillBoardAcorn(board);
        funciones.printBoard(board, 0);
        for(int i=0; i<iterations; i++){
            funciones.checkCellNeighbours(board);
            funciones.printBoard(board, i+1);
        }
    }
}
