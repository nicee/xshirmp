package psn.lotus.aspectj.achieve;

import org.aspectj.lang.annotation.*;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: nicee
 * @since: 2015/12/24
 */
public class AspectJAnnotation<A extends Annotation> {

    private static final Map<Class, AspectJAnnotationType> annotationMap = new HashMap<Class, AspectJAnnotationType>();

    static {
        annotationMap.put(AdviceName.class, AspectJAnnotationType.ADVICE_J_ANNOTATION_TYPE);
        annotationMap.put(After.class, AspectJAnnotationType.AFTER_J_ANNOTATION_TYPE);
        annotationMap.put(AfterReturning.class, AspectJAnnotationType.AFTER_RETURNING_J_ANNOTATION_TYPE);
        annotationMap.put(AfterThrowing.class, AspectJAnnotationType.AFTER_THROWING_J_ANNOTATION_TYPE);
        annotationMap.put(Around.class, AspectJAnnotationType.AROUND_J_ANNOTATION_TYPE);
        annotationMap.put(Aspect.class, AspectJAnnotationType.ASPECT_J_ANNOTATION_TYPE);
        annotationMap.put(Before.class, AspectJAnnotationType.BEFORE_J_ANNOTATION_TYPE);
        annotationMap.put(Pointcut.class, AspectJAnnotationType.POINTCUT_J_ANNOTATION_TYPE);
    }

    private enum AspectJAnnotationType {
        ADVICE_J_ANNOTATION_TYPE,
        AFTER_J_ANNOTATION_TYPE,
        AFTER_RETURNING_J_ANNOTATION_TYPE,
        AFTER_THROWING_J_ANNOTATION_TYPE,
        AROUND_J_ANNOTATION_TYPE,
        ASPECT_J_ANNOTATION_TYPE,
        BEFORE_J_ANNOTATION_TYPE,
        POINTCUT_J_ANNOTATION_TYPE
    }

}
