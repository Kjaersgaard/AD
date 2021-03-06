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
		        System.out.println("Dette er navneliste");
		        String[] ListofNames = line.split(" ");
		        
		        for (int i = 0; i < ListofNames.length; i++) {
		        	System.out.println(ListofNames[i]);
				}
		        
		        
		        while (line != null) {
		        	
		        	try {
						
		        		sb.append(line);
			            sb.append(System.lineSeparator());
			            line = br.readLine();
			            
			            if(line == null){
			        		break;
			        	}
			            
			            int[] xr = {Integer.parseInt(line.split(" ")[0]),Integer.parseInt(line.split(" ")[1])};
			            xrr.add(xr);

					} catch (Exception e) {
						// TODO: handle exception
						String[] yr = line.split(" ");
						System.out.println("Dette er den sidste linje");
						for (int i = 0; i < yr.length; i++) {
							System.out.println(yr[i]);
						}
						
						System.out.println("Dette er venskaberne");
						for (int i = 0; i < xrr.size(); i++) {
							System.out.println(xrr.get(0)[0] + " " + xrr.get(1)[1]);
						}
						
					}
		        	
		            
		        }
		    
		    
		    return ListofNames.length + " " + xrr.size();
		
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(AD_Opgave_1("ADInputOpg1"));
	}
	
}
