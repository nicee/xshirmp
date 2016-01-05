package psn.lotus.aspectj.metadata;

/**
 * @author: nicee
 * @since: 2015/12/24
 */
public interface AspectMetaFactory extends AspectMeta {

    boolean isAspect(Class<?> clazz);
    
}
