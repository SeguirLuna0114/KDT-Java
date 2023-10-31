package sample11.dao;

import sample11.model.Product;

public class ProductDaoImpl implements ProductDao {
	public Product getProduct(String name) {	// String name="라면"
		return new Product(name, 2000);
	}
}