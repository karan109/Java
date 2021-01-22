/*input
9
54 7 98 56 100 99 923 9147 1
*/
import java.util.*;
public class heap{
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static boolean sortcheck(int[] arr){
		for(int i=1;i<arr.length-1;i++){
			if(arr[i]>arr[i+1]) return false;
		}
		return true;
	}
	public static void heapify(int[] arr, int start, int n){
		for(int i=n;i>=start;i--){
			int j = i;
			while(true){
				if(2*j>n) break;
				if(2*j == n){
					if(arr[2*j]>arr[j]) swap(arr, 2*j, j); break;
				}
				int k = 2*j;
				if(arr[2*j]<arr[2*j+1]) k++;
				if(arr[j]>=arr[k]) break;
				swap(arr, j, k);
				j = k;
			}
		}
	}
	public static void sort(int[] arr, int start, int n){
		heapify(arr, start, n);
		for(int i=n;i>=1;i--){
			swap(arr, i, 1);
			int j = 1;
			while(true){
				if(2*j>i-1) break;
				if(2*j == i-1){
					if(arr[2*j]>arr[j]) swap(arr, 2*j, j); break;
				}
				int k = 2*j;
				if(arr[2*j]<arr[2*j+1]) k++;
				if(arr[j]>=arr[k]) break;
				swap(arr, j, k);
				j = k;
			}
		}
	}
	public static boolean checkheap(int[] arr, int ind){
		int n = arr.length-1;
		if(ind>n) return true;
		if(2*ind<=n && arr[ind]<arr[2*ind]) return false;
		if(2*ind+1<=n && arr[ind]<arr[2*ind+1]) return false;
		return checkheap(arr, 2*ind) && checkheap(arr, 2*ind+1);
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = 1000003;
		int[] arr = new int[n+1];
		int x = 1;
		for(int i=1;i<=n;i++){
			arr[i] = x;
			x = (x*28)%n;
		}
		System.out.println(checkheap(arr, 1));
		heapify(arr, 1, n);
		System.out.println(checkheap(arr, 1));
		sort(arr, 1, n);
		System.out.println(checkheap(arr, 1));
		System.out.println(sortcheck(arr));
		for(int i=1;i<=Math.min(10, n);i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}