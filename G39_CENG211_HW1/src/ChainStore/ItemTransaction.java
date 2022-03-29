package ChainStore;
//@author Ömer Genişoğlu 240201049
public class ItemTransaction {
	public Item item;
	public Transaction[][] transactions = new Transaction[4][12];
	private String IDD;
	private String a[][][];
	private String b[][];
	public ItemTransaction(String[][][] transactions,String[][] items, String ID){
		this.b = items;
		this.a = transactions;
		IDD = ""+(Integer.parseInt(ID)+1);
		item();
		transaction();
	}
	private void item() {		//Collecting data of the item
		for (String i[]: b){
			if (i[1].equals(IDD)){
				item = new Item(i[0],i[1],i[2]);
				break;
			}
		}
	}
	private void transaction(){	//Collecting transaction data of selected item
		int store = 0;
		while (store<4){
			for (String j[]: a[store])
				if (j[0].equals(IDD)) {
					int count = 1;
					int month = 0;
					while (month<12){
						transactions[store][month] = new Transaction(j[count],j[count+1],j[count+2]);
						month += 1;
						count += 3;
					}
					break;
				}
			store++;
		}
	}
}