package psn.lotus.worm;

/**
 * @project lotus
 * @time 2016/10/27 14:44
 */
public class DefaultFrontCrawler extends AbstractFrontCrawler {

    private boolean autoExecute = false;

    public DefaultFrontCrawler(String url) {
        super(url);
    }

    public boolean isAutoExecute() {
        return autoExecute;
    }

    public void setAutoExecute(boolean autoExecute) {
        this.autoExecute = autoExecute;
    }

}
