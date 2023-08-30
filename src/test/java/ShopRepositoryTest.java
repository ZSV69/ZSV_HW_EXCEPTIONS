import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testRemoveFoundProduct() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(3, "Блокнот", 130);
        Product product2 = new Product(13, "Кружка", 250);
        Product product3 = new Product(33, "Колонки", 2300);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.remove(33);

        Product[] expected = {product1, product2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveNotFoundProduct() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(3, "Блокнот", 130);
        Product product2 = new Product(13, "Кружка", 250);
        Product product3 = new Product(33, "Колонки", 2300);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(55);
        });
    }
}
