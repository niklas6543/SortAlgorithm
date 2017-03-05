import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortAlgorithmJava {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		int[] a = generateArray(10, 100);
		System.out.println(Arrays.toString(a));
		
		System.out.println("sorting up or down?");
		String updown = input.next();
		
		if (updown.equals("up")){
			System.out.println("Bubble Sort\n"+Arrays.toString(bubbleSort(a, true)));
			System.out.println("Selection Sort slow\n"+Arrays.toString(selectionSort_slow(a, true)));
			System.out.println("Selection Sort\n"+Arrays.toString(selectionSort(a, true)));
			System.out.println("Insertion Sort\n"+Arrays.toString(insertionSort(a, true)));
		}else if (updown.equals("down")){
			System.out.println("Bubble Sort\n"+Arrays.toString(bubbleSort(a, false)));
			System.out.println("Selection Sort slow\n"+Arrays.toString(selectionSort_slow(a, false)));
			System.out.println("Selection Sort\n"+Arrays.toString(selectionSort(a, false)));
			System.out.println("Insertion Sort\n"+Arrays.toString(insertionSort(a, false)));
		}else{
			System.out.println("error your entry is invalid");
		}
		
	}

	public static int[] generateArray(int anz, int size) {
		int[] a = new int[anz];
		Random rnd = new Random();

		for (int i = 0; i < a.length; i++) {
			a[i] = rnd.nextInt(size);
		}
		return a;
	}

	public static int[] bubbleSort(int[] a, boolean up) {
		boolean abb = false;
		int h;

		for (int i = 0; i < a.length - 1 && abb == false; i++) {
			abb = true;
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1] && up) {
					h = a[j];
					a[j] = a[j + 1];
					a[j + 1] = h;
					abb = false;
				}else if (a[j] < a[j+1] && !up) {
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

	public static int[] selectionSort_slow(int[] a, boolean up) {
		//im Array b werden die Zahlen in sortierter Reihenfolge aufgesammelt
		int[] b = new int[a.length];
		//in size wird die Anzahl der zu sortierenden Zahlen abgelegt
		int size = a.length;
		
		for (int i = 0; i < size ; i++) {
			int index = 0;

			for (int j = 0; j < a.length; j++) {
				//suche nach der kleinsten Zahl
				if (a[index] > a[j] && up) {
					index = j;
				}else if (a[index] < a[j] && !up){
					index = j;
				}
			}
			//lege aktuell kleinste Zahl ab
			b[i] = a[index];
			//lösche aktuell kleinste Zahl aus meinem unsortierten Array
			a = delete(a, index);
		
			
		}
		return b;
	}
	
	public static int[] selectionSort(int[] a, boolean up){
		int minIndex = 0;
		int h;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[minIndex] > a[j] && up){
					minIndex = j;
					h = a[i];
					a[i] = a[minIndex];
					a[minIndex] = h;
				}else if (a[minIndex] < a[j] && !up){
					minIndex = j;
					h = a[i];
					a[i] = a[minIndex];
					a[minIndex] = h;
				}
			}

		}
		return a;
	}
	
	public static int[] insertionSort(int[] a, boolean up){
		int h;
		int refNum;
		
		for (int i = 0; i < a.length; i++) {
			refNum = a[i];
			
			if	(up){
				for (int j = i; j > 0 &&  a[j-1] > refNum; j--) {
					h = a[j];
					a[j] = a[j-1];
					a[j-1] = h;
				}
			}else{
				for (int j = i; j > 0 &&  a[j-1] < refNum; j--) {
					h = a[j];
					a[j] = a[j-1];
					a[j-1] = h;
				}
			}
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
