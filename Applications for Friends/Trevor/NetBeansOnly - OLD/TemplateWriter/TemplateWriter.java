/* Template Writer.java
 * By Thomas Ibarra
 */
 
import java.net.*;
import java.io.*;
import java.util.*;
 
public class TemplateWriter {
	
	public static void main(String[] args) {
		Scanner keyb = new Scanner(System.in);
		String template = "INSERT INTO \'city\' VALUES(303, \'\', \'\', \'1\');";
		String template_string_start = "INSERT INTO \'city\' VALUES(";
		String template_string_middle = ", \'\', \'\', \'";
		String template_string_end = "\');";
		File tempfile = new File("Generated_Template.txt");
		
		System.out.print("Enter beginning Index: ");
		int beginning_index = keyb.nextInt();
		System.out.println();
		
		System.out.print("Enter times to repeat: ");
		int ending_index = keyb.nextInt() + beginning_index;
		
		System.out.println();
		
		System.out.print("Enter state Index: ");
		int state_index = keyb.nextInt();
		
		System.out.println();
		
		
		try{
		
			if(!tempfile.exists()){
				PrintWriter dataOutput = new PrintWriter(tempfile);
				for(int temp_index = beginning_index; temp_index <= ending_index; temp_index++){
					String data = template_string_start + temp_index + template_string_middle + state_index + template_string_end;
					dataOutput.println(data);
					System.out.println("Successfully Printed: " + data);
				}
				dataOutput.close();
			} else {
				System.out.println("File already Exists.");
			}
		} catch (Exception e){
			System.out.println("An Error has occured.");
		}
	}	
}