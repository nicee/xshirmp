package psn.lotus.core.io;

import java.io.File;
import java.io.IOException;

public interface FileResource extends WritableResource {

    /**
     * @return file type of resource.
     * @throws IOException if file is not found, will throw it.
     */
    File getFile() throws IOException;

    /**
     * @return File modification time stamp.
     */
    long getLastModified();

    /**
     * @return the name of file.
     */
    String getFilename();

}
