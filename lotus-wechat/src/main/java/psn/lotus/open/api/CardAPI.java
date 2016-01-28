package psn.lotus.open.api;

import com.alibaba.fastjson.JSONObject;
import psn.lotus.open.param.card.AgentQualification;
import psn.lotus.open.param.card.AuditResult;
import psn.lotus.open.param.card.SubMerchant;
import psn.lotus.open.param.card.SubQualification;

import java.io.File;

/**
 * 第三方制券功能
 *
 * @author: nicee
 * @since: 2016/1/25
 */
public interface CardAPI {

    /**
     * 申请子商户代理资质
     *
     * @param qualification 资质
     */
    void applyAgentQualification(AgentQualification qualification);


    /**
     * 根据access token获取对应母商户资质
     *
     * @return 审核结果
     */
    AuditResult getAuditResultOfAgent();

    /**
     * 提交子商户资质审核
     *
     * @param qualification 资质
     */
    void applySubQualification(SubQualification qualification);

    /**
     * 获取子商户资质审核结果
     *
     * @param subAppId 子商户APPID
     * @return 审核结果
     */
    AuditResult getAuditResultOfSub(String subAppId);

    /**
     * 上传图片
     *
     * @param file 图片文件
     * @return 图片media_id
     */
    String uploadImgIfRequire(File file);

    /**
     * 卡券开放类目查询
     *
     * @return 响应数据
     */
    JSONObject getApplyProtocol();

    /**
     * 获取对应appid子商户信息
     *
     * @param appid 子商户appid
     * @return 子商户信息
     */
    SubMerchant getSubMerchantDetail(String appid);

    /**
     * 获取所有子商户信息
     *
     * @param next 下一个子商户appid
     * @return 子商户数组
     */
    SubMerchant[] getSubMerchants(String next);

}
