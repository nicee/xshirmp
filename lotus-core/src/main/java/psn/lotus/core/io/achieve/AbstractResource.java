package psn.lotus.core.io.achieve;

import psn.lotus.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * @author nicee
 * @since 2015/09/15
 */
public abstract class AbstractResource implements Resource {

    /*
     * (non-Javadoc)
     *
     * @see psn.lotus.core.io.Resource#exists()
     */
    @Override
    public boolean exists() {
        return false;
    }

    /* (non-Javadoc)
     * @see psn.lotus.core.io.StreamResource#isOpen()
     */
    @Override
    public boolean isOpen() {
        return false;
    }

	/*
	 * @Override public InputStream getInputStream() throws IOException { throw
	 * new IOException("The input stream of resource is null."); }
	 */

    @Override
    public boolean isReadable() {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see psn.lotus.core.io.Resource#getUri()
     */
    @Override
    public URI getUri() throws IOException {
        throw new IOException("The uri of resource is not exist.");
    }

    /*
     * (non-Javadoc)
     *
     * @see psn.lotus.core.io.Resource#getPath()
     */
    @Override
    public String getPath() {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see psn.lotus.core.io.Resource#getName()
     */
    @Override
    public String getName() {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see psn.lotus.core.io.StreamResource#streamSize()
     */
    @Override
    public long streamSize() throws IOException {
        InputStream stream = getInputStream();
        try {
            byte[] buffer = new byte[1024];
            long size = 0l;
            int read = 0;
            while ((read = stream.read(buffer)) != -1) {
                size += read;
            }
            return size;
        } finally {
            stream.close();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        return (obj == this)
                || ((obj instanceof Resource) && ((Resource) obj)
                .getDescriptor().equals(this.getDescriptor()));
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return getDescriptor().hashCode();
    }

}
