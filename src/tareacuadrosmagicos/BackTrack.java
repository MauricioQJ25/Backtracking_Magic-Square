
package tareacuadrosmagicos;
import java.io.*;
/**
 * 
 * @author
 * Luis Roberto Climent Melendez,
 * Mauricio Quijada Jiménez,
 * Juan Miguel Vásquez Aguilar
 * 
 */
public class BackTrack {
    public static File myObj = new File("CuadrosMagicos.txt");
    public BackTrack(){
        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    public void btCuadros(int tamano, int k, int[][] cuadro, int[] numDisponibles){
        try{
            FileWriter writer = new FileWriter(myObj, true);
            if(k==1){
                writer.write(System.lineSeparator());
                writer.flush();
                writer.write("Cuadros Magicos de tamano " +tamano);
                writer.flush();
                writer.write(System.lineSeparator());
                writer.flush();
            }

            int valAux1=tamano*tamano;
            int valAux2=valAux1-k;
            for(int j1=0; j1<=valAux2; j1++){
                SiguienteCuadro c1 = new SiguienteCuadro();
                int[][] cuadroR;
                cuadroR = c1.crearCuadro(tamano, k, cuadro, numDisponibles[j1]);
                if(c1.validarCuadro(tamano, k, cuadroR)){
                    if(k==valAux1){
                        writer.write(System.lineSeparator());
                        writer.flush();
                        for(int auxP1=0; auxP1<tamano; auxP1++){
                            writer.write("[");
                            writer.flush();
                            for(int auxP2=0; auxP2<tamano; auxP2++){
                                writer.write(" " +cuadroR[auxP1][auxP2] +" ");
                                writer.flush();
                            }
                            writer.write("]");
                            writer.flush();
                            writer.write(System.lineSeparator());
                            writer.flush();
                        }
                        writer.write(System.lineSeparator());
                        writer.flush();
                        //break;
                    }else{
                        int[] numDisponiblesR = new int[numDisponibles.length-1];
                        System.arraycopy(numDisponibles, 0, numDisponiblesR, 0, j1);
                        for(int j2=(j1+1); j2<numDisponibles.length; j2++){
                            numDisponiblesR[j2-1]=numDisponibles[j2];
                        }
                        btCuadros(tamano, k+1, cuadroR, numDisponiblesR);
                    }
                }

            }
        
        }catch(IOException e){
            System.out.println("An error occurred.");
        }     
    }
}
