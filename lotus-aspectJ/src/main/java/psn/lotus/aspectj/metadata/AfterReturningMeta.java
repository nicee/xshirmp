package psn.lotus.aspectj.metadata;

/**
 * @author: nicee
 * @since: 2015/12/24
 */
public interface AfterReturningMeta extends ValueAware, ArgNamesAware, PointCutAware {

    String getReturning();

}
