package psn.lotus.wechat.param.meterial;

import com.alibaba.fastjson.JSONObject;

import javax.validation.constraints.Max;
import java.io.Serializable;

/**
 * 查询素材
 *
 * @author: nicee
 * @since: 2016/1/20
 */
public class QueryMaterialsRequest implements Serializable {

    private static final long serialVersionUID = 3029462015923727192L;

    private String type;

    private Integer offset;

    @Max(value = 20)
    private Integer count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
