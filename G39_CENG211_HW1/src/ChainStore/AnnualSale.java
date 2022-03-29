package ChainStore;
//@author Ömer Genişoğlu 240201049
public class AnnualSale {
    public ItemTransaction[] item_transactions = new ItemTransaction[32];
    public AnnualSale(String[][][] a,String[][] b){
        for (int i=0;i<32;i++){ // We are creating ItemTransaction objects for each item.
            item_transactions[i]= new ItemTransaction(a,b,Integer.toString(i));
        }
    }
}
