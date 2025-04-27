public class JAVAscript {

    public static void main(String[] args) {
        int k = 0;
        short [] c = new short [12];
        for (short i = 1; i <= 23; i++){
            if (i % 2 == 1) {c[k] = i; k ++;}
        }
        
        


        float [] x = new float[18];
        for (int i = 0; i < 18; i ++) {
            float r = ((float) Math.random() * (10.0f + 15.0f) - 15.0f);
            x[i] = r;
        }
        
        

        double [][] m = new double[12][18];
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 18; j ++){
                if (c[i] == 7){m[i][j] = (double) Math.sin(Math.pow(Math.log(Math.abs(x[j])),1/3));}
                else if (c[i] == 1 || c[i] == 3 || c[i] == 5 || c[i] == 7 || c[i] == 17 || c[i] == 19) {
                    m[i][j] = Math.pow(Math.pow(Math.E,Math.cos(x[j])),2/Math.pow(4/x[j],1/3));
                }
                else {
                    m[i][j] = Math.cbrt(Math.log(Math.pow(Math.sin(Math.pow(Math.tan((x[j]-2.5f)/25.0f)/2.0f/3.0f, 2)), 2)));
                }
                 
            }
        }
        for (int i = 0; i < 12; i++){
            for (int j = 0; j < 18; j ++){
                if (m[i][j] >= 0f) System.out.printf("%.4f ", m[i][j]);
                else System.out.printf("%.4f", m[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
