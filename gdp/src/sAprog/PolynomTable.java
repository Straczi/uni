package sAprog;

import java.util.Arrays;
import java.util.Objects;

public class PolynomTable {
	public static void main(String[] args) {
		Polynom p = new Polynom(0.5, 3, 1, 0);
		Table t = new Table(p.derivative(), -10, 10, 41);
		System.out.println(t.getX(0)); // liefert -10
		System.out.println(t.getX(1)); // leifert -9.5
		System.out.println(t.getX(40)); // liefert 10
		System.out.println(t.getY(0));; // liefert 91
		System.out.println(t.getY(40)); // liefert 211
	}
}

class Polynom {
	double[] innerPolynom;

	public Polynom(double... polynom) {
		this.innerPolynom = Objects.requireNonNullElseGet(polynom, () -> new double[0]);
	}

	public Polynom derivative() {
		double[] newPolynom = new double[this.innerPolynom.length - 1];

		for (int i = 0; i < newPolynom.length; i++) {
			newPolynom[i] = this.innerPolynom[i] * (this.innerPolynom.length - i - 1);
		}

		return new Polynom(newPolynom);
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();

		for (int i = 0; i < this.innerPolynom.length; i++) {
			sb.append(this.innerPolynom[i]);
			sb.append("*(x^");
			sb.append(this.innerPolynom.length - i - 1);
			sb.append(") ");
		}

		return sb.toString();
	}

//	public double getX(int i) {
//		int y = 0;
//		for (int j = 0; j < this.innerPolynom.length; j++) {
//			y += this.innerPolynom[j] * Math.pow(i, this.innerPolynom.length - j - 1);
//		}
//
//		return y;
//	}

	@Override
	public boolean equals(Object otherObject) {
		if (this == otherObject) {
			return true;
		}

		boolean equals = true;

		if (otherObject instanceof Polynom other) {
			Polynom longer;
			Polynom shorter;

			if (this.innerPolynom.length < other.innerPolynom.length) {
				longer = other;
				shorter = this;
			} else {
				longer = this;
				shorter = other;
			}

			//Count leading zeroes
			int leadingZeroes = 0;
			for (int i = 0; i < longer.innerPolynom.length; i++) {
				if (longer.innerPolynom[i] != 0.0d) {
					break;
				}
				leadingZeroes++;
			}

			for (int i = 0; i < longer.innerPolynom.length; i++) {
				if (
						((longer.innerPolynom.length - i) <= shorter.innerPolynom.length)
						&& longer.innerPolynom[longer.innerPolynom.length - 1 - i] != shorter.innerPolynom[shorter.innerPolynom.length - 1 - i]
				) {

				}


				if (this.innerPolynom[i] != other.innerPolynom[i]) {
					equals = false;
					break;
				}
			}
		}

		return equals;
	}
}

class Table {
	double[] values;
	int from;
	int to;
	int steps;

	public Table(Polynom polynom, int from, int to, int steps) {
		double[] values = new double[steps];
		double stepSize = ((double) steps) / (to - from);

		double x = from;
		for (int i = 0; i < values.length; i++) {
			double value = 0;
			for (int j = 0; j < polynom.innerPolynom.length; j++) {
				value += polynom.innerPolynom[j] * Math.pow(from, polynom.innerPolynom.length - 1 - j);
			}
			values[i] = value;
		}

		this.values = values;
		this.from = from;
		this.to = to;
		this.steps = steps;
	}

	public int getX(int i) {
		
	}

	public double getY(int x) {
		return this.values[x];
	}
}
