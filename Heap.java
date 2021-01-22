public class Heap{
	private int max = 1000;
	int[] arr;
	private int size = 0;
	public Heap(){
		arr = new int[max+1];
	}
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public int insert(int num){
		arr[++size] = num;
		int i = size;
		while(i/2>0){
			if(arr[i]<arr[i/2]){
				swap(arr, i, i/2);
				i /= 2;
			}
			else break;
		}
		return 1;
	}
	public int getMin(){
		return arr[1];
	}
	private void heapify(int[] arr, int ind, int n){
		int j = ind;
		while(true){
			if(2*j>n) break;
			if(2*j == n){
				if(arr[2*j]<arr[j]) swap(arr, 2*j, j); 
				break;
			}
			int k = 2*j;
			if(arr[2*j]>arr[2*j+1]) k++;
			if(arr[j]<=arr[k]) break;
			swap(arr, j, k);
			j = k;
		}
	}
	public int deleteMin(){
		int x = arr[1];
		swap(arr, 1, size);
		heapify(arr, 1, --size);
		return x;
	}
	public void print(){
		for(int i=1;i<=size;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}