package psn.lotus.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nicee
 * @since 2015/9/15
 */
public abstract class StringUtils {

	private static final String FOLDER_SEPARATOR = "/";

	private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

	private static final String TOP_PATH = "..";

	private static final String CURRENT_PATH = ".";

	private static final char EXTENSION_SEPARATOR = '.';

	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}

	public static boolean hasLength(CharSequence charSequence) {
		return (charSequence != null && charSequence.length() > 0);
	}

	public static boolean hasText(String str) {
		return hasText((CharSequence) str);
	}

	public static boolean hasText(CharSequence charSequence) {
		if (!hasLength(charSequence)) {
			return false;
		}

		int len = charSequence.length(), i = 0;
		do {
			if (!Character.isWhitespace(charSequence.charAt(i))) {
				return true;
			}
		} while (i < len);

		return false;
	}

	public static String[] toStringArray(Collection<String> collection) {
		return (collection == null) ? null : collection
				.toArray(new String[collection.size()]);
	}

	public static String convertToUnixPath(String path) {
		if (path == null)
			return null;

		String unixPath = replace(path, WINDOWS_FOLDER_SEPARATOR,
				FOLDER_SEPARATOR);

		String prefix = "";
		int prefixIndex = path.indexOf(":");
		if (prefixIndex != -1) {
			prefix = unixPath.substring(0, prefixIndex);
			if (prefix.contains("/")) {
				prefix = "";
			} else {
				unixPath = unixPath.substring(prefixIndex + 1);
			}
		}

		if (unixPath.startsWith(FOLDER_SEPARATOR)) {
			prefix += FOLDER_SEPARATOR;
			unixPath = unixPath.substring(1);
		}

		String[] pathArray = delimitedListToStringArray(unixPath,
				FOLDER_SEPARATOR);
		List<String> pathElements = new LinkedList<String>();
		int tops = 0;

		for (int i = pathArray.length - 1; i >= 0; i--) {
			String element = pathArray[i];
			if (CURRENT_PATH.equals(element)) {

			} else if (TOP_PATH.equals(element)) {
				tops++;
			} else {
				if (tops > 0) {
					tops--;
				} else {
					pathElements.add(0, element);
				}
			}
		}

		for (int i = 0; i < tops; i++) {
			pathElements.add(0, TOP_PATH);
		}

		return prefix
				+ collectionToDelimitedString(pathElements, FOLDER_SEPARATOR);
	}

	// 对字符串进行表达式匹配
	public static String replace(String str, String oldPattern, String newPatter) {
		if (!hasLength(str) || !hasLength(oldPattern) || newPatter == null) {
			return str;
		}

		StringBuilder builder = new StringBuilder();

		int pos = 0;
		int patternLen = oldPattern.length();
		int index = str.indexOf(oldPattern);

		while (index >= 0) {
			builder.append(str.substring(pos, index));
			builder.append(newPatter);
			pos = index + patternLen;
			index = str.indexOf(oldPattern, pos);
		}
		builder.append(str.substring(pos));

		return builder.toString();
	}

	// 将字符串按某个分隔符分割为字符串数组
	public static String[] delimitedListToStringArray(String str,
			String delimiter) {
		return delimitedListToStringArray(str, delimiter, null);
	}

	public static String[] delimitedListToStringArray(String str,
			String delimiter, String charsToDelete) {
		if (str == null) {
			return new String[0];
		}
		if (delimiter == null) {
			return new String[] { str };
		}
		List<String> result = new ArrayList<String>();
		if ("".equals(delimiter)) {
			int i = 0, len = str.length();
			while (i < len) {
				result.add(deleteAny(str.substring(i, i + 1), charsToDelete));
				i++;
			}
		} else {
			int pos = 0;
			int delPos;
			int delLen = delimiter.length();
			while ((delPos = str.indexOf(delimiter, pos)) != -1) {
				result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
				pos = delPos + delLen;
			}
			if (str.length() > 0 && pos <= str.length()) {
				result.add(deleteAny(str.substring(pos), charsToDelete));
			}
		}
		return toStringArray(result);
	}

	// 将字符串数组拼装成包含限定符的字符串
	public static String collectionToDelimitedString(Collection<?> collection,
			String delimiter) {
		return collectionToDelimitedString(collection, delimiter, "", "");
	}

	public static String collectionToDelimitedString(Collection<?> collection,
			String delimiter, String prefix, String suffix) {
		if (collection == null || collection.isEmpty()) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		Iterator<?> it = collection.iterator();
		boolean hasNext = it.hasNext();
		while (hasNext) {
			builder.append(prefix).append(it.next()).append(suffix);
			if (hasNext = it.hasNext()) {
				builder.append(delimiter);
			}
		}
		return builder.toString();
	}

	// 删除字符串含有待删除字符串的任意字符
	public static String deleteAny(String str, String charsToDelete) {
		if (!hasLength(str) || !hasLength(charsToDelete)) {
			return str;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0, len = str.length(); i < len; i++) {
			char c = str.charAt(i);
			if (charsToDelete.indexOf(c) == -1) {
				builder.append(c);
			}
		}
		return builder.toString();
	}

	// 获取路径中的文件名称
	public static String getFilename(String path) {
		if (path == null) {
			return null;
		}
		int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
		return (separatorIndex != -1) ? path.substring(separatorIndex + 1)
				: path;
	}

	// 根据路径获取文件拓展后缀
	public static String getFilenameExtension(String path) {
		if (path == null) {
			return null;
		}
		int extIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
		if (extIndex == -1) {
			return null;
		}
		int folderIndex = path.lastIndexOf(FOLDER_SEPARATOR);
		if (folderIndex > extIndex) {
			return null;
		}
		return path.substring(extIndex + 1);
	}

}
