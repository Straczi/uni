package s9obj;

public class Appartment {
	Room[] rooms;
	float deckenhoehe;

	public Appartment(float deckenhoehe) {
		this.deckenhoehe = deckenhoehe;
		this.rooms = new Room[10];
	}

	public void includeRoom(String name, float length, float width) {
		Room newRoom = new Room(name, length, width);
		for (int i = 0; i < this.rooms.length; i++) {
			if (this.rooms[i] == null) {
				this.rooms[i] = newRoom;
				return;
			}
		}
	}

	public float getArea(String name) {
		for (Room room : this.rooms) {
			if (room != null && room.name.equals(name)) {
				return room.getArea();
			}
		}

		return 0.0f;
	}

	public float getArea() {
		float area = 0.0f;

		for (Room room : this.rooms) {
			if (room != null) {
				area += room.getArea();
			}
		}

		return area;
	}

	public float getSpace() {
		return this.getArea() * this.deckenhoehe;
	}

	public float getLongestWall() {
		float longestWall = Float.MIN_VALUE;
		for (Room room : this.rooms) {
			if (room != null) {
				if (longestWall < room.length) {
					longestWall = room.length;
				}
				if (longestWall < room.width) {
					longestWall = room.width;
				}
			}
		}

		return longestWall;
	}

	public static void main(String[] args) {
		Appartment appartment = new Appartment(1);
		System.out.println(appartment.getArea());

		appartment.includeRoom("test", 2, 2);
		System.out.println(appartment.getArea());

	}
}

class Room {
	String name;
	float length;
	float width;

	public Room(String name, float length, float width) {
		this.name = name;
		this.length = length;
		this.width = width;
	}

	public float getArea() {
		return this.length * this.width;
	}
}
