package psn.lotus.server.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 凭据
 *
 * @author: nicee
 * @since: 2016/1/7
 */
public abstract class Credential implements Serializable {

    static final Logger logger = LoggerFactory.getLogger(Credential.class);

    private static final long serialVersionUID = 1775875872655592226L;

    /**
     * 检查凭据
     *
     * @param credential 凭据
     * @return
     */
    protected abstract boolean check(Credential credential);


}
