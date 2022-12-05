public class DistanceUnit {
	public static void main(String[] args) {
		Measurement measurement = new Measurement(Unit.METER, 4);
		System.out.println(measurement.getAs(Unit.MILLIMETER));; // liefert 4000.0
		System.out.println(measurement.toString(Unit.KILOMETER));; // liefert 0.004 km
	}
}

enum Unit {
	MILLIMETER("mm", 0.001),
	FEET("ft", 0.3048),
	METER("m", 1),
	KILOMETER("km", 1000);
	String name;

	double factor;

	Unit(String name, double factor) {
		this.name = name;
		this.factor = factor;
	}

	public String toString() {
		return this.name;
	}
	public double getFactorToOtherUnit(Unit unit) {
		return this.factor / unit.factor;
	}

}

class Measurement {
	private Unit unit;
	private double value;

	public Measurement(Unit unit, double value) {
		this.unit = unit;
		this.value = value;
	}

	public Measurement(double value, Unit unit) {
		this.unit = unit;
		this.value = value;
	}


	public double getAs(Unit other) {
		double factor = this.unit.getFactorToOtherUnit(other);
		return this.value * factor;
	}

	public String toString(Unit unit) {
		double factor = this.unit.getFactorToOtherUnit(unit);
		return (this.value * factor) + " " + unit.name;
	}
}
