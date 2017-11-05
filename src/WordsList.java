import java.io.*;
import java.util.ArrayList;

public class WordsList {
    private ArrayList<String> load;

    public void setFile(File csvFile) {
        if (load != null) {
            load.clear();
        } else {
            load = new ArrayList<>();
        }
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while(bufferedReader.read()!='#');
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                load.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFile(InputStream csvInputStream) {
        if (load != null) {
            load.clear();
        } else {
            load = new ArrayList<>();
        }
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(csvInputStream));
            while(bufferedReader.read()!='#');
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                load.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Word> getList(String filter) {
        ArrayList<Word> list = new ArrayList<>();
        for(int i = 0;i<load.size();i++) {
            String resource = load.get(i);
            String english = resource.substring(0,resource.indexOf(','));
            String chinese = resource.substring(resource.indexOf(',')+1);

            int englishLength = english.length();
            int filterLength = filter.length();
            if (englishLength >= filterLength && english.substring(0,filterLength).equals(filter)) {
                list.add(new Word(english,chinese));
            }
        }
        return list;
    }
}

class Word {
    private String english;
    private String chinese;

    public Word(String english, String chinese) {
        this.english = english;
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public String getChinese() {
        return chinese;
    }

}
