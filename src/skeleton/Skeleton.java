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
				case "2": SkeletonCase2();
						break;
				case "3": SkeletonCase3();
						break;
				case "5": SkeletonCase5();
						break;
				case "6": SkeletonCase6();
						break;
				
				case "close": exit=true;
						break;
			}
		}
		scanner.close();
		System.out.println("Skeleton closed");
	}
	//Doboz felvétele -> átsétálás a portalon -> doboz lerakása
	public static void SkeletonCase3() {
		Player player = new Player();
		SpecialWall sw = new SpecialWall();
		player.moveTo(Direction.UP, new NormalFloor());
		player.pickUpBox(new NormalFloor());
		player.moveTo(Direction.DOWN, new NormalFloor());
		player.moveTo(Direction.LEFT, new NormalFloor());
		if (sw.getPassable())
			sw.interact(player);
		player.putDownBox(new NormalFloor());
	}
	
	//Switchre lépés -> ajtó kinyitása -> portal átlövése
	public static void SkeletonCase1() {
		Player player = new Player();
		player.moveTo(Direction.UP, new NormalFloor());
		player.moveTo(Direction.RIGHT, new Switch());
		player.shootPortalThroughDoor(new Door(), Direction.RIGHT, new SpecialWall());
	}
	
	//Doboz felvétele, Switchre helyezése, majd áthaladás a kinyílt ajtón
	private static void SkeletonCase6() {
		Player player = new Player();
		player.moveTo(Direction.LEFT, new NormalFloor());
		NormalFloor nf = new NormalFloor();
		player.moveTo(Direction.DOWN, nf);
		player.pickUpBox(nf);
		Switch mySwitch = new Switch();
		player.moveTo(Direction.UP, mySwitch);
		player.putDownBox(mySwitch);
		player.moveTo(Direction.UP, new Door());
	}
	//Kék portál lövése -> Sárga portal lövése -> áthaladás a portalon 
	private static void SkeletonCase5(){
		Player player = new Player();
		SpecialWall sw1 = new SpecialWall();
		SpecialWall sw2 = new SpecialWall();
		player.shootBluePortal(Direction.RIGHT, sw1);
		player.moveTo(Direction.DOWN, new NormalFloor());
		player.shootYellowPortal(Direction.UP, sw2);
		sw1.setPassable(true);
		sw2.setPassable(true);
		player.moveTo(Direction.LEFT, new NormalFloor());
		if (sw1.getPassable())
			sw1.interact(player);
	}
	//ZPM felvetele.
	private static void SkeletonCase2(){
		Player ONeil = new Player();
		
		NormalFloor nf1 = new NormalFloor();
		ONeil.moveTo(Direction.DOWN, nf1);
		
		NormalFloor nf2 = new NormalFloor();
		ONeil.moveTo(Direction.DOWN, nf2);
		
		NormalFloor nf3 = new NormalFloor();
		ONeil.moveTo(Direction.LEFT, nf3);
		ONeil.pickUpZpm(nf3);
	
	}
}
