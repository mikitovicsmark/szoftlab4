package skeleton;

public final class Scheduler {
	public static void Print(String message) {
		try {
			Thread.sleep(1000);
			System.out.println(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
