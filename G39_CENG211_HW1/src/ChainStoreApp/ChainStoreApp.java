package ChainStoreApp;
import ChainStore.StoreQuery;
import FileAccess.FileIO;
import java.io.IOException;
//@author Ömer Genişoğlu 240201049

public class ChainStoreApp {
	public static void main(String[] args) throws IOException {
		FileIO a = new FileIO();
		new StoreQuery(a.getTransactions(),a.getItems());
	}
}

