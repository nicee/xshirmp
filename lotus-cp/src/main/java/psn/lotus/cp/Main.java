package psn.lotus.cp;

import psn.lotus.cp.data.DataSource;
import psn.lotus.cp.data.Pay;

import java.io.File;

/**
 * @author: nicee
 * @since: 2016/1/28
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("F:\\number");
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            throw new IllegalArgumentException("The path of '" + file.getName() + "' hasn't any files inside.");
        }

        DataSource source = new DataSource(files[9]);
        Pay pay = new Pay(source.getDatas());
        pay.payOne();

        /*for (File child : files) {
            System.out.println();
        }*/
    }

}
