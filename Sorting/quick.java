/*input
5
1 2 3 5 3
*/
import java.util.*;
public class quick{
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
	public static void sort(int[] arr, int beg, int end){
		if(beg >= end) return;
		int ind = rand.nextInt(end-beg+1)+beg;
		// int ind = beg;
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
		sort(arr, beg, i-1);
		sort(arr, i+1, end);
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		rand = new Random();
		int n = 100000;
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = rand.nextInt(100000000);
		}
		sort(arr, 0, n-1);
		System.out.println(sortcheck(arr));
	}
}