package psn.lotus.core.io.achieve;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import psn.lotus.core.io.FileResource;
import psn.lotus.core.util.AssertUtils;

/**
 * @author nicee
 * @since 2015/9/15
 */
public class FileSystemResource extends AbstractResource implements
		FileResource {

	/**
	 * file resources
	 */
	private final File file;

	/**
	 * path of file
	 */
	private final String path;

	/**
	 * @param file
	 *            file resource
	 */
	public FileSystemResource(File file) {
		AssertUtils.notNull(file, "The file must not be null.");
		this.file = file;
		this.path = file.getPath();
	}

	/**
	 * @param path
	 *            path of file
	 */
	public FileSystemResource(String path) {
		AssertUtils.notNull(path, "The path must not be null.");
		this.file = new File(path);
		this.path = path;
	}

	// ---------------------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.AbstractResource#exists()
	 */
	@Override
	public boolean exists() {
		return file.exists();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.Resource#getDescriptor()
	 */
	@Override
	public String getDescriptor() {
		return "File absolute path : [" + file.getAbsolutePath() + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.AbstractResource#getUri()
	 */
	@Override
	public URI getUri() throws IOException {
		return file.toURI();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.AbstractResource#getPath()
	 */
	@Override
	public String getPath() {
		return this.path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.AbstractResource#getName()
	 */
	@Override
	public String getName() {
		return file.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.StreamResource#getInputStream()
	 */
	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.AbstractResource#streamSize()
	 */
	@Override
	public long streamSize() throws IOException {
		return file.length();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.AbstractResource#isReadable()
	 */
	@Override
	public boolean isReadable() {
		return file.canRead() && !file.isDirectory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.WritableResource#isWritable()
	 */
	@Override
	public boolean isWritable() {
		return file.canWrite() && !file.isDirectory();
	}

	/**
	 * @return
	 * @throws IOException
	 */
	@Override
	public OutputStream getOutputStream() throws IOException {
		return new FileOutputStream(file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.FileResource#getFile()
	 */
	@Override
	public File getFile() {
		return file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.FileResource#getLastModified()
	 */
	@Override
	public long getLastModified() {
		return this.file.lastModified();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see psn.lotus.core.io.FileResource#getFilename()
	 */
	@Override
	public String getFilename() {
		return file.getName();
	}

	// ------------------------------------------------------

	@Override
	public boolean equals(Object obj) {
		return (obj == this)
				|| (obj instanceof FileSystemResource && ((FileSystemResource) obj).path
						.equals(this.path));
	}

	@Override
	public int hashCode() {
		return this.path.hashCode();
	}

}
