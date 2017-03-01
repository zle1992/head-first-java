import java.util.*;
public class DotComBust{
	private GameHelper helper = new GameHelper();
	private ArrayList<DotComs> DotComsList = new ArrayList<DotComs>();
	private int numOfGuesses;
	public void setUpGame(){
		// make three DotCom objects and name them
        DotComs dot1 = new DotComs();//create three DotCom objects
        DotComs dot2 = new DotComs();
        DotComs dot3 = new DotComs();
        dot1.name("1") ;//set a name for each object
        dot2.name("2") ;
        dot3.name("3") ;
        DotComsList.add(dot1);// add DotComs to the list
        DotComsList.add(dot2);
        DotComsList.add(dot3);

        for( DotComs dot :DotComsList){// 
        	ArrayList<String> newLocation = helper.placeDotCom(3);
        	dot.setLocationCells(newLocation);
        }
	}
	public void startPlaying(){
        while(!DotComsList.isEmpty()){
        	// while DotComs exist
        	String usersGuess = helper.getUserInput("Enter a guess");
        	checkUsersGuess(usersGuess);
        }
        finishGame();
	}
	public void checkUsersGuess(String usersGuess){
        numOfGuesses++;
        String result = "miss";
        for(DotComs dot :DotComsList){
        	result = dot.checkYourself(usersGuess);
            if(result.equals("hit")){
                break;
            }
        }
        System.out.println(result);
	}
	public void finishGame(){
        System.out.println("All dot Coms are dead! Your stock is now worthless.");
        if (numOfGuesses<19) {
        	System.out.println("It only took you "+numOfGuesses+"guesses.");
        	System.out.println("You got out before your options sank.");
        }
        else{
        	System.out.println("Took you long enough "+numOfGuesses+"guesses.");
        	System.out.println("Fish are dancing with your options.");
        }
	}
	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}