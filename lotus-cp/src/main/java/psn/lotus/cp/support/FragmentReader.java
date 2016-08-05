package psn.lotus.cp.support;

import org.apache.commons.io.IOUtils;
import psn.lotus.cp.pojo.Fragment;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/4 17:18
 */
public class FragmentReader {

    public static List<Fragment> read(InputStream inputStream) throws IOException {
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = IOUtils.toBufferedReader(reader);

        String line;
        List<Fragment> fragments = new ArrayList<Fragment>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] pieces = line.split("\t");
            Fragment fragment = create(pieces[0], pieces[1]);
            fragments.add(fragment);
        }

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("The fragment configure close failure...");
        }

        Collections.reverse(fragments);
        return fragments;
    }

    private static Fragment create(String serial, String number) {
        Fragment fragment = new Fragment();
        fragment.setSerial(serial);
        fragment.setSerialNo(Integer.parseInt(serial.split("-")[1]));
        fragment.setNumber(Integer.parseInt(number));
        int len = number.length();
        fragment.setTenNo(Integer.parseInt(number.substring(len - 2, len - 1)));
        fragment.setUnitNo(Integer.parseInt(number.substring(len - 1, len)));
        return fragment;
    }

}
