
package tareacuadrosmagicos;

import java.util.Arrays;

/**
 *
 * @authors
 * Luis Roberto Climent Melendez,
 * Mauricio Quijada Jiménez,
 * Juan Miguel Vásquez Aguilar
 * 
 */
public class TareaCuadrosMagicos {

    public static void main(String[] args) {
        
        int tamCuadro=Integer.parseInt(args[0]);
        int totalNumeros = tamCuadro*tamCuadro;
        int[] numerosGenerados = new int[totalNumeros];
        for (int i=1; i<=totalNumeros; i++){
            numerosGenerados[i-1]=i;
        }
        
        int[][] cuadro = new int[tamCuadro][tamCuadro];
        
        BackTrack bt = new BackTrack();
        bt.btCuadros(tamCuadro, 1, cuadro, numerosGenerados);
        
    }   
}
