import java.util.Arrays;

public class HorseRace {
	Horse[] horses = new Horse[0];

	// Sollte das nicht eigentlich registerHorse heißen???
	public boolean registrateHorse(Horse horse) {
		if (!this.contains(horse)) {
			Horse[] newHorses = Arrays.copyOf(this.horses, this.horses.length + 1);
			newHorses[newHorses.length - 1] = horse;
			return true;
		}

		return false;
	}

	public Horse[] listedHorses() {
		return this.horses;
	}

	public void start() {
		while (getChampion() == null) {
			for (Horse h : this.horses) {
				h.sprint();
			}
		}
	}

	public String getChampion() {
		for (Horse h : this.horses) {
			if (h.distance >= 100) {
				return h.name;
			}
		}

		return null;
	}

	boolean contains(Horse horse) {
		for (Horse h : this.horses) {
			if (h.name.equals(horse.name)) {
				return true;
			}
		}
		return false;
	}
}

class Horse {
	String name;
	int maxSpeed;
	int distance = 0;

	public Horse(String name, int maxSpeed) {
		this.name = name;
		this.maxSpeed = maxSpeed;
	}

	public void sprint() {
		int randomDistance = (int) (Math.random() * (this.maxSpeed - 1) + 1);
		this.distance += randomDistance;
	}

	public int getDistance() {
		return this.distance;
	}

	public String getName() {
		return this.name;
	}
}

class BetSlip {
	HorseRace horseRace;
	String name;
	int bet;

	public BetSlip(HorseRace horseRace, String name, int bet) {
		this.horseRace = horseRace;
		this.name = name;
		this.bet = bet;
	}

	public HorseRace getRace() {
		return this.horseRace;
	}

	public String getHorseName() {
		return this.name;
	}

	public int getBet() {
		return this.bet;
	}
}

class BettingShop {
	HorseRace horseRace;

	public void open(HorseRace horseRace) {
		this.horseRace = horseRace;
	}

	public BetSlip placeBet(String horseName, int bet) {
		if (horseRace != null) {
			return new BetSlip(this.horseRace, horseName, bet);
		}

		return null;
	}

	public boolean validateBetSlip(BetSlip betSlip) {
		return betSlip != null
				&& this.horseRace == betSlip.horseRace
				&& Arrays.stream(this.horseRace.horses).anyMatch(h -> h.name.equals(betSlip.name));
	}

	public int payOut(BetSlip betSlip) {
		if (validateBetSlip(betSlip) && this.horseRace.getChampion().equals(betSlip.name)) {
			return betSlip.bet * 2;
		}

		return 0;
	}
}
