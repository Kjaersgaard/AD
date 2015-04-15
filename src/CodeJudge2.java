import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CodeJudge2 {

	//	static int[][] venskaber = {{1,2},{4,1},{5,1},{1,6},{4,2},{5,2},{2,6},{5,4},{4,6},{5,6},{6,7}};
	//	static String[] navne = {"Inky","Pinky", "Blinky", "Clyde", "Luigi", "Mario", "Bowser"};
	static int[] personer = {};

	static public int[] ConvertToStringArray(String STDIN) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> xrr = new ArrayList<int[]>();
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		while (true) {
			try {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				if(line == null){
					break;
				}
				int[] xr = {Integer.parseInt(line.split(" ")[0]),Integer.parseInt(line.split(" ")[1])};
				xrr.add(xr);
			} catch (Exception e) {
				// TODO: handle exception
				String[] yr = line.split(" ");
				String[] newArray = Arrays.copyOfRange(yr, 1, yr.length);
				int[] newerArray = new int[newArray.length];
				for (int i = 0; i < newArray.length; i++) {
					newerArray[i] = Integer.parseInt(newArray[i]);
				}
				
				return newerArray;
			}
		}
		return personer;
	}

	static public int[][] ConvertToArray(String STDIN) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<int[]> xrr = new ArrayList<int[]>();	    
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		String[] ListofNames = line.split(" ");
		while (line != null) {
			try {

				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

				if(line == null){
					break;
				}

				int[] xr = {Integer.parseInt(line.split(" ")[0]),Integer.parseInt(line.split(" ")[1])};
				xrr.add(xr);

			} catch (Exception e) {
				// TODO: handle exception
				break;
			}
		}
		int[][] xr = new int[xrr.size()][2]; 
		for (int i = 0; i < xrr.size(); i++) {
			xr[i] = xrr.get(i);
		}
		
		return xr;
	}

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

	public static String MyOwn(int[] Friendslist, ArrayList<Integer[]> Result){
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
			return "ja";
		}
		return "nej";
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

	public static String FuckingLort(int[][] Venskaber, int[] Personer){
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
						return "nej";
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
	public static void main(String[] args) throws IOException {		
		int[][] xr = ConvertToArray("ADInputOpg2");
		int[] List = ConvertToStringArray("ADInputOpg2");
		System.out.println(FuckingLort(xr, List));
		
	}
}