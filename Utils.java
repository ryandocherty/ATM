import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {
	public static boolean isInteger(String str) {
		return str.matches("^-?\\d+$");
	}
	public static int getInt(String Q) {
		System.out.println(Q);
		
		int intVal = 0;
		String input = "";
		
		try {	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input=br.readLine();
		} catch(IOException io){
		}	
		
		if (Utils.isInteger(input)) {
			intVal = Integer.parseInt(input);
		}
		
		return intVal;
	}
}
