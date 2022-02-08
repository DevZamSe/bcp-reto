// Dado un arreglo con los siguientes números [1, 2, 8, 23, 5, 15, 17, 15] mostrar un arreglo solo con números primos y ordenado:
// [2, 5, 17, 23]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    public static final Integer arreglo[] = {1, 2, 8, 23, 5, 15, 17, 15};
    public static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args){
        Arrays.sort(arreglo);
        for (int i = 0; i < arreglo.length; i++) {

            boolean res = validationPrimo(arreglo[i]);
            System.out.println("el numero es :: "+arreglo[i]+ "primo "+ res);

            if (res == true){
                list.add(arreglo[i]);
            }
        }

        System.out.println("laa lista final es :: "+ list);
    }

    private static boolean validationPrimo(int num){
        boolean primo = (num==1)? false: true;
        int divisor = 2;
        while (primo && divisor <= Math.sqrt(num)){
            if(num%divisor == 0){
                primo = false;
            }
            divisor++;
        }
        return primo;
    }
}
