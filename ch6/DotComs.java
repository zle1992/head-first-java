import java.util.*;
public class DotComs {
	private ArrayList<String> locationCells;
	private String name;
	public void setLocationCells(ArrayList<String> loc){
		locationCells = loc;
	}
	public void name(String n){
		name = n;
	}
	public String checkYourself(String userInput){
		String result = "'miss";
		int index = locationCells.indexOf(userInput);
		if(index >= 0){
			locationCells.remove(index);

			if(locationCells.isEmpty()){
				result = "kill";
				System.out.println("Onch! You sunk "+name+" : (");
			}
			else{
				result = "hit";
			}
		}
		return result;
	}
	
}