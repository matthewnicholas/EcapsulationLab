package EncapsulationLab;

class EncapsulationLab
{
	public static void main(String args[])
	{
		Player Bob = new Player("Bob", 70);
		Player Tom = new Player("Tom", 48);
		Player Greg = new Player("Greg", 51);
		Team red = new Team("Red",Bob,Tom,Greg);
		
		Team blue = new Team("Blue",new Player("Sara",71),new Player("Adel",53),new Player("Geneca",33));
		Match match = new Match(red,blue,3,9);
		match.playMatch();
	}	
}
class Match
{
	Team one, two;
	int numberOfPlayers,numberOfGames;
	public Match(Team one, Team two, int numberOfPlayers,int numberOfGames) {
		super();
		this.one = one;
		this.two = two;
		this.numberOfPlayers = numberOfPlayers;
		this.numberOfGames = numberOfGames;
	}
	public void playMatch()
	{
		int onewins = 0;
		for (int i=0;i<numberOfGames;i++)
		{
			if (Math.random()*one.players[i%numberOfPlayers].Skill > Math.random()*two.players[i%numberOfPlayers].Skill)
				one.wins++;
			else
				two.wins++;
		}
		if (one.wins < two.wins)
			System.out.println("Team "+two.name + " wins "+ two.wins + " to " + one.wins);
		else 
			System.out.println("Team "+one.name + " wins "+ one.wins + " to " + two.wins);
	}
}
class Team
{
	Player players[] = new Player[3];
	String name;
	int wins=0;
	public Team(String name, Player a, Player b, Player c)
	{
		this.name = name;
		players[0] = a;
		players[1] = b;
		players[2] = c;
	}
}
class Player
{
	String name;
	int Skill;
	public Player(String name, int skill) {
		super();
		this.name = name;
		Skill = skill;
	}	
}
