package psn.lotus.open.param.card;

/**
 * 资质审核结果
 *
 * @author: nicee
 * @since: 2016/1/25
 */
public enum AuditResult {
    /**
     * 审核通过
     */
    RESULT_PASS,
    /**
     * 审核驳回
     */
    RESULT_NOT_PASS,
    /**
     * 待审核
     */
    RESULT_CHECKING,
    /**
     * 无提审记录
     */
    RESULT_NOTHING_TO_CHECK;

    public static AuditResult getResult(String name) {
        for(AuditResult result : AuditResult.values()) {
            if(result.name().equals(name)) {
                return result;
            }
        }
        return null;
    }

}
