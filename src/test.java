import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class test {
    public static void main(String[] argv)
    {
        WordsList list = new WordsList();
        try {
            list.setFile(new FileInputStream("t.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Word> selected = list.getList("abs");
        for (Word w : selected) {
            System.out.println("en:"+w.getEnglish()+"  ch:"+w.getChinese());
        }
    }
}
