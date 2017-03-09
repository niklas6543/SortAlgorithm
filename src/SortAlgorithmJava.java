import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortAlgorithmJava {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] a = generateArray(10, 100);
		System.out.println(Arrays.toString(a));

		
		System.out.println("sorting up or down?"); String updown =
		input.next();
		  
		if (updown.equals("up")){
			System.out.println("Bubble Sort\n"+Arrays.toString(bubbleSort(a, true)));
			System.out.println("Selection Sort slow\n"+Arrays.toString(selectionSort_slow(a, true)));
			System.out.println("Selection Sort\n"+Arrays.toString(selectionSort(a, true)));
			System.out.println("Insertion Sort\n"+Arrays.toString(insertionSort(a, true))); 
			System.out.println("Quick Sort\n"+Arrays.toString(callQuickSort(a, true)));
		}else if (updown.equals("down")){
			System.out.println("Bubble Sort\n"+Arrays.toString(bubbleSort(a,false)));
			System.out.println("Selection Sort slow\n"+Arrays.toString(selectionSort_slow(a, false)));
			System.out.println("Selection Sort\n"+Arrays.toString(selectionSort(a, false)));
			System.out.println("Insertion Sort\n"+Arrays.toString(insertionSort(a, false))); 
			System.out.println("Quick Sort\n"+Arrays.toString(callQuickSort(a, false)));
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

	public static int[] bubbleSort(final int[] a, boolean up) {
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
				} else if (a[j] < a[j + 1] && !up) {
					h = a[j];
					a[j] = a[j + 1];
					a[j + 1] = h;
					abb = false;
				}
			}

		}
		return a;

	}

	public static int[] delete(final int[] a, int index) {
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
		// im Array b werden die Zahlen in sortierter Reihenfolge aufgesammelt
		int[] b = new int[a.length];
		// in size wird die Anzahl der zu sortierenden Zahlen abgelegt
		int size = a.length;

		for (int i = 0; i < size; i++) {
			int index = 0;

			for (int j = 0; j < a.length; j++) {
				// suche nach der kleinsten Zahl
				if (a[index] > a[j] && up) {
					index = j;
				} else if (a[index] < a[j] && !up) {
					index = j;
				}
			}
			// lege aktuell kleinste Zahl ab
			b[i] = a[index];
			// lÃ¶sche aktuell kleinste Zahl aus meinem unsortierten Array
			a = delete(a, index);

		}
		return b;
	}

	public static int[] selectionSort(final int[] a, boolean up) {
		int minIndex = 0;
		int h;

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[minIndex] > a[j] && up) {
					minIndex = j;
					h = a[i];
					a[i] = a[minIndex];
					a[minIndex] = h;
				} else if (a[minIndex] < a[j] && !up) {
					minIndex = j;
					h = a[i];
					a[i] = a[minIndex];
					a[minIndex] = h;
				}
			}

		}
		return a;
	}

	public static int[] insertionSort(final int[] a, boolean up) {
		int h;
		int refNum;

		for (int i = 0; i < a.length; i++) {
			refNum = a[i];

			if (up) {
				for (int j = i; j > 0 && a[j - 1] > refNum; j--) {
					h = a[j];
					a[j] = a[j - 1];
					a[j - 1] = h;
				}
			} else {
				for (int j = i; j > 0 && a[j - 1] < refNum; j--) {
					h = a[j];
					a[j] = a[j - 1];
					a[j - 1] = h;
				}
			}
		}

		return a;
	}

	public static int[] callQuickSort(final int[]a, boolean up){
		int[] list = a.clone();
		//Beginn am Anfang und am Ende 
		quickSort(list, 0, a.length - 1 , up);
		return list;
	}
	
	private static void quickSort(int[] list, int left, int right, boolean up){
		int partition;
		
		if (left < right && up || left > right && !up) {
			//suche nach pivot
			partition = part(list, left, right);
			//neue Grenze für links und rechts
			quickSort(list, left, partition-1, up);
			quickSort(list, partition+1, right, up);
		
		} 
		
	}
	
	
	
	private static int part(int[] list, int left, int right){
		int i = left;
		//links vom pivot Element
		int j = right-1;
		int h;
		int pivot = list[right];
		
		do {
			//linkes Element größer als pivot 
			while (list[i] <= pivot && i < right) {
				i++;
			}
			//rechtes Element kleiner als pivot 
			while (list[j] >= pivot && i > left) {
				j--;
			}
			
			if (i < j) {
				 h = list[i];
				 list[i] = list[j];
				 list[j] = h;
			}
		//links darf nicht an rechts vorbeilaufen	
		} while (i < j);
			
		if (list[i] > pivot) {
			//tausche pivot mit rechts
			h = list[i];
			list[i] = list[right];
			list[right] = h;
		}
		//gibt die Position des pivot Elementes zurück
		return i;
	}
	

}
