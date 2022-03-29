package FileAccess;
//@author Ömer Genişoğlu 240201049
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class FileIO {
    private int count;
	public String[][] getItems() throws IOException{
        String items[][] = new String[32][3];
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("HW1_Items.csv")));
            for (int count=0;count<32;count++) {
                StringTokenizer st = new StringTokenizer(br.readLine(),",\n");
                String[] item = {st.nextToken(),st.nextToken(),st.nextToken()};
                items[count] = item;
            }
            br.close();
        }catch(FileNotFoundException exception) {
        	System.out.println("HW1_Items.csv file not found");
			System.exit(-1);
        }catch(IOException exception) {
            System.out.println(exception);
            System.exit(-1);
        }
        return items;
	}
    public String[][][] getTransactions() throws IOException{
        String[][][] transactions = new String[4][32][37];
        try {
            for (int i=0;i<4;i++) {
                count = i+1;
                String file = "HW1_Transactions_Store"+(count)+".csv";
                // Here we are making the error more proper.
                BufferedReader br = new BufferedReader(new FileReader(new File(file)));
                for (int j=0;j<32;j++){
                    int k=0;
                    StringTokenizer st = new StringTokenizer(br.readLine(),",");
                    while(st.hasMoreTokens()){
                        transactions[i][j][k] = st.nextToken();
                        k += 1;
                        }
                    }
                br.close();
            }
        }catch(FileNotFoundException exception) {
            System.out.println("HW1_Transactions_Store"+count+".csv file not found");
            System.exit(-1);
        }catch(IOException exception) {
            System.out.println(exception);
            System.exit(-1);
        }
        return transactions;
    }
}

