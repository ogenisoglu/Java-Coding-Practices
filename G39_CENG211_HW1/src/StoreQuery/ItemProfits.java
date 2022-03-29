package StoreQuery;
import ChainStore.*;
//@author Ömer Genişoğlu 240201049
public class ItemProfits {
    public String most_item;
    public String least_item;
    public String best_selling_item;
    public String most_single_sale;
    private ItemTransaction[] item_transactions = new ItemTransaction[32];
    private double[] item_profits = new double[32];
    private int[] item_selling_numbers = new int[32];
    private double[] most_single_salee = new double[2];
    public ItemProfits(AnnualSale annual_sale){
        item_transactions = annual_sale.item_transactions;
        loadProfitsAndSellingNumbers();
        mostAndLeastAndBest();

    }
    private void loadProfitsAndSellingNumbers(){
        for (int i=0 ;i<32 ;i++){
            for (int j=0 ;j<4 ;j++){
                for (int k=0; k<12;k++) {
                    double sale = item_transactions[i].transactions[j][k].getSalePrice();
                    double purchase = item_transactions[i].transactions[j][k].getPurchasePrice();
                    int sale_number = item_transactions[i].transactions[j][k].getNumberOfSales();
                    double difference = sale-purchase;
                    item_profits[i] += difference*sale_number;
                    item_selling_numbers[i] += sale_number;
                    if (difference>most_single_salee[1]){
                        most_single_salee[0] = i;			
                        most_single_salee[1] = difference;  
                    }// Here we are collecting all profits of all items.
                }	 // Also we are finding biggest difference between  
            }		 // purchase and sale in last three lines.
        }
        most_single_sale = findItem((int)most_single_salee[1]);
    }
    private void mostAndLeastAndBest(){
        double max = item_profits[0];
        double min = item_profits[0];
        int best_selling_number = item_selling_numbers[0];
        for (int i=0;i<32;i++){			//We are searching best-selling item in item_selling_numbers,
            if (item_profits[i]>max){	//most profitable item and least profitable item 
                most_item = findItem(i);
            }else if(item_profits[i]<min){
                least_item = findItem(i);
            }
            if (best_selling_number<item_selling_numbers[i]){
                best_selling_number = item_selling_numbers[i];
                best_selling_item = findItem(i);
            }
        }
    }
    private String findItem(int i) {
        for (ItemTransaction k : item_transactions) {
            String a = Integer.toString(i+1);
            String b = k.item.getID(); 	//Finding names of items by using ID.
            if (a.equals(b)) {
                return k.item.getName();
            }
        }
        return "";
    }
}
