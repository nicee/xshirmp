package psn.lotus.open.param.card;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 母商户资质
 *
 * @author: nicee
 * @since: 2016/1/25
 */
public class AgentQualification implements Serializable {

    private static final long serialVersionUID = -6221299324752101629L;

    /**
     * 注册资本，单位'分'
     */
    private Long register_capital;

    /**
     * 营业执照扫件媒体ID
     */
    private String business_license_media_id;

    /**
     * 税务登记媒体ID
     */
    private String tax_registration_certificate_media_id;

    /**
     * 上季度纳税扫件媒体ID
     */
    private String last_quarter_tax_listing_media_id;

    public Long getRegister_capital() {
        return register_capital;
    }

    public void setRegister_capital(Long register_capital) {
        this.register_capital = register_capital;
    }

    public String getBusiness_license_media_id() {
        return business_license_media_id;
    }

    public void setBusiness_license_media_id(String business_license_media_id) {
        this.business_license_media_id = business_license_media_id;
    }

    public String getTax_registration_certificate_media_id() {
        return tax_registration_certificate_media_id;
    }

    public void setTax_registration_certificate_media_id(String tax_registration_certificate_media_id) {
        this.tax_registration_certificate_media_id = tax_registration_certificate_media_id;
    }

    public String getLast_quarter_tax_listing_media_id() {
        return last_quarter_tax_listing_media_id;
    }

    public void setLast_quarter_tax_listing_media_id(String last_quarter_tax_listing_media_id) {
        this.last_quarter_tax_listing_media_id = last_quarter_tax_listing_media_id;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
