

public class Price {

	private int rub;
	private int cop;
	
	public Price (int rub, int cop) {
		if (rub < 0) throw new IllegalArgumentException();
		this.rub = rub;
		if (cop < 0 || cop > 99) throw new IllegalArgumentException();
		this.cop = cop;
	}
	
	public int getRub() {
		return this.rub;
	}
	
	public int getCop() {
		return this.cop;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Price price = (Price) obj;
		return (rub == price.rub && cop == price.cop);
	}
}