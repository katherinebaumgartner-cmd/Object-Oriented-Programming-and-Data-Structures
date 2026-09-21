# Object-Oriented-Programming-and-Data-Structures
Hunt The Wumpus!
Here I have included the project description given to us.
**Description**
You are a mighty warrior, and armed with your trusty bow and 3 arrows, you enter The Caves in search of the mighty Wumpus. If you shoot the Wumpus, you are victorious and the masses will praise you, but if you stumble upon the Wumpus unawares, it will eat you! Also, beware of the webs of the giant poisonous spiders and the bottomless pits!
Your senses of smell and hearing will aid you on your quest, for the Wumpus does not bathe and can be smelled one room away. Also, the clicking mandibles of the poisonous spiders can be heard one room away, and the foul odor of a bottomless pit can be smelled one room away.

For this project, you will implement a program that lets the user play Hunt The Wumpus!

**Modeling the Caves**
The layout of the cave rooms is specified in a text file that looks like this (you may use this text file, but it is not required):

10
1 2 6 10
A wooden sign reads "Beware of the Wumpus!"
2 1 3 7
There is a black pool of water in the corner.
3 2 4 8
You see a Tyrannosaurus Rex fossil embedded in the wall.
4 3 5 9
There is an empty Diet Rite can here.
5 4 6 10
You almost step on a broken cellular phone.
6 1 5 7
A couple of evil rats stare at you from under a pile of rocks.
7 2 6 8
You find a Spanish doubloon on the floor.
8 3 7 9
The ceiling is very low and you have to stoop.
9 4 8 10
You step on a slippery spot, slip, and fall on your keester.
10 1 5 9
You get a strong sense of deja vu.
The first line of the text file gives the number of rooms in the caves (your program should handle any number of rooms). Each room is described on two lines: the first gives the room number, the room numbers of the three adjacent rooms (there are always 3); the second gives a string that describes the room.
Put this cave layout (or one in a similar format) into a text file. Your program should have two files with a minimum of two classes: one file/class to represent a single room, and a second file/class, with a main(), that plays the game and uses an array of room objects to hold the cave layout. One of the first things your program should do is open and read the layout file and put the information into your array of rooms.

Your program should then pick random numbers to figure out where to place the Wumpus, the two spider rooms (in two different rooms), and the two bottomless pits (in two different rooms). Make sure nothing ends up in room #1, as that is where the player starts, and don't put spiders, the wumpus, or a pit in the same room together. (That means any cave layout needs at least 6 rooms - room #1, the wumpus lair, and four rooms for obstacles.)

**Hand In**
Your program source code (.java files - probably two) and at least one sample run. If you create your own cave layout text file, please upload that too. If you do extra credit, be sure to demonstrate that in your sample run(s).

If you worked in a group, follow the instructions from the last assignment to indicate this properly.

**Playing the game**
Here is a sample game. Comments in italics are not visible to the player, but are there to help explain what is happening. The user's input appears in boldface.

Welcome to **Hunt The Wumpus!**

You are in room 1.
You have 3 arrows left.
A wooden sign reads "Beware of the Wumpus!"
There are tunnels to rooms 2, 6, and 10.
You hear a faint clicking noise. (There are spiders in room 6)
(M)ove or (S)hoot?
M
Which room?
5
Dimwit!  You can't get to there from here.
There are tunnels to rooms 2, 6, and 10.
(M)ove or (S)hoot?
M
Which room?
2

You are in room 2.
You have 3 arrows left.
There is a black pool of water in the corner.
There are tunnels to rooms 1, 3, and 7.
You smell a dank odor. (There is a pit in room 3)
You smell some nasty Wumpus! (The wumpus is in room 7)
(M)ove or (S)hoot?
S
Which room?
3 (The user picks the wrong room)
Your arrow goes down the tunnel and is lost.  You missed.

You are in room 2.
You have 2 arrows left.
There is a black pool of water in the corner.
There are tunnels to rooms 1, 3, and 7.
You smell a dank odor. 
You smell some nasty Wumpus! 
(M)ove or (S)hoot?
S
Which room?
7 
Your arrow goes down the tunnel and finds its mark!
You shot the Wumpus!  ** You Win! **

Enjoy your fame!

After the caves are all set up, the game proceeds. Have an integer (perhaps called currentRoom) to keep track of which room the warrior/player is in currently. Your program will then repeat the following loop:
Display the information about the current room. Print the room number, its description, and the list of adjacent rooms. Also check if any of the adjacent rooms have spiders, a pit, or the Wumpus and print a smell/hear message as appropriate. (If adjacent to two pits, only print one smelly message, and likewise for spiders.) You should also display the number of remaining arrows.
Ask the player if they want to move or shoot.
If the player shoots, have them pick which of the adjacent rooms to shoot into. If that room contains the wumpus, the player wins and the game is over. If not, reduce the number of arrows by one. If the player runs out of arrows, they lose.
DO NOT kill off the spiders (there are too many) or create an "arrow bridge" over bottomless pits (really?) - the obstacles cannot be removed or destroyed with arrows.
If the player moves, ask for the room number and change currentRoom. If the new room contains spiders, a pit, or the Wumpus, the game is over.
Do not let the user move or shoot into a room that is not adjacent to the current room.

**Extra Credit (up to 9 points)**
On the first line of the cave layout file, after the number of rooms, have your program accept the number of spider rooms and bottomless pits. Thus, if the first line was
25 5 3
your cave would have 25 rooms, with 5 of those having poisonous spiders, and 3 rooms with pits. These rooms are still chosen randomly. [3 points]
Add a supply room that contains arrows. If the player enters this room, their arrows are refilled back to 3. Note that the game does not end if the player runs out of arrows. [2 points]
Add a room (chosen at random) with giant bats. If the player enters that room, the bats pick him/her up and fly to a random room before dropping the player (unharmed). If the new random room has the wumpus, a pit, or spiders, the game is over. The bats should move the player out of the room they are in. [3 points]
Skin the game - choose different words to describe the exact same objects and functionality to change the feel of the game. For example, instead of caves, they are rooms on a space station, with laser charges instead of arrows, bottomless pits become holes into the vacuum of space, and the spiders are insane worker robots. The wumpus is an evil space alien. You get the idea. Be sure to give me a quick translation guide in your comments for easy grading. Keep it PG-rated please. [1 point for creativity]

**Notes**
Remember to include comments.
Think carefully about how you design your room class. If you do it well, this is not a hard program to write.
Write this program in pieces. First, type up the layout text file and write a program to simply read in the file and print the cave info on the screen so you know it is reading correctly. Then, you might try to set up the program so the player can move around, but there are no monsters or pits.
Start right away!

**Credits**
Gregory Yob, "Hunt the Wumpus", Creative Computing, volume 1, 1976, pages 247-250. See http://www.atariarchives.org/bcc1/showpage.php?page=247.
