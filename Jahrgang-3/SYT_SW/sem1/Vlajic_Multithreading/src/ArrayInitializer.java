/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jonas Froeller
 */
public class ArrayInitializer {

    private int[][] theArray;
    int rowCount;
    int colCount;

    public static int nextPrime(int num) {
        num++;
        for (int i = 2; i < num; i++) {
            if(num%i == 0) {
                num++;
                i=2;
            }
        }
        return num;
    }

    public int[][] getArray() {
        return theArray.clone();
    }

    public void reset() {
        for (int i = 0; i < rowCount; i++)
            for (int j = 0; j < colCount; j++)
                theArray[i][j] = 0;
    }

    public ArrayInitializer(int rowCount, int colCount) {
        theArray = new int[rowCount][colCount];
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

    public void initSerial() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                theArray[i][j] = nextPrime(i);
            }
        }
    }

    public void initParallel() {

        Runnable thread = () -> {
            for (int i = 0; i < this.rowCount/2; i++) {
                for (int j = 0; j < this.colCount; j++) {
                    theArray[i][j] = nextPrime(j);
                   // System.out.printf("[%d][%d]",i,j);
                }
            }
        };

        Thread thread1 = new Thread(thread);
        thread1.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here


        ArrayInitializer inst = new ArrayInitializer(10000, 200);

        long startTime = new Date().getTime();

        for (int i = 0; i < 2; i++) {
            inst.initParallel();
        }

        long stopTime = new Date().getTime();
        System.out.println("Time elapsed for parallel: " + (stopTime - startTime) + " milliseconds");

        inst.reset();

        startTime = new Date().getTime();
        inst.initSerial();
        stopTime = new Date().getTime();
        System.out.println("Time elapsed for serial: " + (stopTime - startTime) + " milliseconds");


    }
}