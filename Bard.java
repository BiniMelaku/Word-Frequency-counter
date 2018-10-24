import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Bard{

public static boolean isInt(String s){
 for(int a = 0; a < s.length(); a++){
	if(a==0 && s.charAt(a) == '-'){
		continue;
	} 
	if(!Character.isDigit(s.charAt(a)) ){
		return false;
	}
}	
 return true;
}

	public static void main(String[] args) throws IOException{

		BufferedReader in = new BufferedReader(new FileReader("Shakespeare.txt"));
		BufferedReader in2 = new BufferedReader(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("analysis.txt"));
		
		Map<String, Integer> wordCount = new HashMap<>();
		//line reads in lines from shakespeare
		 String line = in.readLine();
		 //line2 reads in lines from input txt
		 String line2 = in2.readLine();
		 while(line2 != null){
		 	
		 	String[] query = line2.split(" ");
			StringBuilder strBuilder = new StringBuilder();
			
			for(int i = 0; i < query.length; i++){
				strBuilder.append(query[i]);
			}
			//returns string version of string array
			String query2 = strBuilder.toString();
			
		 while(line != null){ 
		 	//System.out.println("Processing line: " + line)

		 	if(!line.trim().equals(" ")){
			String[] words = line.split("[^a-zA-Z]");
		
			for(String word : words) {
				if(word == null || word.trim().equals("")){
					continue;
				}
				
				word = word.replace(",", "");
					
				if(wordCount.containsKey(word)) {
					wordCount.put(word, 
					wordCount.get(word) + 1);
				}else{
					wordCount.put(word, 1);
				}

				
			} // end of for loop 
			
				
			}// end of if loop
			
			line = in.readLine();
		}// end of first while loop

		if(!isInt(query2)){
			if(wordCount.containsKey(query2)){
			int value = wordCount.get(query2);
			out.println(query2 + " " + value);
			}
		}
			
			line2 = in2.readLine();
	}//end of second while loop

	out.flush();
    out.close();
		
} 
}