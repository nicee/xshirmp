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
        String tmp = System.getProperty("user.dir");
        File file = new File(tmp + "\\lotus-cp\\src\\main\\resource\\txt");

        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            throw new IllegalArgumentException("The path of '" + file.getName() + "' hasn't any files inside.");
        }

        /*for(File child : files) {
            System.out.println(child.getName());
            DataSource source = new DataSource(child);
            Pay pay = new Pay(source.getDatas());
            pay.pay();
        }*/

//        File target = files[files.length - 2];
//        System.out.println(target.getName());

        File target = new File("F:\\nn.txt");
        DataSource source = new DataSource(target);
        Pay pay = new Pay(source.getDatas());
        pay.pay();

        /*File all = new File("F:\\nn.txt");
        DataSource source = new DataSource(all);
        Pay pay = new Pay(source.getDatas());
        pay.pay();*/
    }

}
