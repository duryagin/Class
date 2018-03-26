

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cop;
		result = prime * result + rub;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		if (cop != other.cop)
			return false;
		if (rub != other.rub)
			return false;
		return true;
	}
	
}