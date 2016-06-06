package psn.lotus.clast3.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/3/26
 */
public class CPData {

    //pick source numbers
    private List<String> numbers = new ArrayList<String>();

    //source file path
    private final String filePath;

    public CPData(String filePath) {
        if(null == filePath || filePath.length() == 0) {
            throw new IllegalArgumentException("file path is invalid.");
        }
        this.filePath = filePath;
        initDatas();
    }

    public List<String> getNumbers() {
        return numbers;
    }

    private void initDatas() {
        try{
            File file = new File(filePath);
            if(!file.exists()) {
                throw new IllegalArgumentException("file path is invalid to get file.");
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                String[] strs = line.split("\t");
                //期号
                Integer qiHao = Integer.parseInt(strs[0].split("-")[1]);
                //96-120 最大连错9
                //0-23 最大连错10
                //24-95 最大连错12
                if(qiHao > 23 && qiHao < 96) {
                    numbers.add(strs[1]);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        int i = 0;
        Iterator<String> it = numbers.iterator();
        while(it.hasNext()) {
            if (i > 20) {
                System.out.println();
                i = 0;
            }
            System.out.print(it.next() + "\t");
            i++;
        }
    }

}
