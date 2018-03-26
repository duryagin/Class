
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class Pricelist {

	private Map<Long, Product> priceList = new HashMap<>();
	
	
	public boolean addProduct(Product product) {
		return priceList.put(product.getCode(), product) == null;
	}
	
	public void changePrice(long code, Price newPrice) {
		if (priceList.get(code) == null) throw new NoSuchElementException();
		Product product = priceList.get(code);
		priceList.put(code, new Product(code, product.getName(), newPrice));
	}
	
	public void rename(long code, String newName) {
		if (priceList.get(code) == null) throw new NoSuchElementException();
		Product product = priceList.get(code);
		priceList.put(code, new Product(code, newName, product.getPrice()));
	}
	
	public void removeProduct(long code) {
		if (priceList.remove(code) == null) throw new NoSuchElementException();
		priceList.remove(code);
	}
	
	public double sum(long code, int quantity) {
		if (priceList.get(code) == null) throw new NoSuchElementException();
		double sum = 0.0;
		Product product = priceList.get(code);
		sum = quantity *
				(product.getPrice().getRub() + product.getPrice().getCop() / 100.0);
		return sum;
	}
	
	 public Price price(long code) {
		 if (priceList.get(code) == null) throw new NoSuchElementException();
		 return (priceList.get(code)).getPrice();
	 }
	
	public String name(long code) {
		if (priceList.get(code) == null) throw new NoSuchElementException();
        return priceList.get(code).getName();
    }
	
	
}
