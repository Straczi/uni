public class PolynomTable {
	public static void main(String[] args) {
		var p = new Polynom(0.5, 3, 1, 0);
		System.out.println(p);
	}
}

class Polynom {
	double[] innerPolynom;

	public Polynom(double... polynom) {
		this.innerPolynom = polynom;
	}

	public Polynom derivative() {
		double[] newPolynom = new double[this.innerPolynom.length - 1];

		for (int i = 0; i < newPolynom.length; i++) {
			newPolynom[i] = this.innerPolynom[i];
		}

		return new Polynom(newPolynom);
	}

	@Override
	public String toString() {
		var sb = new StringBuilder();

		for (int i = 0; i < this.innerPolynom.length; i++) {
			sb.append(i);
			sb.append("*x ^");
			sb.append(this.innerPolynom.length - i);
			sb.append(" ");
		}

		return sb.toString();
	}
}

class Table {
	
}