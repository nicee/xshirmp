package psn.lotus.core.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author nicee
 * @since 2015/9/15
 */
public interface WritableResource extends Resource {

    /**
     * @return whether the resource could writable.
     */
    boolean isWritable();

    /**
     * @return write its content to target.
     * @throws IOException if stream of output is null, will occur it.
     */
    OutputStream getOutputStream() throws IOException;

}
