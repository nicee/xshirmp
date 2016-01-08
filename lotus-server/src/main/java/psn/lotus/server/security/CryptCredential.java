package psn.lotus.server.security;

/**
 * UNIX加密凭据，加密算法可以是
 *
 * @author: nicee
 * @since: 2016/1/7
 */
//TODO 后续完善
public class CryptCredential extends Credential {

    private static final long serialVersionUID = 4433704141966151541L;

    @Override
    protected boolean check(Credential credential) {
        return false;
    }

}
