/*input

*/
import java.util.*;
public class radix{
	static Random rand;
	public static boolean sortcheck(int[] arr){
		for(int i=1;i<arr.length;i++){
			if(arr[i]<arr[i-1]) return false;
		}
		return true;
	}
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static int getBit(int n, int x){
		if(((1<<x) & n) != 0) return 1;
		return 0;
	}
	public static void sort(int[] arr, int ind, int beg, int end){
		if(ind < 0) return;
		if(beg >= end) return;
		int i = beg, j = end;
		while(true){
			while(i<=end && getBit(arr[i], ind) == 0) i++;
			while(j>=beg && getBit(arr[j], ind) == 1) j--;
			if(i<=j) swap(arr, i, j);
			else break;
		}
		sort(arr, ind-1, beg, j);
		sort(arr, ind-1, i, end);
	}
	public static void lsb(int[] arr){
		int n = arr.length;
		int[] a1 = new int[n];
		for(int i=0;i<=30;i++){
			int j = 0, k = n-1;
			for(int f=0;f<n;f++){
				if(getBit(arr[f], i) == 0) a1[j++] = arr[f];
				else a1[k--] = arr[f];
			}
			for(int f=0;f<j;f++) arr[f] = a1[f];
			for(int f=j;f<n;f++) arr[f] = a1[n-1-f+j];
			a1 = null;
		}
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		rand = new Random();
		int n = 10000000;
		// int arr[] = {5, 7, 8, 2, 3};
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = rand.nextInt(2000000000);
		}
		sort(arr, 30, 0, n-1);
		// lsb(arr);
		System.out.println(sortcheck(arr));
		// for(int i=0;i<n;i++){
		// 	System.out.print(arr[i]+" ");
		// }
		// System.out.println();
	}
}