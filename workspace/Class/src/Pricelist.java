
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class Pricelist {

	private Map<Long, Product> priceList = new HashMap<>();
	
	
	public void addProduct(long code, Product product) {
		priceList.put(code, product);
	}
	
	public void changePrice(long code, double newPrice) {
		Product product = priceList.get(code);
		priceList.remove(code);
		priceList.put(code, new Product(product.getName(), newPrice));
	}
	
	public void rename(long code, String newName) {
		Product product = priceList.get(code);
		priceList.remove(code);
		priceList.put(code, new Product(newName, product.getPrice()));
	}
	
	public void removeProduct(long code) {
		priceList.remove(code);
	}
	
	public double sum(long code, int quantity) {
		double sum = 0.0;
		Product product = priceList.get(code);
		sum = quantity * product.getPrice();
		return sum;
	}
	
	 public double price(long code) {
	        return (priceList.get(code)).getPrice();
	 }
	
	public String name(long code) {
		if (!priceList.containsKey(code))
			throw new NoSuchElementException();
        return priceList.get(code).getName();
    }
	
	
}
