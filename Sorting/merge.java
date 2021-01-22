/*input

*/
import java.util.*;
public class merge{
	static Random rand;
	public static boolean sortcheck(int[] arr){
		for(int i=1;i<arr.length;i++){
			if(arr[i]<arr[i-1]) return false;
		}
		return true;
	}
	public static void sort(int[] arr, int beg, int end){
		if(beg >= end) return;
		int mid = (beg+end)/2;
		sort(arr, beg, mid);
		sort(arr, mid+1, end);
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
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		rand = new Random();
		int n = 1000;
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = rand.nextInt(100000000);
		}
		sort(arr, 0, n-1);
		System.out.println(sortcheck(arr));
		// for(int i=0;i<n;i++){
		// 	System.out.print(arr[i]+" ");
		// }
		// System.out.println();
	}
}