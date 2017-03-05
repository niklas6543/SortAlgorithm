import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

import org.omg.CORBA.PRIVATE_MEMBER;

public class SortAlgorithmJava {
	public static void main(String[] args) {
		int[] a = generateArray(10, 100);
		System.out.println(Arrays.toString(a));
		int[] sorted = bubbleSort(a);
		System.out.println(Arrays.toString(sorted));
	}

	public static int[] generateArray(int anz, int size) {
		int[] a = new int[anz];
		Random rnd = new Random();

		for (int i = 0; i < a.length; i++) {
			a[i] = rnd.nextInt(size);
		}
		return a;
	}

	public static int[] bubbleSort(int[] a) {
		boolean abb = false;
		int h;

		for (int i = 0; i < a.length - 1 && abb == false; i++) {
			abb = true;
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					h = a[j];
					a[j] = a[j + 1];
					a[j + 1] = h;
					abb = false;
				}
			}

		}
		return a;

	}
	public static int[] delete(int[] a, int index) {
		// entfernt ein Element aus dem Array anhand des Index
		int[] newa = new int[a.length - 1];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (i != index) {
				newa[j] = a[i];
				j++;
			}
		}
		
		return newa;
	}

	public static int[] selectionSort_slow(int[] a) {
		//im Array b werden die Zahlen in sortierter Reihenfolge aufgesammelt
		int[] b = new int[a.length];
		//in size wird die Anzahl der zu sortierenden Zahlen abgelegt
		int size = a.length;
		
		for (int i = 0; i < size ; i++) {
			int index = 0;

			for (int j = 0; j < a.length; j++) {
				//suche nach der kleinsten Zahl
				if (a[index] > a[j]) {
					index = j;
				}
			}
			//lege aktuell kleinste Zahl ab
			b[i] = a[index];
			//lösche aktuell kleinste Zahl aus meinem unsortierten Array
			a = delete(a, index);
			System.out.println(Arrays.toString(a));
			
		}
		return b;
	}
	
	public static int[] selectionSort(int[] a){
		int index = 0;
		int minIndex = 0;
		int h;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = index; j < a.length; j++) {
				if (a[minIndex] > a[j]){
					minIndex = j;
				}
			}
			
			h = a[index];
			a[index] = a[minIndex];
			a[minIndex] = h;
			
			index++;
			
		}
		return a;
	}
	
	public static int[] insertionSort(int[] a){
		for (int i = 0; i < a.length; i++) {
			
		}
		
		return a;
	}
	

	
	
/*
	
	public static int[] quickSort(int[] a, int refNumber){
		for (int i = 0; i < a.length; i++) {
			
		}
		return a;
	}
	
	public static int _quickSort(int refNumber, int[] a){
		
		ArrayList<Integer> right = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();
		
		
		for (int i = 0; i < a.length; i++) {
			if (refNumber < a[i]) {
				left.add(a[i]);
			}
			
			if (refNumber > a[i]) {
				right.add(a[i]);
			}
		}
		
		
		return refNumber;
		
	}
	
*/
	

}
