import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Dictionary;
public class AD_Aflevering_3 {
	private static AD_Aflevering_3 hej;
	
	static ArrayList<AD_Aflevering_3> Persons = new ArrayList<AD_Aflevering_3>();
	static ArrayList<AD_Aflevering_3> Answer = new ArrayList<AD_Aflevering_3>();
	int Distance;
	static int pointer = 0;
	String color;
	String name;
	
	static int temp = 1;
	static int Generations;
	static int Person;
	static int[] InputInt;
	static String AlgorithmName;

	ArrayList<AD_Aflevering_3> Friendslist = new ArrayList<AD_Aflevering_3>();
	static String[] input;
	static String[] inputcopy;
	static int[] inputliste;

	public AD_Aflevering_3(){
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

	public void addFriend(AD_Aflevering_3 Friend){
		Friendslist.add(Friend);
	}
	
	public ArrayList<AD_Aflevering_3> getFriendsList(){
		return Friendslist;
	}

	public AD_Aflevering_3 getFriend(int i){
		return Friendslist.get(i);
	}

	public int size(){
		return Friendslist.size();
	}
	
	public static String l�sning() throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("ADInputOpg3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			String[] Navneliste = line.split(" ");
			for (int i = 0; i < Navneliste.length; i++) {
				Persons.add(new AD_Aflevering_3());
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
			//			AlgorithmName - det f�rste ord i sidste linje
			Person = InputInt[0];
			Generations = InputInt[1];
			
			//Jeg smider personen selv ind i svaret
			Answer.add(Persons.get(Person));
			Answer.get(0).setColor("black");
			
			
			for (int i = 0; i < Generations; i++) {
				int size = Answer.size();
				for (int j = 0 ; j < size; j++) {
					for (AD_Aflevering_3 friend : Answer.get(j).getFriendsList()) {
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
		System.out.println(l�sning());

	}

}
