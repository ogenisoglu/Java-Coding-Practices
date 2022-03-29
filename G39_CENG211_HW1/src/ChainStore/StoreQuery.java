package ChainStore;
import StoreQuery.*;
//@author Ömer Genişoğlu 240201049
public class StoreQuery {
    private AnnualSale annual_sale;
    private String most_profitable_item_for_the_whole_year;
    private String most_profitable_category_for_the_whole_year;
    private String least_profitable_item_for_the_whole_year;
    private String least_profitable_category_for_the_whole_year;
    private String most_profitable_item_for_a_single_sale;
    private String best_selling_item_for_the_whole_year;
    private String[] most_profitable_store_for_each_month;
    public StoreQuery(String [][][] a,String [][] b){
        annual_sale = new AnnualSale(a,b);
        ItemProfits item_profits = new ItemProfits(annual_sale);
        CategoryProfits category_profits = new CategoryProfits(annual_sale);
        StoreProfits store_profits = new StoreProfits(annual_sale);
        most_profitable_item_for_the_whole_year = item_profits.most_item;
        least_profitable_item_for_the_whole_year = item_profits.least_item;
        most_profitable_category_for_the_whole_year = category_profits.most_profitable_category;
        least_profitable_category_for_the_whole_year = category_profits.least_profitable_category;
        most_profitable_item_for_a_single_sale = item_profits.most_single_sale;
        best_selling_item_for_the_whole_year = item_profits.best_selling_item;
        most_profitable_store_for_each_month = store_profits.best_stores_month_by_month;
        PrintOnScreen();
    }
    private void PrintOnScreen(){
        String[] months = {"January","February","March","April","May","June","July",
                           "August","September","October","November","December"};
        System.out.println("Most profitable item for the whole year: "+most_profitable_item_for_the_whole_year);
        System.out.println("Most profitable category for the whole year: "+most_profitable_category_for_the_whole_year);
        System.out.println("Least profitable item for whole year: "+least_profitable_item_for_the_whole_year);
        System.out.println("Least profitable category for the whole year: "+least_profitable_category_for_the_whole_year);
        System.out.println("Most profitable item for a single sale: "+most_profitable_item_for_a_single_sale);
        System.out.println("Best-selling item for the whole year: "+best_selling_item_for_the_whole_year);
        for (int i=0;i<12;i++){
                System.out.println(months[i]+": Store "+most_profitable_store_for_each_month[i]);
        }
    }
 }

