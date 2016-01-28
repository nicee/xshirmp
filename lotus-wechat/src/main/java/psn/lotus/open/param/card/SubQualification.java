package psn.lotus.open.param.card;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 子商户资质
 *
 * @author: nicee
 * @since: 2016/1/25
 */
public class SubQualification implements Serializable {

    private static final long serialVersionUID = 485577810026335866L;

    /**
     * 子商户APPID
     */
    private String appid;

    /**
     * 子商户名称
     */
    private String name;

    /**
     * logo媒体ID
     */
    private String logo_media_id;

    /**
     * 营业执照或个体工商户执照扫描件的media_id
     */
    private String business_license_media_id;

    /**
     * 子商户与第三方签署的授权函的media_id
     */
    private String agreement_file_media_id;

    /**
     * 提交该个体工商户经营者身份证扫描件的media_id
     * 必填：否
     */
    private String operator_id_card_media_id;

    /**
     * 一级类目id
     */
    private Integer primary_category_id;

    /**
     * 二级类目id
     */
    private Integer secondary_category_id;

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

    public String getLogo_media_id() {
        return logo_media_id;
    }

    public void setLogo_media_id(String logo_media_id) {
        this.logo_media_id = logo_media_id;
    }

    public String getBusiness_license_media_id() {
        return business_license_media_id;
    }

    public void setBusiness_license_media_id(String business_license_media_id) {
        this.business_license_media_id = business_license_media_id;
    }

    public String getAgreement_file_media_id() {
        return agreement_file_media_id;
    }

    public void setAgreement_file_media_id(String agreement_file_media_id) {
        this.agreement_file_media_id = agreement_file_media_id;
    }

    public String getOperator_id_card_media_id() {
        return operator_id_card_media_id;
    }

    public void setOperator_id_card_media_id(String operator_id_card_media_id) {
        this.operator_id_card_media_id = operator_id_card_media_id;
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

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
