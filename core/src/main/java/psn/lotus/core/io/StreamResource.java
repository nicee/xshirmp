package psn.lotus.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author nicee
 * @since 2015/09/15
 */
public interface StreamResource {

    /**
     * @return The input stream of resources
     * @throws IOException if stream of resource is null, will throw it.
     */
    InputStream getInputStream() throws IOException;

    /**
     * @return the size of input stream
     * @throws IOException when calculate the input stream data size should occur
     *                     IOException, the stream is null.
     */
    long streamSize() throws IOException;

    /**
     * @return whether the stream is opening.
     */
    boolean isOpen();

    /**
     * @return Whether the stream resource is readable.
     */
    boolean isReadable();

}
