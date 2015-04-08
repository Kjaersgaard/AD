import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;


public class AD_Aflevering_3 {
	static class Person{
		static ArrayList<Integer> Neighbors = new ArrayList<Integer>();
		public Person(){
				
		}
		
		static void Add(int value){
			Neighbors.add(value);
		}
		
		static void PrintNeighbors(){
			for (int i = 0; i < size(); i++) {
				System.out.println(Neighbors.get(i));
			}
		}

		static int size(){
			return Neighbors.size();
		}
		
	}
	static int[][] Venskaber = {{0,2},{1,2},{5,6},{3,5},{2,4},{5,4},{2,3},{1,4}};
	static String[] navne = {"Inky","Pinky", "Blinky", "Clyde", "Luigi", "Mario", "Bowser"};	
	
	public static int[][] MergeSort(int[][] A, int p, int r){
		if (p<r){
			int q = (p+r) / 2;
			MergeSort(A,p,q);
			MergeSort(A,q+1,r);
			Merge(A,p,q,r);
		}
		return A;
	}
	
	public static int[][] Merge(int[][] a, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[][] L = new int[n1+1][2];
		int[][] R = new int[n2+1][2];
		for (int i = 0; i < n1; i++) {
			L[i] = a[p+i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = a[q+j+1];
		}
		L[n1][0] = Integer.MAX_VALUE;
		R[n2][0] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k < r+1; k++){
			if (L[i][0]<=R[j][0]){
				a[k] = L[i];
				i++;
			}
			else{
				a[k] = R[j];
				j++;
			}
		}
		return a;
	}
	
	public static void SortAfterShit(int[][] venskaber){
		
		for (int i = 0; i < venskaber.length; i++) {
			if(venskaber[i][0]>venskaber[i][1]){
				int temp1 = venskaber[i][0];
				int temp2 = venskaber[i][1];
				venskaber[i][0] = temp2;
				venskaber[i][1] = temp1;
			}
		}
	}
	
	static void opgave3(){
		
		
	}
	
	public static void main(String[] args) {
//		opgave3();
		//((Person) dict.get("Inky")).Add(1);
		
		SortAfterShit(Venskaber);
		MergeSort(Venskaber,0, Venskaber.length-1);
		
		Dictionary dict = new Hashtable();
		int p = 0;
		outerloop:
		for (int i = 0; i < navne.length; i++) {
			dict.put(navne[i],new Person());
			while(i==Venskaber[p][0]){
				((Person) dict.get(navne[i])).Add(Venskaber[p][1]);
				p++;
				if(p>Venskaber.length-1){
					break outerloop;
				}
			}
		}
		
		((Person) dict.get(navne[0])).PrintNeighbors();
		

	}

}
