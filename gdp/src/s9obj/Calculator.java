package s9obj;

public class Calculator {
	public static void main(String[] args) {
		BigInt a = new BigInt("00069");
		BigInt b = new BigInt("0001");

		System.out.println(a.add(b));
	}
}

class BigInt {
	byte[] parts;

	public BigInt(String number) {
		int leadingZeroes = 0;
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == '0') {
				leadingZeroes++;
			} else {
				break;
			}
		}

		byte[] parts = new byte[number.length() - leadingZeroes];

		for (int i = leadingZeroes; i < number.length(); i++) {
			parts[i - leadingZeroes] = (byte) (number.charAt(i) - '0');
		}

		this.parts = parts;
	}

	public BigInt add(BigInt other) {
		BigInt shorterInt;
		BigInt longerInt;

		if (this.parts.length <= other.parts.length) {
			shorterInt = this;
			longerInt = other;
		} else {
			longerInt = this;
			shorterInt = other;
		}

		StringBuilder result = new StringBuilder();

		byte carry = 0;
		for (int i = 0; i < longerInt.parts.length; i++) {
			byte digit1 = longerInt.getDigit(i);
			byte digit2 = shorterInt.getDigit(i);

			// Compute the raw sum, which might be too large to stuff in a single digit
			byte rawSum = (byte) (digit1 + digit2 + carry);

			// Get the ten-part
			carry = (byte) (rawSum / 10);
			// Get the one-part
			result.append(rawSum % 10);
		}

		result.append(carry); // Don't forget the last carry
		result.reverse(); // Reverse because the digits are read from right to left

		return new BigInt(result.toString());
	}

	@Override
	public String toString() {
		if (this.parts.length == 0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for(byte part : this.parts) {
			sb.append(part);
		}

		// No need to reverse the StringBuilder here because we already iterate over the digits from the front and append
		return sb.toString();
	}

	private byte getDigit(int index) {
		if (index < this.parts.length) {
			return this.parts[this.parts.length - 1 - index]; // Digits go from right to left
		} else {
			return 0;
		}
	}
}

