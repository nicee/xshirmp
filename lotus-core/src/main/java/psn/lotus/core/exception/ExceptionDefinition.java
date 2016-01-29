package psn.lotus.core.exception;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import psn.lotus.core.io.Resource;
import psn.lotus.core.io.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

/**
 * @author: nicee
 * @since: 2015/12/15
 */
public class ExceptionDefinition {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionDefinition.class);

    private static final String SYSTEM_FATAL_ERROR_MESSAGE_PATTER = "SYSTEM ERROR: loading error message of [code=%s] fail";

    private static final String CANNOT_FOUND_ERROR_CODE_MESSSAGE_PATTER = "RESOURCE ERROR: undefined error message of [code=%s]";

    private final Properties exceptionProperties = new Properties();

    private List<String> resourcePattern;

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    public ExceptionDefinition() {
    }

    public void setResourcePattern(List<String> resourcePattern) {
        this.resourcePattern = resourcePattern;
    }

    public String getExceptionMessage(String errorCode) {
        String message = null;
        try {
            message = (String) getDefinitions().get(errorCode);
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error(SYSTEM_FATAL_ERROR_MESSAGE_PATTER, errorCode);
            }
        }
        if (StringUtils.isEmpty(message)) {
            message = String.format(CANNOT_FOUND_ERROR_CODE_MESSSAGE_PATTER, errorCode);
        }
        return message;
    }

    private Properties getDefinitions() throws IOException {
        if (exceptionProperties.isEmpty()) {
            internalLoad();
        }
        return exceptionProperties;
    }

    private void internalLoad() throws IOException {
        if (!CollectionUtils.isEmpty(resourcePattern)) {
            for (String path : resourcePattern) {
                internalLoadResource(resourcePatternResolver.getResources(path));
            }
        }
    }

    private void internalLoadResource(Resource[] resources) throws IOException {
        if (ArrayUtils.isNotEmpty(resources)) {
            for (Resource resource : resources) {
                internalLoadErrorResource(resource.getInputStream());
            }
        }
    }

    private void internalLoadErrorResource(InputStream inputStream) throws IOException {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            exceptionProperties.load(inputStreamReader);
            inputStreamReader.close();
        } finally {
            inputStream.close();
        }
    }

}
