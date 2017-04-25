package scene;

public class Game {

	public static void main(String[] args) {

		Fighter paladin = new Fighter("Paladin", 600, 30);
		Fighter hunter = new Fighter("Hunter", 600, 30);

		paladin.setEnemy(hunter);
		hunter.setEnemy(paladin);

		int paladinWin = 0;
		int hunterWin = 0;

		for (int i = 0; i < 100; i++) {
			System.out.println("---------------");
			while (true) {
				if (paladin.WhoIsAttackFirst() == 1) {
					paladin.hit();
				} else {
					hunter.hit();
				}
				if (hunter.isDead()) {
					System.out.println(paladin.getName() + "Is the Winner");
					paladinWin++;
					break;
				}

				if (paladin.isDead()) {
					System.out.println(hunter.getName() + "Is the Winner");
					hunterWin++;
					break;
				}

			}

			paladin.resetStats();
			hunter.resetStats();
		}
		System.out.println("Paladin wins: " + paladinWin);
		System.out.println("Hunter wins: " + hunterWin);

	}

}
