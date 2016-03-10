package psn.lotus.cp.data3;


import psn.lotus.cp.data2.DataSource2;

import java.io.File;

/**
 * @author: nicee
 * @since: 2016/3/3
 */
public class Main3 {

    public static void main(String[] args) {
        File file = new File("F:\\nn.txt");

        if (!file.exists()) {
            System.out.println("文件不存在...");
        }

        DataSource2 dataSource2 = new DataSource2(file);

        PayTest payTest = new PayTest(dataSource2);
        payTest.pay();
    }

}
