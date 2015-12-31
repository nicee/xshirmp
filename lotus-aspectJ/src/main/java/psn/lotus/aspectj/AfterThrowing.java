package psn.lotus.aspectj;

/**
 * @author: nicee
 * @since: 2015/12/24
 */
public interface AfterThrowing extends ValueAware, PointCutAware {

    String getThrows();
    
}
