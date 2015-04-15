import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class AD_Aflevering_2 {
private static CodeJudge3 hej;
	
	static ArrayList<CodeJudge3> Persons = new ArrayList<CodeJudge3>();
	static ArrayList<CodeJudge3> Answer = new ArrayList<CodeJudge3>();
	int Distance;
	static int pointer = 0;
	String color;
	String name;
	
	static int temp = 1;
	static int Generations;
	static int Person;
	static int[] InputInt;
	static String AlgorithmName;

	ArrayList<CodeJudge3> Friendslist = new ArrayList<CodeJudge3>();
	static String[] input;
	static String[] inputcopy;
	static int[] inputliste;

	public CodeJudge3(){
		this.color = "white";
		this.Distance = Integer.MAX_VALUE;
		this.name = "";

	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public int getDistance(){
		return this.Distance;
	}

	public void addDistance(){
		this.Distance++;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return this.color;
	}

	public void addFriend(CodeJudge3 Friend){
		Friendslist.add(Friend);
	}
	
	public ArrayList<CodeJudge3> getFriendsList(){
		return Friendslist;
	}

	public CodeJudge3 getFriend(int i){
		return Friendslist.get(i);
	}

	public int size(){
		return Friendslist.size();
	}
	
	public static String løsning() throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("ADInputOpg3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			String[] Navneliste = line.split(" ");
			for (int i = 0; i < Navneliste.length; i++) {
				Persons.add(new CodeJudge3());
				Persons.get(i).setName(Navneliste[i]);
			}
			while (true) {
				try {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
					if(line == null){
						break;
					}
					Persons.get(Integer.parseInt(line.split(" ")[0])).addFriend(Persons.get(Integer.parseInt(line.split(" ")[1])));
					Persons.get(Integer.parseInt(line.split(" ")[1])).addFriend(Persons.get(Integer.parseInt(line.split(" ")[0])));
				} catch (Exception e) {
					// TODO: handle exception
					String[] inputString = line.split(" ");
					AlgorithmName = inputString[0];
					String[] inputStringcopy = Arrays.copyOfRange(inputString, 1, inputString.length);
					InputInt = new int[inputStringcopy.length];
					for (int i = 0; i < InputInt.length; i++) {
						InputInt[i] = Integer.parseInt(inputStringcopy[i]);
					}
					break;
				}  
			}

			//			Navneliste - Liste af navnene
			//			InputInt - liste af tal (Hvis der er nogen)
			//			AlgorithmName - det første ord i sidste linje
			Person = InputInt[0];
			Generations = InputInt[1];
			
			//Jeg smider personen selv ind i svaret
			Answer.add(Persons.get(Person));
			Answer.get(0).setColor("black");
			
			
			for (int i = 0; i < Generations; i++) {
				int size = Answer.size();
				for (int j = 0 ; j < size; j++) {
					for (CodeJudge3 friend : Answer.get(j).getFriendsList()) {
						if(friend.getColor()=="white"){
							Answer.add(friend);
							friend.setColor("black");
							pointer++;
//							if(pointer==Answer.size()-1){
//								pointer--;
//							}
						}
					}				
				}
			}
			String svar = Answer.get(0).getName();
			for (int i = 1; i < Answer.size(); i++) {
				svar = svar + " " + Answer.get(i).getName();
			}
			return svar;
			

			
		} finally {
			br.close();
		}
		
	}
	
	

	public static void main(String[] args) throws IOException {
		System.out.println(løsning());

	}

}