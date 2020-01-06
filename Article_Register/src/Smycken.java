	class Smycken extends Vardesak {
		private int antalAdelStenar;
		private boolean guld;

		public Smycken(String namn, boolean guld, int antalAdelStenar) {
			super(namn);
			this.antalAdelStenar = antalAdelStenar;
			this.guld = guld;
		}

		public double getVarde() {
			double varde = getMetallVarde() + (500 * antalAdelStenar);
			return varde;
		}

		public int getMetallVarde() {
			if (guld) {
				return 2000;
			} else {
				return 700;
			}
		}

		public String getMetall() {
			if (guld) {
				return "Guld,";
			} else {
				return "Silver,";
			}
		}

		public String toString() {
			return super.toString() + (" Värde: " + getVarde() + " av: " + getMetall() + " antal ädelstenar: " + antalAdelStenar);

		}

		
	}
