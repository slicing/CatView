package Slow.slicing.procude;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Product{
	private int id;
	private String name;
	private double price;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
class Products implements Iterable{
	List<Product> gerence = new ArrayList<>();
	public Products() {

		gerence.add(new Product(1,"Iphone",3999));
		gerence.add(new Product(2,"Huawei",5999));
		gerence.add(new Product(3,"Mi",6999));
		gerence.add(new Product(4,"X",2999));
	}



	@Override
	public Iterator iterator() {
		return gerence.iterator();
	}
}
public class GerenceIterato {
	public static void main(String[]args){
		Products products = new Products();
		products.forEach(System.out::println);

	}

}
