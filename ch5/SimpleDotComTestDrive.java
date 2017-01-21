public class SimpleDotComTestDrive{
    public static void main(String[] args) {
	SimpleDotCom dot = new SimpleDotCom();  //initialize  SimpleDotCom class
	int[] locations	={2,3,4};//   initialize dotcom array
	dot.setLocationCells(locations);//recall settet of dot

	String userGuess = '2';  //make a fake user guess 
	String result = dot.checkYourself(userGuess);// invoke the checkYourself() method
	// on the dot com object and pass it the fake guess 
	String testResult = "failed";
	if(result.euqals("hit")){   //if the fake guess(2) gives back a "hit" it is working
		testResult = "pass";
	}
	System.out.println(testResult); // print out the test passed or failed
	}
}