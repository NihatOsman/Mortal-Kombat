package scene;

import java.util.Random;

public class Fighter {

	private static final int MIN_HEALTH = 500;
	private static final int MIN_DMG = 20;
	private static final int MAX_HEALTH = 1000;
	private static final int MAX_DMG = 100;

	private String name;
	private Fighter enemy;
	private int dmg;
	private int health;

	public Fighter(String name) {
		if (name != null && !(name.isEmpty())) {
			this.name = name;
		} else {
			this.name = "Warrior";
		}
		health = MIN_HEALTH;
		dmg = MIN_DMG;

	}

	public Fighter(String name, int health, int dmg) {
		this(name);
		if (health > 0 && health < MAX_HEALTH) {
			this.health = health;
		}
		if (dmg > 0 && dmg < MAX_DMG) {
			this.dmg = dmg;
		}
	}

	public void setEnemy(Fighter enemy) {
		if (enemy != null && enemy != this) {
			this.enemy = enemy;
		}
	}

	public void hit() {
		if (!enemy.dodge()) {
			if (enemy.block()) {
				System.out.println(enemy.name + " blockes the hit!");
				enemy.takeHit(this.dmg * 0.5);
			} else {
				if (enemy.SpecialAttack() == 1) {
					enemy.takeHit(this.dmg * 1.5);
				}
				if (enemy.SpecialAttack() == 2) {
					enemy.takeHit(this.dmg * 1.5);
				} else {
					enemy.takeHit(this.dmg);
				}
			}
		}

	}

	private void takeHit(double dmg) {

		System.out.println(this.name + " takes " + dmg + " dmg from " + enemy.getName());
		this.health -= dmg;
	}

	private boolean dodge() {
		boolean dodge = new Random().nextBoolean();
		if (dodge) {
			System.out.println(this.name + " dodges the hit! ");
		}
		return dodge;
	}

	public String getName() {
		return this.name;
	}

	public boolean isDead() {
		return this.health <= 0;
	}

	private boolean block() {
		Random random = new Random();
		int rand = random.nextInt(3);
		return rand == 1;
	}

	public void resetStats() {
		this.health = MIN_HEALTH;
	}

	public int WhoIsAttackFirst() {
		Random random = new Random();
		int rand = random.nextInt(2);
		if (rand == 1) {
			return 1;
		}
		return 0;

	}

	public int SpecialAttack() {
		Random random = new Random();
		int rand = random.nextInt(11);
		if (rand == 1) {
			return 1;
		}
		if (rand == 2) {
			return 2;
		}
		return 0;

	}

}
