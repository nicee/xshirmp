package psn.lotus.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psn.lotus.core.context.ApplicationContextHelper;

/**
 * @author: nicee
 * @since: 2015/12/17
 */
public class ExceptionFactory {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionFactory.class);

    private static ExceptionDefinition exceptionDefinition;

    private ExceptionFactory() {

    }

    public static Exception create(String errorCode, String... args) {
        String errorMessage = getExceptionDefinition().getExceptionMessage(errorCode);
        if (args.length > 0) {
            errorMessage = String.format(errorMessage, args);
        }
        return new UnknownException(errorCode, errorMessage);
    }

    private static ExceptionDefinition getExceptionDefinition() {
        if (null == exceptionDefinition) {
            exceptionDefinition = ApplicationContextHelper.getContext().getBean(ExceptionDefinition.class);
        }
        return exceptionDefinition;
    }

}
