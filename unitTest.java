import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class unitTest {
    static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    static ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    static PrintStream originalOut = System.out;
    static PrintStream originalErr = System.err;
    public static void main(String[] args) {
        System.setOut(new PrintStream(outContent));
        testFileNotFoundArgs();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        testCorrectOutput();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        test2CorrectOutputs();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        testEmptyArgs();
    }

    public static void testFileNotFoundArgs() {
        String[] arr = {"test"};
        task.main(arr);
        if(outContent.toString().equals("No file found with that name: test\n")){
            System.setOut(originalOut);
            System.out.println("This works");
        }
    }    

    public static void testCorrectOutput() {
        String[] arr = {"./fixtures/test1.csv"};
        task.main(arr);
        if(outContent.toString().equals("\"email_hash\",\"category\",filename\n\"1111\",\"Kitchen Cleaner\",test1.csv\n\"2222\",\"Bathroom Cleaner\",test1.csv\n")){
            System.setOut(originalOut);
            System.out.println("This works2");
        }
    }
    
    public static void test2CorrectOutputs() {
        String[] arr = {"./fixtures/test1.csv", "./fixtures/test2.csv"};
        task.main(arr);
        if(outContent.toString().equals("\"email_hash\",\"category\",filename\n\"1111\",\"Kitchen Cleaner\",test1.csv\n\"2222\",\"Bathroom Cleaner\",test1.csv\n\"1111\",\"Kitchen Cleaner\",test2.csv\n")){
            System.setOut(originalOut);
            System.out.println("This works3");
        }
    }

    public static void testEmptyArgs() {
        String[] arr = {};
        task.main(arr);
        if(outContent.toString().equals("")){
            System.setOut(originalOut);
            System.out.println("This works4");
        }
    }
}
