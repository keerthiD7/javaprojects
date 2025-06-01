package calculator.com;
import java.util.Scanner;

public class Calculator {
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		double num1,num2;
		System.out.println("Enter the numbers one bu one:");
		num1 = sc.nextDouble();
		num2 = sc.nextDouble();
		System.out.println("Enter the operator(+,-,*./):");
		char op = sc.next().charAt(0);						
//															Code	          Returns	           Type
//															sc.next()	        "+"	              String
//															sc.next().charAt(0)	'+'	               char
		double o = 0;
		switch(op) {
		case '+' :
			o = num1+num2;
			break;
		case '-' :
			o = num1-num2;
			break;
		case '*' :
			o = num1*num2;
			break;
		case '/':
			o = num1/num2;
			break;
		default : System.out.println("you entered a wrong input");
		}
		System.out.println("the final output is :");
		System.out.println();
		System.out.println(num1+" "+num2+" " +"="+ o);
		if(o==(int)o)
		{
			System.out.println((int)o);
			
		}
		else {
			System.out.println(o);
		}
	}


}
