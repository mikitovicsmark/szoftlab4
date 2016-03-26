package skeleton;

import java.util.Scanner;

public class Skeleton {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;
		while (scanner.hasNext() && !exit) {
			switch (scanner.next()) {
				case "1": SkeletonCase1();
						break;
				case "2": System.out.println("Rakjatok be case-eket.");
						break;
				case "close": exit=true;
						break;
			}
		}
		scanner.close();
		System.out.println("Skeleton closed");
	}
	
	//Switchre lépés -> ajtó kinyitása -> portal átlövése
	public static void SkeletonCase1() {
		Player player = new Player();
		player.moveTo("felfele", new Cell());
		player.moveTo("jobbra", new Switch());
		player.shootPortalThroughDoor(new Door(), "jobbra", new SpecialWall());
	}

}
