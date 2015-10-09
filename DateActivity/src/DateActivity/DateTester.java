package DateActivity;
import java.util.Scanner;

public class DateTester {
	public static void main(String[] args) {
		final int LENGTH = 3;
		DateClass dateClass = new DateClass();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("What is the date that you are asking about? e.g 9/2/2015 ");
		String input = scan.nextLine();
		
		while(!input.equals("")){
			String[] parts = input.split("/");
			if (parts.length == LENGTH){
				System.out.println(dateClass.getDateAnswer(Integer.parseInt(parts[2]), Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
			}
			
			System.out.print("\nWhat is the date that you are asking about? e.g 9/2/2015 ");
			input = scan.nextLine();
		}
		
		scan.close();
	}
}
