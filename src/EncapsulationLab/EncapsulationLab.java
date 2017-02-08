package EncapsulationLab;

class EncapsulationLab
{
	//mn branch
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
	private Team one, two;
	private int numberOfPlayers,numberOfGames;
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
			if (Math.random()*one.getPlayers()[i%numberOfPlayers].getSkill() > Math.random()*two.getPlayers()[i%numberOfPlayers].getSkill())
				one.setWins(one.getWins()+1);
			else
				two.setWins(two.getWins()+1);
		}
		if (one.getWins() < two.getWins())
			System.out.println("Team "+two.getName() + " wins "+ two.getWins() + " to " + one.getWins());
		else 
			System.out.println("Team "+one.getName() + " wins "+ one.getWins() + " to " + two.getWins());
	}
}
class Team
{
	private Player players[] = new Player[3];
	private String name;
	private int wins=0;
	public Team(String name, Player a, Player b, Player c)
	{
		this.name = name;
		players[0] = a;
		players[1] = b;
		players[2] = c;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Player[] getPlayers() {
		Player[] retPlayers = new Player[players.length];
		for(int i=0; i<players.length; i++)
			retPlayers[i] = players[i];
		
		return retPlayers;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int newWins) {
		this.wins = newWins;
	}
}
class Player
{
	private String name;
	private int Skill;
	
	public Player(String name, int skill) {
		super();
		this.name = name;
		Skill = skill;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSkill() {
		return this.Skill;
	}
}