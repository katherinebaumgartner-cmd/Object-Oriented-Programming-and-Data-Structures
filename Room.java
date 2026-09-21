import java.io.*;
import java.util.*;

class Room 
{
	int roomNum, adj1, adj2, adj3;
	String desc; 
	
	// Constructor
	public Room(Scanner f)
	{
		roomNum = f.nextInt();
		adj1 = f.nextInt();
		adj2 = f.nextInt();
		adj3 = f.nextInt();
		desc = f.nextLine();
		desc = f.nextLine();
	}
	
	
	public int getRoom() { return roomNum; }
	public int getAdj1() { return adj1; }
	public int getAdj2() { return adj2; }
	public int getAdj3() { return adj3; }
	
	public String toString()
	{
		return "You are in room number " + roomNum + ". " + desc + " The adjacent rooms are " + adj1 + ", " + adj2 + ", " + adj3 + ". ";
	}
	
}