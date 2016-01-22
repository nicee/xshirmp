package psn.lotus.wechat.param.meterial;

import psn.lotus.wechat.param.MaterialType;

import java.io.File;
import java.io.Serializable;

/**
 * 素材对象
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public class TempMaterialRequest implements Serializable {

    private static final long serialVersionUID = -4390728333344203379L;

    private MaterialType type;

    private File file;

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
