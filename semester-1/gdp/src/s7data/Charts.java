package s7data;

public class Charts {
	public static void main(String[] args) {
		Song[] charts = new Song[10];
		
		Artist breadSheeran = new Artist("Ed Sheeran", "UK");
		Artist stellDirVorDrachen = new Artist("Imagine Dragons", "USA");
		
		charts[0] = new Song("Shape of You", 1, 89, breadSheeran);
		charts[3] = new Song("Thunder", 2, 50, stellDirVorDrachen);
		charts[9] = new Song("Galway Girl", 5, 48, breadSheeran);
	}
}

class Artist {
	String name;
	String country;
	
	public Artist(String name, String country) {
		this.name = name;
		this.country = country;
	}
}

class Song {
	String title;
	int bestPlace;
	int chartWeeks;
	Artist artist;
	
	public Song(String title, int bestPlace, int chartWeeks, Artist artist) {
		this.title = title;
		this.bestPlace = bestPlace;
		this.chartWeeks = chartWeeks;
		this.artist = artist;
	}
}