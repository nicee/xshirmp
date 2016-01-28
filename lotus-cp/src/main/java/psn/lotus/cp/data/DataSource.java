package psn.lotus.cp.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/1/28
 */
public class DataSource {

    private List<String> datas = new ArrayList<String>();

    public DataSource(File file) {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("Please don't choose directory path.");
        }
        resolveData(file);
    }

    public List<String> getDatas() {
        return datas;
    }

    private void resolveData(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                datas.add(line.split(" ")[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
