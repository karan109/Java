public class Stack<T>{
	private int N = 1024;
	private T[] arr;
	private int t = -1;
	public Stack(){
		arr = (T[]) new Object[N];
	}
	public void push(T data){
		if(t<N-1){
			arr[++t] = data;
			return;
		}
		N *= 2;
		T[] temp = (T[]) new Object[N];
		for(int i=0;i<=t;i++){
			temp[i] = arr[i];
		}
		arr = temp;
		arr[++t] = data;
	}
	public T top(){
		return arr[t];
	}
	public void pop(){
		if(t>-1){
			t--;
		}
	}
	public int size(){
		return t+1;
	}
	public void print(){
		if(t<0){
			System.out.println();
			return;
		}
		for(int i=0;i<=t;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}