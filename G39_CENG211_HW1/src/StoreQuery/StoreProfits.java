package StoreQuery;
import ChainStore.AnnualSale;
import ChainStore.ItemTransaction;
//@author Ömer Genişoğlu 240201049
public class StoreProfits {
    public String[] best_stores_month_by_month = new String[12];
    private double[][] profit_by_months = new double[4][12];
    ItemTransaction[] item_transactions;
    public StoreProfits(AnnualSale a ){
        item_transactions = a.item_transactions;
        calculate();
        bestStoresMonthByMonth();
    }
    private void calculate() {	//We are calculating and adding elements to array profit_by_months. 
        for (int store = 0; store < 4; store++) {
            for (int month = 0; month < 12; month++) {
                for (int item = 0; item < 32; item++) {
                    double purchase = item_transactions[item].transactions[store][month].getPurchasePrice();
                    double sale = item_transactions[item].transactions[store][month].getSalePrice();
                    int sale_number = item_transactions[item].transactions[store][month].getNumberOfSales();
                    profit_by_months[store][month] += (sale - purchase) * sale_number;
                }
            }
        }
    }
    private void bestStoresMonthByMonth(){
        double max;				//We are searching most profitable month for each store.
        for(int i =0;i<12;i++){
            max = profit_by_months[0][i];
            String max_store = "1";
            for (int j =0;j<4;j++){
                if (profit_by_months[j][i]>max){
                    max = profit_by_months[j][i];
                    max_store = Integer.toString(j+1);
                }
            }
            best_stores_month_by_month[i] = max_store;
        }
    }
}
