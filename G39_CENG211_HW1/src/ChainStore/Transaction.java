package ChainStore;
//@author Ömer Genişoğlu 240201049
public class Transaction {
	private double purchase_price;
	private double sale_price;
	private int number_of_sales;
	Transaction(String purchase_price,String sale_price,String number_of_sales){
		this.purchase_price = Double.parseDouble(purchase_price);
		this.sale_price = Double.parseDouble(sale_price);
		this.number_of_sales = Integer.parseInt(number_of_sales);

	}
	public double getPurchasePrice(){
		return purchase_price;
	}
	public double getSalePrice(){
		return sale_price;
	}
	public int getNumberOfSales(){
		return number_of_sales;
	}
}
