package psn.lotus.open.param.card;

import java.io.Serializable;

/**
 * 子商户信息
 *
 * @author: nicee
 * @since: 2016/1/25
 */
public class SubMerchant implements Serializable {

    private static final long serialVersionUID = -8210861282187796522L;

    private String appid;

    private String name;

    private Integer primary_category_id;

    private Integer secondary_category_id;

    private Long submit_time;

    private String result;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrimary_category_id() {
        return primary_category_id;
    }

    public void setPrimary_category_id(Integer primary_category_id) {
        this.primary_category_id = primary_category_id;
    }

    public Integer getSecondary_category_id() {
        return secondary_category_id;
    }

    public void setSecondary_category_id(Integer secondary_category_id) {
        this.secondary_category_id = secondary_category_id;
    }

    public Long getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(Long submit_time) {
        this.submit_time = submit_time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
