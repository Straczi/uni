package sAprog;

import java.util.Arrays;
import java.util.Objects;

public class PolynomTable {
	public static void main(String[] args) {
		System.out.println("a");
		var p = new Polynom(0.5, 3, 1, 0);
		System.out.println(p);
		System.out.println(Arrays.toString(p.innerPolynom));
		var pi = p.derivative();
		System.out.println(pi);
		System.out.println(Arrays.toString(pi.innerPolynom));
		System.out.println("y");
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

		if (otherObject instanceof Polynom) {
			Polynom other = (Polynom) otherObject;
			if (this.innerPolynom.length == other.innerPolynom.length) {
				for (int i = 0; i < this.innerPolynom.length; i++) {
					if (this.innerPolynom[i] != other.innerPolynom[i]) {
						return false;
					}
				}

				return true;
			} else {
				// TODO
			}
		}

		return false;
	}
}

class Table {
	double[] values;

	public Table(Polynom polynom, int from, int to, int stepSize) {

	}


}
