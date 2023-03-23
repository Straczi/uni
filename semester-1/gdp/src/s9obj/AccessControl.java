package s9obj;

public class AccessControl {
	public static void main(String[] args) {
		User user = new User("nutzer");
		f(user);

		user.grantRight("read");
		user.grantRight("write");

		f(user);

		g(user);

		user.grantRight("delete");

		g(user);


		user.revokeRight("delete");

		f(user);
		g(user);

		user.revokeRight("read");

		f(user);
	}

	public static boolean f(User b) {
		if (b.hasRight("read") && b.hasRight("write")) {
			System.out.println("Benutzer " + b + " führt f aus");
			return true;
		} else {
			System.out.println("Benutzer " + b + " wurde f verweigert");
			return false;
		}
	}

	public static boolean g(User b) {
		if (b.hasRight("write") && b.hasRight("delete")) {
			System.out.println("Benutzer " + b + " führt g aus");
			return true;
		} else {
			System.out.println("Benutzer " + b + " wurde g verweigert");
			return false;
		}
	}
}

class User {
	private static int usercount = 0;

	private String name;
	private String[] rights;
	private int userID;

	public User(String name) {
		this.name = name;
		this.rights = new String[4];
		this.userID = usercount;

		usercount++;
	}

	public int getID() {
		return this.userID;
	}

	public void grantRight(String right) {
		if (!hasRight(right)) {
			for (int i = 0; i < rights.length; i++) {
				if (this.rights[i] == null) {
					this.rights[i] = right;
					break;
				}
			}
		}
	}

	public void revokeRight(String right) {
		for (int i = 0; i < rights.length; i++) {
			if (this.rights[i].equals(right)) {
				this.rights[i] = null;
				break;
			}
		}
	}

	public boolean hasRight(String right) {
		for (String r : this.rights) {
			if (r != null && r.equals(right)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
