abstract class Vardesak {
	private String namn;

	public Vardesak(String namn) {
		this.namn = namn;
	}


	abstract public double getVarde();
	
	public String getNamn() {
		return namn;
	}

	public String toString() {
		return this.namn;
	}
}

	/*class Smycken extends Vardesaker {
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
				return "Guld";
			} else {
				return "Silver";
			}
		}

		public String toString() {
			return (namn + "Värde: " + getVarde() + " av: " + getMetall() + "antal ädelstenar: " + antalAdelStenar);

		}

		class Aktier extends Vardesaker {
			private int antalAktier;
			private double aktieKurs;

			public Aktier(int antalAktier, double aktieKurs) {
				super(namn);
				this.antalAktier = antalAktier;
				this.aktieKurs = aktieKurs;
			}

			@Override
			public double getVarde() {
				double aktieVarde = (antalAktier * aktieKurs);
				return aktieVarde;

			}

			public String toString() {
				return (namn + " Värde " + getVarde() + "antal: " + antalAktier + "" + "kurs: " + aktieKurs);
			}

			class Apparat extends Vardesaker {
				private double inkopsPris;
				private double slitage;

				public Apparat(double inkopsPris, double slitage) {
					super(namn);
					this.inkopsPris = inkopsPris;
					this.slitage = slitage;
				}

				public double getVarde() {
					double varde = inkopsPris * (slitage / 10);
					return varde;
				}

				public String toString() {
					return (namn + " värde: " + getVarde() + "inköpspris: " + inkopsPris + " skick: " + slitage);
				}
			}

		}*/
	


