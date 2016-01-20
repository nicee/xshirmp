package psn.lotus.datasource;

import org.springframework.util.Assert;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;

/**
 * @author: nicee
 * @since: 2016/1/18
 */
public class DriverManagerDataSource extends AbstractDataSource {

    private String url;
    private String username;
    private String password;

    public DriverManagerDataSource() {

    }

    public DriverManagerDataSource(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getUrl() {
        Assert.hasText(url, "Url could not be empty.");
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Assert.hasText(username, "Username could not be empty.");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Assert.hasText(password, "Password could not be empty.");
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return getConnection(username, password);
    }

    public Connection getConnection(String username, String password) throws SQLException {
        return getConnection(username, password);
    }

    @Override
    protected Connection getConnectionOnPropreties(Properties properties) throws SQLFeatureNotSupportedException {
        return null;
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

}
