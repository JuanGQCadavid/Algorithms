/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertion.sort;

/**
 *
 * @author udeev
 */
public class InsertionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arrayToSort [] = new int [6];
        
        //Llenamos el Array.
        llenarArray(arrayToSort);
        
        //Ordenamos implementando el Insertion Sort
        
        insertionSort(arrayToSort);
        
        //Imprimimos
        
        imprimir(arrayToSort);
        
        
    }

    private static void llenarArray(int[] arrayToSort) {
        arrayToSort[0] = 5;
        arrayToSort[1] = 2;
        arrayToSort[2] = 4;
        arrayToSort[3] = 6;
        arrayToSort[4] = 1;
        arrayToSort[5] = 3;
            
    }

    private static void insertionSort(int[] arrayToSort) {
        for (int i = 1; i < arrayToSort.length; i++) {
            int key = arrayToSort[i];
            
            int posicionApuntador = i-1;
            
            while(posicionApuntador >= 0 && arrayToSort[posicionApuntador] > key){
                arrayToSort[posicionApuntador + 1] = arrayToSort[posicionApuntador];
                posicionApuntador -= 1;
            }
            
            arrayToSort[posicionApuntador + 1] = key;
            
        }
    }

    private static void imprimir(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i] + " ");
        }
    }
    
    
    
}
