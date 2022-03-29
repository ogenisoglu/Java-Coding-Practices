package StoreQuery;
import ChainStore.*;
//@author Ömer Genişoğlu 240201049
public class CategoryProfits {
    String [] categories = new String[32];
    double[] category = new double[5];
    String[] categoryy = {"Beverage","Food","Snack","Home","Personal"};
    public String most_profitable_category;
    public String least_profitable_category;
    public CategoryProfits(AnnualSale annual_sale){
        addItemsWithCategories(annual_sale);
        findMostAndLeast();
    }
    private void addItemsWithCategories(AnnualSale as) {
        for (int i=0;i<32;i++){
            for (int j=0;j<4;j++){
                for (int k=0;k<12;k++){
                    switch(as.item_transactions[i].item.getCategory()){
                        case "Beverage": category[0] += calculate(as.item_transactions[i].transactions,j,k) ;break;
                        case "Food": category[1] += calculate(as.item_transactions[i].transactions,j,k);break;
                        case "Snack": category[2] += calculate(as.item_transactions[i].transactions,j,k);break;
                        case "Home": category[3] += calculate(as.item_transactions[i].transactions,j,k);break;
                        case "Personal": category[4] += calculate(as.item_transactions[i].transactions,j,k);break;
                    }
                }// At this point, we are calculating all sales data for every category.   
            }
        }
    }
    private double calculate(Transaction[][] x,int i,int j){
        return x[i][j].getNumberOfSales()*(x[i][j].getSalePrice()-x[i][j].getPurchasePrice());
    }			// This method makes method which is on top shorter and calculates sale number*(sales-purchase).
    private void findMostAndLeast(){
        double max = category[0];
        double min = category[1];
        for (int i =0;i<5;i++){//Here we are searching for maximum and minimum profitable category.
            if (category[i]>max){max = category[i];most_profitable_category = categoryy[i];}
            else if(category[i]<min){min = category[i];least_profitable_category = categoryy[i];}
        }
    }
}

