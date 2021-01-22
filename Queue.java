class Queue<T>{
	private int N = 1024;
	private T[] arr;
	private int f = -1;
	private int r = 0;
	public Queue(){
		arr = (T[]) new Object[N];
	}
	public void push(T data){
		if(r==f || f == -1){
			arr[0] = data;
			f = 0;
			r = 1;
			return;
		}
		if((r+1)%N == f){
			T[] temp = (T[]) new Object[2*N];
			for(int i=0;i<N-1;i++){
				temp[i] = arr[(f+i)%N];
			}
			temp[N-1] = data;
			f = 0;
			r = N;
			N *= 2;
			arr = temp;
			return;
		}
		arr[r] = data;
		r = (r+1)%N;
	}
	public void pop(){
		if(f != r) f = (f+1)%N;
	}
	public T front(){
		if(f != r) return arr[f];
		else return null;
	}
	public void print(){
		if(f == r){
			System.out.println();
			return;
		}
		for(int i=0;i<(r-f+N)%N;i++){
			System.out.print(arr[(f+i)%N]+" ");
		}
		System.out.println();
	}
}