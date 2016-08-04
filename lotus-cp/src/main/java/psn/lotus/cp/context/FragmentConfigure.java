package psn.lotus.cp.context;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/4 17:46
 */
public interface FragmentConfigure {

    InputStream getInputStream() throws IOException;

}
