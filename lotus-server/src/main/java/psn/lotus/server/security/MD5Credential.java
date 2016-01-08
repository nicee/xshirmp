package psn.lotus.server.security;

/**
 * MD5凭据
 *
 * @author: nicee
 * @since: 2016/1/7
 */
public class MD5Credential extends Credential {

    private static final long serialVersionUID = 2935843257973096611L;

    @Override
    protected boolean check(Credential credential) {
        return false;
    }

}
