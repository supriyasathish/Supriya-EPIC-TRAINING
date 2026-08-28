import java.util.Scanner;
public class char_num_alp {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	char ch=in.next().charAt(0);
	
	if(ch >= 'A' && ch<='Z' ||ch>='a' && ch<='z'){
		System.out.println("Alphabet");
		
	}
	else if(ch >='0' && ch<='9') {
		System.out.println("Number");
	}
	else {
		System.out.println("Special Character");
	}
    in.close();
}

}

