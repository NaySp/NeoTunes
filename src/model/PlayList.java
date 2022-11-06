package model;
import java.util.Random;

public class PlayList{

    public static final int ROWS = 6;
    public static final int COLUMNS = 6;

    private Random random;
  
    public PlayList(){
        random = new Random();
    }

    public int [][] fillMatriz(){
        
        int matriz[][] = new int[ROWS][COLUMNS];

        for(int i= 0; i<ROWS; i++){
            for(int j= 0; j<COLUMNS; j++){
                matriz[i][j] = random.nextInt(9); 
            }
        }
        return matriz;
    }

    public String generateCode(int opt, int[][]matriz){

        String code = null;
        int acu = 1;
        int acu2 = 1;

        switch (opt) {
            case 1:
                for(int i = matriz.length -1; i >= 0; i++){
                    code += matriz[i][0];
                }
        
                for(int i = 1; i < matriz.length - 1; i++){
                    code += matriz[acu][acu2];
                    acu += 1;
                    acu2 += 1;
                } 

                for(int i = matriz.length - 1; i >= 0; i++){
                    code += matriz[i][matriz.length - 1];
                }
                break;

            case 2:

                for(int i=0;i<2;i++){
                    code+=matriz[0][i];
                }
                for(int j=1;j<5;j++){
                    code+=matriz[j][2];
                } 
                for(int k=5;k<0;k--){
                    code+=matriz[k][3];
                }
                for(int u=3;u>5;u++){
                    code+=matriz[0][u];
                }
                break;
            
            case 3:

                for (int i=5;i>=0;i--){
                    for(int j=5;j>=0;j--){
                        int sum = i+j;
                        if (sum%2!=0){
                            if(sum!=1){
                                code+=matriz[i][j]+" ";
                            }
                        }

                    }
                }
                break;
        }
        return code;

    }

  
}