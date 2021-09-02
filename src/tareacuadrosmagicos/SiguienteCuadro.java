
package tareacuadrosmagicos;
/**
 * 
 * @author
 * Luis Roberto Climent Melendez,
 * Mauricio Quijada Jiménez,
 * Juan Miguel Vásquez Aguilar
 * 
 */
public class SiguienteCuadro {
    public SiguienteCuadro(){
        
    }
    
    public boolean validarCuadro(int tamano, int k, int[][] cuadro){
        boolean res=true;
        int columna=k%tamano;
        int fila=k/tamano;
        
        int filasTotales=fila;
        if (columna!=0){
            filasTotales=fila-1;
        }
        
        if(fila>1){
            int[] auxFila = new int[fila];
            
            for (int i1 =0; i1<fila; i1++){
                for (int i2=0; i2<tamano; i2++){
                    auxFila[i1]=auxFila[i1]+cuadro[i1][i2];
                }
            }
            
            for (int i1 =1; i1<fila; i1++){
                if(auxFila[i1]!=auxFila[0]){
                    res=false;
                }
            }
            
            //Checar diagonal 1
            if (filasTotales==tamano){
                int auxd1 = 0;
                for(int i=0; i<tamano; i++){
                    auxd1=auxd1+cuadro[fila-1-i][i];
                }
                if(auxd1!=auxFila[0]){
                    res=false;
                }
                
                int[] auxColumna = new int[tamano];
                for(int i3=0; i3<tamano; i3++){
                    for(int i4=0; i4<fila; i4++){
                        auxColumna[i3]=auxColumna[i3]+cuadro[i4][i3];
                    }
                }
                
                for (int i3 =1; i3<tamano; i3++){
                    if(auxColumna[i3]!=auxFila[0]){
                        res=false;
                    }
                }
            }
            
            // Checar diagonal 2
            if (k==tamano*tamano){
                int diag2=0;
                for(int i=0; i<tamano; i++){
                    diag2=diag2+cuadro[i][i];
                }
                if(diag2!=auxFila[0]){
                    res=false;
                }
            }
        }
        return res;
    }
    
    public int[][] crearCuadro(int tamano, int k, int[][] cuadro, int enteroDisponible){
        int columna=k%tamano;
        int fila=k/tamano;
        int[][] cuadroR = new int[tamano][tamano];
        for(int j=0; j<tamano; j++){
            System.arraycopy(cuadro[j], 0, cuadroR[j], 0, tamano);
        }
        
        if(fila==tamano){
            fila=fila-1;
        }else{
            if(columna==0){
                fila=fila-1;
            }
        }
        if(columna==0){
            columna=tamano-1;
        }else{
            columna=columna-1;
        }
        
        cuadroR[fila][columna]=enteroDisponible;
        return cuadroR;
    }           
}


