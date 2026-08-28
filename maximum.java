import java.util.Scanner;
public class maximum {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();
		int d=in.nextInt();
		if(a>b && a>c && a>d) {
			System.out.println("A is Greater");
		}
		else if(b>a && b>c && b>d) {
			System.out.println("B is Greater");
		}
		else if(c>a && c>b && c>d) {
			System.out.println("C is Greater");
		}
		else {
			System.out.println("D is Greater");
		}
		in.close();
	}

}

