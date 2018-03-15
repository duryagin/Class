
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;



class PricelistTest {

	Pricelist priceList = new Pricelist();

	
	@Test
	public void add() {
		priceList.addProduct(1, new Product("��", 70.00));
		assertEquals("��", priceList.name(1));
		priceList.addProduct(5, new Product("����", 19.89));
		assertEquals("����", priceList.name(5));
	}
	
	@Test
	public void changePrice() {
		priceList.addProduct(100, new Product("������", 17.03));
		priceList.changePrice(100, 33.33);
		assertEquals(33.33, priceList.price(100), 1e-3);
	}
	
	@Test
	public void rename() {
		priceList.addProduct(23, new Product("�����", 00.00));
		priceList.rename(23, "�����");
		assertEquals("�����", priceList.name(23));
	}
	
	@Test
	public void remove() {
		priceList.addProduct(255, new Product("ny", 22.00));
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
		priceList.addProduct(255, new Product("ny", 22.00));
		assertEquals(220.00, priceList.sum(255, 10), 1e-3);
		priceList.addProduct(23, new Product("�����", 00.00));
		assertEquals(0.0, priceList.sum(23, 42), 1e-3);
	}
	
	@Test
	public void price() {
		priceList.addProduct(65, new Product("������", 25.99));
		assertEquals(25.99, priceList.price(65), 1e-3);
	}
	
	@Test
	public void name() {
		priceList.addProduct(66, new Product("���������", 11.09));
		assertEquals("���������", priceList.name(66));
	}
	
}