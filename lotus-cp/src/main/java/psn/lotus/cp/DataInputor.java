package psn.lotus.cp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/1/11
 */
public class DataInputor {

    private String txt;

    private List<Integer> datas = new ArrayList<Integer>();

    public DataInputor(String txt) throws IOException {
        this.txt = txt;
        initData();
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public List<Integer> getDatas() {
        return datas;
    }

    private void initData() throws IOException {
        File file = new File(System.getProperty("user.dir") + txt);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tmp;
        while ((tmp = reader.readLine()) != null) {
            String[] dd = tmp.trim().split(" ");
            for(String d : dd) {
                datas.add(Integer.parseInt(d));
            }
        }
    }

}
