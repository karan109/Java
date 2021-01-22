/*input

*/
import java.util.*;
public class compare{
	static Random rand;
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static boolean sortcheck(int[] arr){
		for(int i=1;i<arr.length;i++){
			if(arr[i]<arr[i-1]) return false;
		}
		return true;
	}
	public static void quick(int[] arr, int beg, int end){
		if(beg >= end) return;
		int ind = rand.nextInt(end-beg+1)+beg;
		boolean same = true;
		for(int i=beg;i<end;i++){
			if(arr[i] != arr[i+1]) same = false;
		}
		if(same) return;
		swap(arr, ind, end);
		int i = beg, j = end-1;
		while(true){
			while(i<end && arr[i]<arr[end]) i++;
			while(j>=beg && arr[j]>=arr[end]) j--;
			if(i<=j) swap(arr, i, j);
			else break;
		}
		swap(arr, i, end);
		quick(arr, beg, i-1);
		quick(arr, i+1, end);
	}
	public static void merge(int[] arr, int beg, int end){
		if(beg >= end) return;
		int mid = (beg+end)/2;
		merge(arr, beg, mid);
		merge(arr, mid+1, end);
		int[] ans = new int[end-beg+1];
		int i = beg, j = mid+1, k = 0;
		while(i<=mid || j<=end){
			if(i<=mid && j <= end && k <= end){
				if(arr[i]<=arr[j]) ans[k++] = arr[i++];
				else ans[k++] = arr[j++];
			}
			else if(i>mid) ans[k++] = arr[j++];
			else ans[k++] = arr[i++];
		}
		for(int f=beg;f<=end;f++) arr[f] = ans[f-beg];
		ans = null;
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
	public static void heap(int[] arr, int start, int n){
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
	public static int getBit(int n, int x){
		if(((1<<x) & n) != 0) return 1;
		return 0;
	}
	public static void msb(int[] arr, int ind, int beg, int end){
		if(ind < 0) return;
		if(beg >= end) return;
		int i = beg, j = end;
		while(true){
			while(i<=end && getBit(arr[i], ind) == 0) i++;
			while(j>=beg && getBit(arr[j], ind) == 1) j--;
			if(i<=j) swap(arr, i, j);
			else break;
		}
		msb(arr, ind-1, beg, j);
		msb(arr, ind-1, i, end);
	}
	public static void lsb(int[] arr, int x){
		int n = arr.length;
		int[] a1 = new int[n];
		for(int i=0;i<=x;i++){
			int j = 0, k = n-1;
			for(int f=0;f<n;f++){
				if(getBit(arr[f], i) == 0) a1[j++] = arr[f];
				else a1[k--] = arr[f];
			}
			for(int f=0;f<j;f++) arr[f] = a1[f];
			for(int f=j;f<n;f++) arr[f] = a1[n-1-f+j];
		}
		a1 = null;
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		rand = new Random();
		int n = 10000;
		double m = 0, q = 0, h = 0, c = 0, r = 0, rl = 0;
		int[] arr1 = new int[n], arr2 = new int[n], arr3 = new int[n+1], arr4 = new int[n], arr5 = new int[n], arr6 = new int[n];
		for(int f=0;f<1000;f++){
			for(int i=0;i<n;i++){
				arr1[i] = rand.nextInt(100000);
				arr2[i] = arr1[i];
				arr3[i+1] = arr2[i];
				arr4[i] = arr2[i];
				arr5[i] = arr2[i];
				arr6[i] = arr2[i];
			}
			long x, y;
			// x = System.nanoTime();
			// merge(arr1, 0, n-1);
			// y   = System.nanoTime();
			// m += ((double)y - x)/1000;
			// x = System.nanoTime();
			// heap(arr3, 1, n);
			// y   = System.nanoTime();
			// h += ((double)y - x)/1000;
			// x = System.nanoTime();
			// quick(arr2, 0, n-1);
			// y   = System.nanoTime();
			// q += ((double)y - x)/1000;
			// x = System.nanoTime();
			// Arrays.sort(arr4);
			// y   = System.nanoTime();
			// c += ((double)y - x)/1000;
			// x = System.nanoTime();
			// msb(arr5, 30, 0, n-1);
			// y = System.nanoTime();
			// r += ((double)y - x)/1000;
			x = System.nanoTime();
			lsb(arr6, 30);
			y = System.nanoTime();
			rl += ((double)y - x)/1000;

		}
		System.out.println(m+" "+q+" "+h+" "+c+" "+r+" "+rl);
		System.out.println(sortcheck(arr1)+" "+sortcheck(arr2)+" "+sortcheck(arr3)+" "+sortcheck(arr4)+" "+sortcheck(arr5)+" "+sortcheck(arr6));
	}
}