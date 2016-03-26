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
				case "6": SkeletonCase6();
						break;
				case "3": System.out.println("Rakjatok be case-eket.");
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
		player.moveTo("felfele", new NormalFloor());
		player.moveTo("jobbra", new Switch());
		player.shootPortalThroughDoor(new Door(), "jobbra", new SpecialWall());
	}
	
	//Doboz felvétele, Switchre helyezése, majd áthaladás a kinyílt ajtón
	private static void SkeletonCase6() {
		Player player = new Player();
		player.moveTo("balra", new NormalFloor());
		NormalFloor nf = new NormalFloor();
		player.moveTo("lefele", nf);
		player.pickUpBox(nf);
		Switch mySwitch = new Switch();
		player.moveTo("felfele", mySwitch);
		player.putDownBox(mySwitch);
		player.moveTo("felfele", new Door());
	}

}
