public class InvertedPattern {
public static void main(String[] args) {
	int n=5;
	for(int i=0;i<n-2;i++) {
		for(int s=0;s<=i;s++) {
			System.out.print(" ");
		}
		for(int j=0;j<n-2*i;j++) {
			System.out.print(j+1);
		}
		System.out.println();
	}
	for(int i=1;i>=0;i--) {
		for(int s=0;s<=i;s++) {
			System.out.print(" ");
		}
		
		
		for(int j=n-2*i-1;j>=0;j--) {
			System.out.print(j+1);
		}
		System.out.println();
	}
}
}
