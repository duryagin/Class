
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class Pricelist {

	private Map<Long, Product> priceList = new HashMap<>();
	
	
	public boolean addProduct(Product product) {
		return priceList.putIfAbsent(product.getCode(), product) == null;
	}
	
	public void changePrice(long code, Price newPrice) {
		Product product = priceList.get(code);
		if (product == null) throw new NoSuchElementException();
		priceList.put(code, new Product(code, product.getName(), newPrice));
	}
	
	public void rename(long code, String newName) {
		Product product = priceList.get(code);
		if (product == null) throw new NoSuchElementException();
		priceList.put(code, new Product(code, newName, product.getPrice()));
	}
	
	public void removeProduct(long code) {
		if (priceList.remove(code) == null) throw new NoSuchElementException();
	}
	
	public double sum(long code, int quantity) {
		Product product = priceList.get(code);
		if (product == null) throw new NoSuchElementException();
		double sum = 0.0;
		sum = quantity *
				(product.getPrice().getRub() + product.getPrice().getCop() / 100.0);
		return sum;
	}
	
	 public Price price(long code) {
		 Product product = priceList.get(code);
			if (product == null) throw new NoSuchElementException();
		 return product.getPrice();
	 }
	
	public String name(long code) {
		Product product = priceList.get(code);
		if (product == null) throw new NoSuchElementException();
        return product.getName();
    }
	
}
