
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;



class PricelistTest {

	Pricelist priceList = new Pricelist();

	
	@Test
	public void add() {
		assertEquals(true,
				priceList.addProduct(new Product(1, "чс", new Price(70, 0))));
		assertEquals("чс", priceList.name(1));
		
		assertEquals(true,
				priceList.addProduct(new Product(5, "стул", new Price(10, 10))));
		assertEquals("стул", priceList.name(5));
		
		assertEquals(false,
				priceList.addProduct(new Product(5, "стул", new Price(10, 10))));
	}
	
	@Test
	public void changePrice() {
		priceList.addProduct(new Product(100, "стопка", new Price(17, 03)));
		priceList.changePrice(100, new Price(33, 33));
		assertEquals(new Price(33, 33), priceList.price(100));
		
		try {
			priceList.changePrice(123123123, new Price(1231231, 23));
			fail();
		}
		catch (NoSuchElementException e) {
			
		}
	}
	
	@Test
	public void rename() {
		priceList.addProduct(new Product(23, "укроп", new Price(0, 6)));
		priceList.rename(23, "оп");
		assertEquals("оп", priceList.name(23));
		
		try {
			priceList.rename(321321321, "321321321");
			fail();
		}
		catch (NoSuchElementException e) {
			
		}
	}
	
	@Test
	public void remove() {
		priceList.addProduct(new Product(255, "ny", new Price(20, 4)));
		assertEquals("ny", priceList.name(255));
		
		priceList.removeProduct(255);
		try {
			priceList.name(255);
			fail();
		} catch (NoSuchElementException e) {
			
		}
	}
	
	@Test
	public void sum() {
		priceList.addProduct(new Product(255, "ny", new Price(22, 0)));
		assertEquals(220.00, priceList.sum(255, 10), 1e-3);
		
		priceList.addProduct(new Product(23, "укроп", new Price(0, 0)));
		assertEquals(0.0, priceList.sum(23, 42), 1e-3);
		
		priceList.addProduct(new Product(42, "egg", new Price(5, 50)));
		assertEquals(16.50, priceList.sum(42, 3), 1e-3);
		
		try {
			priceList.sum(1803, 2018);
			fail();
		}
		catch (NoSuchElementException e) {
		
		}
	}
	
	@Test
	public void price() {
		priceList.addProduct(new Product(65, "глицин", new Price(25, 99)));
		assertEquals(new Price(25, 99), priceList.price(65));
		
		try {
			priceList.price(1147);
			fail();
		}
		catch (NoSuchElementException e) {
		
		}
	}
	
	@Test
	public void name() {
		priceList.addProduct(new Product(66, "бо€рышник", new Price(0, 0)));
		assertEquals("бо€рышник", priceList.name(66));
		
		try {
			priceList.name(1917);
			fail();
		}
		catch (NoSuchElementException e) {
		
		}
	}
	
}