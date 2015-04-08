import java.util.ArrayList;
import java.util.Arrays;

public class AD_Aflevering_2 {

	static int[][] venskaber = {{1,2},{4,1},{5,1},{1,6},{4,2},{5,2},{2,6},{5,4},{4,6},{5,6},{6,7}};
	static String[] navne = {"Inky","Pinky", "Blinky", "Clyde", "Luigi", "Mario", "Bowser"};
	static int[] personer = {1,2,4,5,6};
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
				a[k][0] = L[i][0];
				i++;
			}
			else{
				a[k][0] = R[j][0];
				j++;
			}
		}
		return a;
	}
	
	public static boolean MyOwn(int[] Friendslist, ArrayList<Integer[]> Result){
		int count = 0;
		ArrayList<Integer[]> Answer = new ArrayList<Integer[]>();
		for (int i = 0; i < Friendslist.length-1; i++) {
			for (int j = i+1; j < Friendslist.length; j++) {
				Integer[] point = {Friendslist[i],Friendslist[j]};
				Answer.add(point);
			}
		}
		for (int i = 0; i < Answer.size(); i++) {
			System.out.println("{" + Answer.get(i)[0] + ", " + Answer.get(i)[1] + "}");
			int[] temp1 = {Answer.get(i)[0],Answer.get(i)[1]};
			for (int j = 0; j < Result.size(); j++) {
				int[] temp2 = {Result.get(j)[0],Result.get(j)[1]};
				int[] temp3 = {Result.get(j)[1],Result.get(j)[0]};
				if (Arrays.equals(temp1, temp2) || Arrays.equals(temp1, temp3)) {
					count++;
				}
			}
		}
		if (count == Answer.size()) {
			return true;
		}
		return false;
	}

	public static int BinarySearch(int key, int[][] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if      (key < a[mid][0]) hi = mid - 1;
			else if (key > a[mid][0]) lo = mid + 1;
			else return mid;
		}
		return -1;
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
	
	public static boolean FuckingLort(int[][] Venskaber, int[] Personer){
		Arrays.sort(Personer);
		SortAfterShit(Venskaber);
		MergeSort(Venskaber, 0, Venskaber.length-1);
		ArrayList<Integer[]> Result = new ArrayList<Integer[]>();
		
		for (int i = 0; i < Personer.length-1; i++) {
			innerloop:
				for (int j = i+1; j < Personer.length; j++) {
					int[] temp1 = {Personer[i],Personer[j]};
					int p = BinarySearch(temp1[0], Venskaber);
					int copy = p;
					
					if(p == -1){
						return false;
					}
					
					while(Venskaber[p][0]==temp1[0]){
						int[] temp2 = Venskaber[p];
						System.out.println("nu går vi tilbage:");
						System.out.println("dette er temp1: " + temp1[0] + " " + temp1[1]);
						System.out.println("dette er temp2: " + temp2[0] + " " + temp2[1] );
						System.out.println("dette er x[p][0]: " + Venskaber[p][0]);
						System.out.println("dette er p: " + p);
						
						System.out.println(" ");
						if (Arrays.equals(temp1, temp2)){
							System.out.println("Match!");
							System.out.println(" ");
							Integer[] point1 = {temp1[0],temp1[1]};
							Result.add(point1);
							p--;
							continue innerloop;
						}
						p--;
						if(p<0){
							break;
						}
					}
					p = copy+1;
					while(Venskaber[p][0]==temp1[0]){
						int[] temp2 = Venskaber[p];
						System.out.println("nu går vi fremad:");
						System.out.println("dette er temp1: " + temp1[0] + " " + temp1[1]);
						System.out.println("dette er temp2: " + temp2[0] + " " + temp2[1] );
						System.out.println("dette er x[p][0]: " + Venskaber[p][0]);
						System.out.println("dette er p: " + p);
						System.out.println(" ");
						if (Arrays.equals(temp1, temp2)){
							System.out.println("Match!");
							System.out.println(" ");
							Integer[] point1 = {temp1[0],temp1[1]};
							Result.add(point1);
							p++;
							break;
						}
						p++;
						if(p>Venskaber.length){
							System.out.println("andet break");
							break;
						}
					}
				}
		}
		return MyOwn(Personer,Result);
	}
	public static void main(String[] args) {		
		System.out.println(FuckingLort(venskaber, personer));
	}
}