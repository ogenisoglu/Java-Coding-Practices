package ChainStore;
//@author Ömer Genişoğlu 240201049
public class Item {
	private String ID;
	private String name;
	private String category;
	public Item(String namee,String IDD,String categoryy){
		ID = IDD;
		name = namee;
		category = categoryy;
	}
	public String getID(){
		return ID;
	}
	public String getName(){
		return name;
	}
	public String getCategory(){
		return category;
	}
}
