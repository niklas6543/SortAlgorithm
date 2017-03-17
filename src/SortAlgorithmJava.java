import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortAlgorithmJava {
	static boolean up;
	static int count = 1;
	
	static long[] timesBubble;
	static long[] timesSelection;
	static long[] timesSelection_slow;
	static long[] timesInsertion;
	static long[] timesQuick;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long start;
		int anz = 10;
		
		timesBubble = new long[anz];
		timesSelection = new long[anz];
		timesSelection_slow = new long[anz];
		timesInsertion = new long[anz];
		timesQuick = new long[anz];
		
		while (count <= anz) {
			int[] a = generateArray(count*100, 1000);
			System.out.println(Arrays.toString(a));

			System.out.println("sorting up or down? | passing: " + count + " | array length: " + count*100 + " elements");
			String updown = input.next();

			if (updown.equals("up")) {
				up = true;
			} else if (updown.equals("down")) {
				up = false;
			} else {
				System.out.println("error your entry is invalid");
				System.exit(0);
			}

			start = System.currentTimeMillis();
			System.out.println("Bubble Sort\n" + Arrays.toString(bubbleSort(a)));
			timesBubble[count-1] = speedCheck(start, System.currentTimeMillis());
			System.out.println("speed: " + speedCheck(start, System.currentTimeMillis()) + " msec");
			System.out.println("-> average: " + average(timesBubble) + " msec\n\n");
			effortClass(timesBubble, count*100);
/*
			start = System.currentTimeMillis();
			System.out.println("Selection Sort slow\n" + Arrays.toString(selectionSort_slow(a)));
			timesSelection_slow[count-1] = speedCheck(start, System.currentTimeMillis());
			System.out.println("speed: " + speedCheck(start, System.currentTimeMillis()) + " msec");
			System.out.println("-> average: " + average(timesSelection_slow) + " msec\n\n");

			start = System.currentTimeMillis();
			System.out.println("Selection Sort\n" + Arrays.toString(selectionSort(a)));
			timesSelection[count-1] = speedCheck(start, System.currentTimeMillis());
			System.out.println("speed: " + speedCheck(start, System.currentTimeMillis()) + " msec");
			System.out.println("-> average: " + average(timesSelection) + " msec\n\n");

			start = System.currentTimeMillis();
			System.out.println("Insertion Sort\n" + Arrays.toString(insertionSort(a)));
			timesBubble[count-1] = speedCheck(start, System.currentTimeMillis());
			System.out.println("speed: " + speedCheck(start, System.currentTimeMillis()) + " msec");
			System.out.println("-> average: " + average(timesInsertion) + " msec\n\n");
			
			start = System.currentTimeMillis();
			System.out.println("Quick Sort\n" + Arrays.toString(callQuickSort(a)));
			timesQuick[count-1] = speedCheck(start, System.currentTimeMillis());
			System.out.println("speed: " + speedCheck(start, System.currentTimeMillis()) + " msec");
			System.out.println("-> average: " + average(timesQuick) + " msec\n\n");*/
			
			System.out.println("#############################################\n\n");
			count++;
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
	
	public static long average(final long[] times){
		//System.out.println(time+" "+anz);
		long averageTime = 0;
		
		for (int i = 0; i < count; i++) {
			averageTime+=times[i];
		}
		
		return averageTime/count;
	}

	public static long speedCheck(long start, long end) {
		return (end - start);
	}
	
	public static void effortClass(long[] times, int elements){
		float[] slope = new float[count];
		
		for (int i = 1; i < count && count > 1; i++) {
			slope[i] = (elements - elements/2)/(times[i] - times[i-1]);
		}
		System.out.println(Arrays.toString(slope));
	}

	public static int[] bubbleSort(final int[] a) {
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

	public static int[] selectionSort_slow(int[] a) {
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
			// lösche aktuell kleinste Zahl aus meinem unsortierten Array
			a = delete(a, index);

		}
		return b;
	}

	public static int[] selectionSort(final int[] a) {
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

	public static int[] insertionSort(final int[] a) {
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

	public static int[] callQuickSort(final int[] a) {
		int[] list = a.clone();
		// Beginn am Anfang und am Ende
		quickSort(list, 0, a.length - 1);
		return list;
	}

	private static void quickSort(int[] list, int left, int right) {
		int partition;

		if (left < right && up || left > right && !up) {
			// suche nach pivot
			partition = part(list, left, right);
			// neue Grenze f�r links und rechts
			quickSort(list, left, partition - 1);
			quickSort(list, partition + 1, right);

		}

	}

	private static int part(int[] list, int left, int right) {
		int i = left;
		// links vom pivot Element
		int j = right - 1;
		int h;
		int pivot = list[right];

		do {
			// linkes Element gr��er als pivot
			while (list[i] <= pivot && i < right) {
				i++;
			}
			// rechtes Element kleiner als pivot
			while (list[j] >= pivot && j > left) {
				j--;
			}

			if (i < j) {
				h = list[i];
				list[i] = list[j];
				list[j] = h;
			}
			// links darf nicht an rechts vorbeilaufen
		} while (i < j);

		if (list[i] > pivot) {
			// tausche pivot mit rechts
			h = list[i];
			list[i] = list[right];
			list[right] = h;
		}
		// gibt die Position des pivot Elementes zur�ck
		return i;
	}

}
