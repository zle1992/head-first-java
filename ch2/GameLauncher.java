
 class GuessGame{
	player p1;
	player p2;
	player p3;
	
	public void startGame(){
		p1 = new player();
		p2 = new player();
		p3 = new player();
	    int guessp1 = 0;
		int guessp2 = 0;
		int guessp3 = 0;
		boolean p1isRight = false;
		boolean p2isRight = false;
		boolean p3isRight = false;
		int targetNumber = (int)(Math.random()*10);
		System.out.println("I am thinking a number of 1 to 10____");

		while(true){
			System.out.println("number to guess is "+targetNumber);
			p1.guess();
			p2.guess();
			p3.guess();
			guessp1 = p1.number;
			System.out.println("p1 guessed"+guessp1 );
			guessp2 = p2.number;
			System.out.println("p1 guessed"+guessp2 );
			guessp3 = p3.number;
			System.out.println("p1 guessed"+guessp3 );

			if(guessp1==targetNumber) p1isRight=true;
			if(guessp2==targetNumber) p2isRight=true;
			if(guessp3==targetNumber) p3isRight=true;

			if(p1isRight||p2isRight||p3isRight){
				System.out.println("we have winers !");
				System.out.println("p1 is right?"+p1isRight);
				System.out.println("p2 is right?"+p2isRight);
				System.out.println("p3 is right?"+p3isRight);
				System.out.println("game over!");
				break;
			}
			else {
				System.out.println("no one is right!");
			}

		}
	}
	
}
 class player{
	int number = 0;
	public void guess(){
	number =(int)(Math.random()*10);
	System.out.println("I am gussing"+number);	
	}
}
public class GameLauncher{
	public static void main(String[] args) {
		GuessGame  game = new GuessGame();
		game.startGame();
	}
}