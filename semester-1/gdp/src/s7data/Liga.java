package s7data;

//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;

public class Liga {
	private static Team[] teams;
	
	public static Team[] createTeams(String... names) {
//		assertNotNull(names);
		
		Team[] teams = new Team[names.length];
		
		for (int i = 0; i < teams.length; i++) {
			teams[i] = new Team(names[i]);
		}
		
		Liga.teams = teams;
		return teams;
	}
	
	public static Team getTeam(String name) {
//		assertNotNull(name);
		
		Team team = null;
		
		for(Team t : teams) {
			if (t.name.equals(name)) {
				team = t;
			}
		}
		
		return team;
	}
	
	public static void match(Team heim, Team gast, int toreHeim, int toreGast) {
//		assertNotNull(heim);
//		assertNotNull(gast);
//		assertTrue(heim != gast);
//		assertTrue(toreHeim >= 0);
//		assertTrue(toreGast >= 0);
		
		heim.goalDifference += toreHeim;
		gast.goalDifference += toreGast;
		
		heim.goalDifference -= toreGast;
		gast.goalDifference -= toreHeim;
		
		heim.matches++;
		gast.matches++;
		
		if (toreHeim == toreGast) {
			heim.points++;
			gast.points++;
		} else if(toreHeim < toreGast) {
			gast.points += 3;
		} else {
			heim.points += 3;
		}
	}
	
	public static int getGoalDiff(Team team) {
//		assertNotNull(team);
		return team.goalDifference;
	}
	
	public static int getMatches(Team team) {
//		assertNotNull(team);
		return team.matches;
	}
	
	public static int getPoints(Team team) {
//		assertNotNull(team);
		return team.points;
	}
}

class Team {
	public String name;
	int matches = 0;
	int points = 0;
	int goalDifference = 0;
	
	public Team(String name) {
		this.name = name;
	}
}
