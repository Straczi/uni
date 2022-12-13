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
		System.out.println(t.getY(0)); // liefert 91
		System.out.println(t.getY(40)); // liefert 211

		Polynom p1 = new Polynom(1, 2, 3, 4, 5);
		Polynom p2 = new Polynom(1, 2, 3, 4, 5);

		System.out.println(p1.equals(p2));

		Polynom p3 = new Polynom(0, 0, 0, 0, 1, 2, 3, 4, 5);
		System.out.println(p1.equals(p3));

		Polynom p4 = new Polynom(1, 0);
		System.out.println(p4);
		Table t2 = new Table(p4, 0, 10, 10);
		System.out.println(Arrays.toString(p4.innerPolynom));
		System.out.println(t2.getX(0));
		System.out.println(t2.getX(2));
		System.out.println(t2.getX(10));
		System.out.println(t2.getY(0));
		System.out.println(t2.getY(2));
		System.out.println(t2.getY(10));

		System.out.println();
		System.out.println("Derivatives:");
		System.out.println();

		Polynom pd1 = new Polynom(1, 1, 1, 1, 0);
		Polynom pd2 = pd1.derivative();

		System.out.println(pd1);
		System.out.println(pd2);

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
			sb.append("+ ");
		}

		return sb.toString();
	}

//	@Override
//	public boolean equals(Object otherObject) {
//		if (this == otherObject) {
//			return true;
//		}
//
//		if (otherObject instanceof Polynom other) {
//			Polynom longer;
//			Polynom shorter;
//
//			if (this.innerPolynom.length < other.innerPolynom.length) {
//				longer = other;
//				shorter = this;
//			} else {
//				longer = this;
//				shorter = other;
//			}
//
//			for (int i = 0; i < longer.innerPolynom.length; i++) {
//				double a = longer.innerPolynom[longer.innerPolynom.length - i - 1];
//				double b = (i < shorter.innerPolynom.length) ? shorter.innerPolynom[shorter.innerPolynom.length - i - 1] : 0;
//
//				if (a != b) {
//					return false;
//				}
//			}
//
//			return true;
//		}
//
//		return false;
//	}

	public boolean equals(Polynom other) {
		Polynom longer;
		Polynom shorter;

		if (this.innerPolynom.length < other.innerPolynom.length) {
			longer = other;
			shorter = this;
		} else {
			longer = this;
			shorter = other;
		}

		for (int i = 0; i < longer.innerPolynom.length; i++) {
			double a = longer.innerPolynom[longer.innerPolynom.length - i - 1];
			double b = (i < shorter.innerPolynom.length) ? shorter.innerPolynom[shorter.innerPolynom.length - i - 1] : 0;

			if (a != b) {
				return false;
			}
		}

		return true;
	}
}

class Table {
	Polynom polynom;
	int from;
	int to;
	int steps;

	public Table(Polynom polynom, int from, int to, int steps) {
		this.from = from;
		this.to = to;
		this.steps = steps;
		this.polynom = polynom;
	}

	public double getX(double x) {
		double diff = Math.abs(this.to - this.from);
		double stepSize = diff / (steps - 1);
		return this.from + stepSize * x;
	}


	public double getY(double x) {
		x = getX(x);
		System.out.println("x = " + x);

		double y = 0;

		for (int i = 0; i < this.polynom.innerPolynom.length; i++) {
			int degree = this.polynom.innerPolynom.length - 1 - i;
			System.out.println("Degree = " + degree);
			y += this.polynom.innerPolynom[i] * Math.pow(x, degree);
		}

		return y;
	}
}
