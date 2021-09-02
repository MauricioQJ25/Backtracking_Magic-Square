/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareacuadrosmagicos;

import java.util.Arrays;

/**
 *
 * @author Saturn
 */
public class TareaCuadrosMagicos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int tamCuadro=Integer.parseInt(args[0]);
        int totalNumeros = tamCuadro*tamCuadro;
        int[] numerosGenerados = new int[totalNumeros];
        for (int i=1; i<=totalNumeros; i++){
            numerosGenerados[i-1]=i;
        }
        
        int[][] cuadro = new int[tamCuadro][tamCuadro];
        
        BackTrack bt = new BackTrack();
        bt.btCuadros(tamCuadro, 1, cuadro, numerosGenerados);
        
        /*
        int[][] cuadro = new int[tamCuadro][tamCuadro];
        SiguienteCuadro c1 = new SiguienteCuadro();
        cuadro = c1.crearCuadro(tamCuadro, 3, cuadro, 10);
        System.out.println(cuadro[1][1]);
        */
        
        /*
        SiguienteCuadro c1 = new SiguienteCuadro();
        int[][] cuadro = new int[3][3];
        cuadro[0][0]=7;
        cuadro[0][1]=14;
        cuadro[0][2]=9;
        cuadro[1][0]=11;
        cuadro[1][1]=6;
        cuadro[1][2]=13;
        cuadro[2][0]=12;
        cuadro[2][1]=10;
        cuadro[2][2]=8;
        
        System.out.println(c1.validarCuadro(3,9,cuadro));
        */
    }
    
}
