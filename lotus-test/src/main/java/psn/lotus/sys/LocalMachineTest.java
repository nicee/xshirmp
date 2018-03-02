package psn.lotus.sys;

import org.junit.Test;

import java.net.InetAddress;

/**
 * @project lotus
 * @time 2016/10/27 9:11
 */
public class LocalMachineTest {

    @Test
    public void test() throws Exception {
        InetAddress[] inetAdds = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
        for (int i = 0; i < inetAdds.length; i++) {
            System.out.print(inetAdds[i].getHostName() + ":\t");
            System.out.println(inetAdds[i].getHostAddress());
        }

        System.out.println(new String("\u4e2d\u56fd \u676d\u5dde"));
    }

}
