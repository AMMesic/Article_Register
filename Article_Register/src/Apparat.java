class Apparat extends Vardesak {
				private double inkopsPris;
				private double slitage;
				private static final double MOMS = 1.25;

				public Apparat(String namn, double inkopsPris, double slitage) {
					super(namn);
					this.inkopsPris = inkopsPris;
					this.slitage = slitage;
				}

				public double getVarde() {
					double varde = (inkopsPris * (slitage / 10)) * (MOMS);
					return varde;
				}

				public String toString() {
					return super.toString() + ( " värde: " + getVarde() + " inköpspris: " + inkopsPris + " skick: " + slitage);
				}

				
			}
