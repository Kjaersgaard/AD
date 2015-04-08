import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class AD_Aflevering_1 {
	
	static public String AD_Opgave_1(String STDIN) throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader(STDIN + ".txt"));
		 ArrayList<int[]> xrr = new ArrayList<int[]>();
		    
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
		        String[] ListofNames = line.split(" ");
		        
		        
		        while (line != null) {
		        	
		        	try {
						
		        		sb.append(line);
			            sb.append(System.lineSeparator());
			            line = br.readLine();
			            
			            if(line == null){
			        		break;
			        	}
			            
			            int[] xr = {Integer.parseInt(line.substring(0, 1)),Integer.parseInt(line.substring(2, 3))};
			            xrr.add(xr);

					} catch (Exception e) {
						// TODO: handle exception
						
					}
		        	
		            
		        }
		    
		    
		    return ListofNames.length + " " + xrr.size();
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(AD_Opgave_1("ADInputOpg1"));
	}
	
}
