package psn.lotus.cp;

import psn.lotus.cp.data2.DataSource2;
import psn.lotus.cp.data2.PayTest;

import java.io.File;

/**
 * @author: nicee
 * @since: 2016/3/2
 */
public class Main2 {

    public static void main(String[] args) {
        File file = new File("F:\\nn.txt");

        if(!file.exists()) {
            System.out.println("文件不存在...");
        }

        DataSource2 dataSource2 = new DataSource2(file);

        PayTest payTest = new PayTest(dataSource2);
        payTest.pay();
    }

}
