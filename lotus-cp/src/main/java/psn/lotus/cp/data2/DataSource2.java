package psn.lotus.cp.data2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: nicee
 * @since: 2016/3/2
 */
public class DataSource2 {

    private List<String> datas = new ArrayList<String>();

    public DataSource2(File file) {
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

    public List<String> getDatas() {
        return datas;
    }

}
