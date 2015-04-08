
public class opg_3 {
	public static int binarysearch(int[] a,int i,int j,int x){
		if (j<i || a[a.length-1]<x || a[0]>x){
			return -1;
		}
		int m = (i+j)/2;
		if (a[m] == x){
			return m;
		}
		else if(a[m]<x){
			return binarysearch(a,m+1,j,x);
		}
		else{
			return binarysearch(a,i,m-1,x);
		}
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,17,18,19,20,21};
		System.out.println(binarysearch(a,0,a.length,1));
	}

}
