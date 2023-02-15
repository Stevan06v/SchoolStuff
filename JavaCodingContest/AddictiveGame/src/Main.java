import javax.imageio.ImageTranscoder;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = Math.floor(1.00 / Math.sin(30*Math.PI/180));
        System.out.println(a);

        while(true){
            String input = sc.nextLine();
            System.out.println(getPositions(input));
        }

    }
    public static String getPositions(String input){
        int[] inputArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        // get rows, cols out of array
        int rows = inputArr[0];
        int cols = inputArr[1];

        System.out.println("Columns: "+ cols);
        System.out.println("Rows: "+ rows);

        int numbOfPos = inputArr[2];
        System.out.println("Positions: " + numbOfPos);

        int[] values = new int[numbOfPos];
        int x = 3;
        int z = 0;

        System.out.println("-----------------");
        // save numbs
        while(x < inputArr.length){
            values[z] = inputArr[x];
            System.out.println("Value "+ z + ": " + values[z]);
            x++;
            z++;
        }
        System.out.println("-----------------");

        int [][] matrix = new int[rows][cols];
        System.out.println("Column Length:" + matrix.length);
        System.out.println("Row Length:" + matrix[0].length);

        int counter = 1;
        System.out.println("");

        System.out.println("Matrix");
        System.out.println("-----------------");

        // an = n for (n >= 1)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length;j++) {
                matrix[i][j] = counter;
                counter++;
            }

        }
        System.out.println(Arrays.deepToString(matrix));

        System.out.println("-----------------");

        int tempcnt = 0;
        // each elem has (x/y)
        int[] positions = new int[values.length * 2];


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int k = 0; k < values.length; k++) {
                    if(matrix[i][j] == values[k]){

                        System.out.println("("+(i+1)+ "/"+ (j+1)+ ")" +": "+ matrix[i][j] + "==" + values[k]);
                        System.out.println(tempcnt);

                        // save y/x value
                        positions[tempcnt] = i+1;
                        positions[tempcnt+1] = j+1;

                        // n + 2
                        tempcnt+=2;
                    }
                }
            }
        }
        return toString(positions);
    }

    public static String toString(int[] arr){

        String str ="";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + " ";
        }
        return str;
    }
}
