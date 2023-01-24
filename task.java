import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task {
    public static void main(String[] args) {
        int i = 0;
        while (i < args.length) {
            try {
                File myObj = new File(args[i]);
                Scanner myReader = new Scanner(myObj);
                String fileName = args[i].substring(11);

                String data = myReader.nextLine();
                if (i == 0) {
                    System.out.println(data + ",filename");
                }
                
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    System.out.println(data + "," + fileName);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                // String fileName = args[i].substring(12);
                System.out.println("No file found with that name: " + args[i]);
            }
            i++;
        }
    }
}