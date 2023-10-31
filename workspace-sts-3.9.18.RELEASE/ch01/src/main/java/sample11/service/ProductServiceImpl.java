package sample11.service;

import sample11.dao.ProductDao;
import sample11.model.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDao pd;
	
	// Set메소드로 DAO클래스의 객체를 주입받음
	// ProductDao pd = new ProductDaoImpl(); 코드와 같음
	public void setPd(ProductDao pd) {
		this.pd = pd;
	}

	public Product getProduct() {
		return pd.getProduct("라면");
	}
}