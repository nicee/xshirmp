package psn.lotus.cp.context;

import org.springframework.util.Assert;

import java.io.*;

/**
 * @author xjl
 * @project lotus
 * @time 2016/8/4 17:47
 */
public class FragmentConfigureImpl implements FragmentConfigure {

    private String configPath;

    public FragmentConfigureImpl(String configPath) {
        this.configPath = configPath;
    }

    public InputStream getInputStream() throws IOException {
        Assert.notNull(this.configPath, "The configure path could not be empty.");
        File file = new File(configPath);
        if (!file.exists()) {
            throw new IllegalArgumentException("The configure file was not found.");
        }
        return new FileInputStream(file);
    }

}
