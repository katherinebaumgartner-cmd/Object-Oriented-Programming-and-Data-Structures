import java.io.*;
import java.util.*;
import java.util.Random;

public class WumpusMain
{

//grader key
/*
- the wumpus is bethany the dragon
- the spiders are robot chickens
- the bottomless pits are radioactive waste pools
- the giant bats is Karter the kangeroo
- your bow and arrows are a machine gun with magazines
- it is still a cave system with rooms
*/

  public static void main(String [] args) throws IOException
  {
	Room [] caves;
	int n;
	
    System.out.println("Welcome to **Slay the dragon!**");
	System.out.println(" ");
	System.out.println("Your goal is to slay the dragon. You have a machine gun with three magazines. You can only carry three magazines, no more than that.");
	System.out.println(" ");
	System.out.println("A few things to know: ");
	System.out.println("1.) The dragons name is Bethany. She has poor hygiene and you can smell her from one room away.");
	System.out.println("2.) There are robot chickens who inhabit these cave system that Bethany lives in. You can hear them pecking the ground from one room away.");
	System.out.println("3.) The cave system has radioactive waste pools in it. They have a nasty waste smell to them. You can smell them from one room away.");
	System.out.println("4.) There is a giant kangaroo that lives in the caves. Her name is Karter. If you encounter her den, she will put you in her pouch and carry you to a random room and leave you there. There is no way to tell where her den will be");
	System.out.println(" ");
	
	//scans the file
	Scanner f = new Scanner(new FileReader("Cave.txt"));
	
	//reads first line of file for amount of caves
	n = f.nextInt();
	//makes the Room array become the amount of caves read from the file
	caves = new Room[n];
	
	//loop to make the iteration of caves array be the room from file reader
	for(int i = 0; i < caves.length; i++)
	{
		caves[i] = new Room(f);
	}
	
	// debugging that prints out all the file info
	/*
	for(int i = 0; i < caves.length; i++)
	{
		System.out.println(caves[i]);
	}
	*/
		
	//Obstacles Room Assignment
	int wumpusRoom, spiderRoom1, spiderRoom2, pits1, pits2;
	
	wumpusRoom = (int)((2+(caves.length - 1)*Math.random()));
	
	spiderRoom1 = (int)((2+(caves.length - 1)*Math.random()));
	if(spiderRoom1 == wumpusRoom)
	{
		while(true)
		{
			spiderRoom1 = (int)((2+(caves.length - 1)*Math.random()));
			if(spiderRoom1 != wumpusRoom)
			{
				break;
			}
		}
	}
	
	spiderRoom2 = (int)((2+(caves.length - 1)*Math.random()));
	if((spiderRoom2 == wumpusRoom) || (spiderRoom2 == spiderRoom1))
	{
		while(true)
		{
			spiderRoom2 = (int)((2+(caves.length - 1)*Math.random()));
			if((spiderRoom2 != wumpusRoom) && (spiderRoom2 != spiderRoom1))
			{
				break;
			}
		}
	}
	
	pits1 = (int)((2+(caves.length - 1)*Math.random()));
	if((pits1 == wumpusRoom) || (pits1 == spiderRoom1) || (pits1 == spiderRoom2))
	{
		while(true)
		{
			pits1 = (int)((2+(caves.length - 1)*Math.random()));
			if((pits1 != wumpusRoom) && (pits1 != spiderRoom1) && (pits1 != spiderRoom2))
			{
				break;
			}
		}
	}
	
	pits2 = (int)((2+(caves.length - 1)*Math.random()));
	if((pits2 == wumpusRoom) || (pits2 == spiderRoom1) || (pits2 == spiderRoom2) || (pits2 == pits1))
	{
		while(true)
		{
			pits2 = (int)((2+(caves.length - 1)*Math.random()));
			if((pits2 != wumpusRoom) && (pits2 != spiderRoom1) && (pits2 !=spiderRoom2) && (pits2 != pits1))
			{
				break;
			}
		}
	}
		
	//arrow refill room EC
	int arrowRoom;
	
	arrowRoom = (int)((2+(caves.length - 1)*Math.random()));
	if((arrowRoom == wumpusRoom) || (arrowRoom == spiderRoom1) || (arrowRoom == spiderRoom2) || (arrowRoom == pits1) || (arrowRoom == pits2))
	{
		while(true)
		{
			arrowRoom = (int)((2+(caves.length - 1)*Math.random()));
			if((arrowRoom != wumpusRoom) && (arrowRoom != spiderRoom1) && (arrowRoom !=spiderRoom2) && (arrowRoom != pits1) && (arrowRoom != pits2))
			{
				break;
			}
		}
	}
	
	//giant bat room EC
	int batRoom;
	
	batRoom = (int)((2+(caves.length - 1)*Math.random()));
	if((batRoom == wumpusRoom) || (batRoom == spiderRoom1) || (batRoom == spiderRoom2) || (batRoom == pits1) || (batRoom == pits2) || (batRoom == arrowRoom))
	{
		while(true)
		{
			batRoom = (int)((2+(caves.length - 1)*Math.random()));
			if((batRoom != wumpusRoom) && (batRoom != spiderRoom1) && (batRoom !=spiderRoom2) && (batRoom != pits1) && (batRoom != pits2) && (batRoom != arrowRoom))
			{
				break;
			}
		}
	}
	
	//game variables
	int roomNum = 1;
	int moveRoom, shoot;
	Scanner cin = new Scanner(System.in);
	char choice;
	int arrows = 3;
	
	//prints obstacle rooms for testing
	/*
	System.out.println(wumpusRoom);
	System.out.println(spiderRoom1);
	System.out.println(spiderRoom2);
	System.out.println(pits1);
	System.out.println(pits2);
	System.out.println(arrowRoom);
	System.out.println(batRoom);
	*/
	
	//Game
	while(true)
	{
		System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * ");
		
		//starting room print out
		System.out.println(caves[roomNum - 1]);
		System.out.println(" ");
		
		//wumpus room
		if((caves[roomNum - 1].getAdj1() == wumpusRoom) || (caves[roomNum - 1].getAdj2() == wumpusRoom) || (caves[roomNum - 1].getAdj3() == wumpusRoom))
		{
			System.out.println("You smell some nasty B.O. from Bethany!");
			System.out.println(" ");
		}
		//spider room
		if((caves[roomNum - 1].getAdj1() == spiderRoom1) || (caves[roomNum - 1].getAdj2() == spiderRoom1) || (caves[roomNum - 1].getAdj3() == spiderRoom1) || (caves[roomNum - 1].getAdj1() == spiderRoom2) || (caves[roomNum - 1].getAdj2() == spiderRoom2) || (caves[roomNum - 1].getAdj3() == spiderRoom2))
		{
			System.out.println("You hear a faint pecking noise.");	
			System.out.println(" ");			
		}
		//bottomless pit room
		if((caves[roomNum - 1].getAdj1() == pits1) || (caves[roomNum - 1].getAdj2() == pits1) || (caves[roomNum - 1].getAdj3() == pits1) || (caves[roomNum - 1].getAdj1() == pits2) || (caves[roomNum - 1].getAdj2() == pits2) || (caves[roomNum - 1].getAdj3() == pits2))
		{
			System.out.println("You smell radioactive waste.");	
			System.out.println(" ");
		}
		
		//arrow supply room
		if((caves[roomNum - 1].getRoom() == arrowRoom))
		{
			arrows = 3;
			System.out.println("You found a supply room with magazines for your machine gun!");
			System.out.println("You now have a full inventory of 3 magazines!");
			System.out.println(" ");
		}
	
		//giant bat room EC
		if((caves[roomNum - 1].getRoom() == batRoom))
		{
			System.out.println("You walked into the room with the giant Karter! She picks you up and carries you to a different room.");
			roomNum = (int)((1+(caves.length - 1)*Math.random()));
			System.out.println(" ");
		}
		//as long as no bats
		else
		{
			//Move or shoot choice
			System.out.println("(M)ove or (S)hoot");
			choice = cin.next().charAt(0);
			System.out.println(" ");
		
			//move choice
			if((choice == 'M') || (choice == 'm'))
			{
				System.out.println("What room do you want to move to?");
				roomNum = cin.nextInt();
				System.out.println(" ");
			
				//Obstacle desc printout
				if(roomNum == wumpusRoom)
				{
					System.out.println("Oh no! You chose the room with Bethany. She barbeque's you with her fire and then eats you whole.");
					System.out.println("** You lose **");
					System.out.println("Game over!");
					break;
				}
				else if((roomNum == spiderRoom1) || (roomNum == spiderRoom2))
				{
					System.out.println("Oh no! You chose a room with the evil robot chickens. They peck you to death.");
					System.out.println("** You lose **");
					System.out.println("Game over!");
					break;
				}
				else if((roomNum == pits1) || (roomNum == pits2))
				{
					System.out.println("Oh no! You chose a room with the radioactive waste pool. You are boiled alive.");
					System.out.println("** You lose **");
					System.out.println("Game over!");
					break;
				}	
			}
			
			//shooting choice
			else if((choice == 'S') || (choice == 's'))
			{
				System.out.println("What room do you want to shoot an entire magazine into?");
				shoot = cin.nextInt();
				//if you still have arrows
				if(arrows > 0)
				{
					//hit wumpus and win the game
					if(shoot == wumpusRoom)
					{
						System.out.println("You shot and killed Bethany! ** You Win! **");
						System.out.println("Enjoy your fame!");
						break;
					}
					//miss and sends you back to move or shoot choice
					else
					{
						System.out.println("You shot into an empty room.");
						arrows--;
						System.out.println("You now have " + arrows + " magazines.");
						System.out.println(" ");
					}
				}
			
				//out of arrows
				else
				{
					System.out.println("You have no magazines left.");
					System.out.println("What room do you want to move to?");
					roomNum = cin.nextInt();
				}
			}
			
			//not an option choice
			else
			{
				System.out.println("That is not an option.");
				System.out.println(" ");
			}
			
		}
	}
	
  }
  
}
