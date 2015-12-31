package psn.lotus.aspectj;

/**
 * @author: nicee
 * @since: 2015/12/24
 */
public interface AspectFactory extends Aspect {

    boolean isAspect(Class<?> clazz);
    
}
