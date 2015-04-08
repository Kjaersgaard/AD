
public class opg_4_1 {
	
	public static int[] mergesort(int[] a, int p, int r){
		if (p<r){
			int q = (p+r) / 2;
			mergesort(a,p,q);
			mergesort(a,q+1,r);
			merge(a,p,q,r);
		}
		return a;
	}
	
	public static int[] merge(int[] a, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		for (int i = 0; i < n1; i++) {
			L[i] = a[p+i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = a[q+j+1];
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k < r+1; k++){
			if (L[i]<=R[j]){
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
	public static void main(String[] args) {
		int[] a = {34,532,5,346,65,7634,523,14,231,567,642314,214,326,58,563,214,2455,6,6655,432,2345,6567,88,766,54,43322,12234,45,566789,984,325,653784365};
		mergesort(a,0, a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
