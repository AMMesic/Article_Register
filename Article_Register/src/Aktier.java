class Aktier extends Vardesak {
			private int antalAktier;
			private double aktieKurs;

			public Aktier(String namn, int antalAktier, double aktieKurs) {
				super(namn);
				this.antalAktier = antalAktier;
				this.aktieKurs = aktieKurs;
			}
			
			public void setKurs(double nyKurs) {
				this.aktieKurs = nyKurs;
			}

			@Override
			public double getVarde() {
				double aktieVarde = (antalAktier * aktieKurs);
				return aktieVarde;

			}

			public String toString() {
				return super.toString() + (" Värde: " + getVarde() + " antal: " + antalAktier + "" + " kurs: " + aktieKurs);
			}

			
}