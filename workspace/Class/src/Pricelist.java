
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class Pricelist {

	private Map<Long, Product> priceList = new HashMap<>();
	
	
	public boolean addProduct(long code, Product product) {
		if (priceList.containsKey(code)) return false;
		priceList.put(code, product);
		return true;
	}
	
	public void changePrice(long code, double newPrice) {
		if (!priceList.containsKey(code))
			throw new NoSuchElementException();
		Product product = priceList.get(code);
		priceList.put(code, new Product(code, product.getName(), newPrice));
	}
	
	public void rename(long code, String newName) {
		if (!priceList.containsKey(code))
			throw new NoSuchElementException();
		Product product = priceList.get(code);
		priceList.put(code, new Product(code, newName, product.getPrice()));
	}
	
	public void removeProduct(long code) {
		if (!priceList.containsKey(code))
			throw new NoSuchElementException();
		priceList.remove(code);
	}
	
	public double sum(long code, int quantity) {
		if (!priceList.containsKey(code))
			throw new NoSuchElementException();
		double sum = 0.0;
		Product product = priceList.get(code);
		sum = quantity * product.getPrice();
		return sum;
	}
	
	 public double price(long code) {
		 if (!priceList.containsKey(code))
				throw new NoSuchElementException();
	        return (priceList.get(code)).getPrice();
	 }
	
	public String name(long code) {
		if (!priceList.containsKey(code))
			throw new NoSuchElementException();
        return priceList.get(code).getName();
    }
	
	
}
