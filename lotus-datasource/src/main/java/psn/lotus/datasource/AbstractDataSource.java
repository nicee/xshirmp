package psn.lotus.datasource;

import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
public abstract class AbstractDataSource implements DataSource {

    /**
     * 数据库配置属性
     */
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface.isInstance(this)) {
            return (T) this;
        }
        throw new SQLException("Datasource of type [" + getClass().getName() + "] cannot be unwrapped as [" + iface.getName() + "]");
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return iface.isInstance(this);
    }

    protected abstract Connection getConnectionOnPropreties(Properties properties) throws SQLFeatureNotSupportedException;

}
