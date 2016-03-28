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
	//Doboz felv�tele -> �ts�t�l�s a portalon -> doboz lerak�sa
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
	
	//Switchre l�p�s -> ajt� kinyit�sa -> portal �tl�v�se
	public static void SkeletonCase1() {
		Player player = new Player();
		player.moveTo(Direction.UP, new NormalFloor());
		player.moveTo(Direction.RIGHT, new Switch());
		player.shootPortalThroughDoor(new Door(), Direction.RIGHT, new SpecialWall());
	}
	
	//Doboz felv�tele, Switchre helyez�se, majd �thalad�s a kiny�lt ajt�n
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
	//K�k port�l l�v�se -> S�rga portal l�v�se -> �thalad�s a portalon 
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
