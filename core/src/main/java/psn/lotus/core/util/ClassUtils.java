package psn.lotus.core.util;

public abstract class ClassUtils {

	// 获取默认的类加载
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader loader = null;

		try {
			// 获取当前线程的上下文加载器
			loader = Thread.currentThread().getContextClassLoader();
		} catch (Throwable ex) {

		}

		if (loader == null) {
			// 获取自身的类加载器
			loader = ClassUtils.class.getClassLoader();
			if (loader == null) {
				try {
					// 获取系统默认类加载器
					loader = ClassLoader.getSystemClassLoader();
				} catch (Throwable ex) {

				}
			}
		}

		return loader;
	}

	// 获取类的包路径
	public static String classPackageAsResourcePath(Class<?> clazz) {
		if (clazz == null)
			return "";

		String clazzName = clazz.getName();
		int packageEndIndex = clazzName.lastIndexOf('.');
		if (packageEndIndex == -1) {
			return "";
		}
		String packageName = clazzName.substring(0, packageEndIndex);
		return packageName.replace('.', '/');
	}

	public static void main(String[] args) {
		System.out.println(ClassUtils
				.classPackageAsResourcePath(ClassUtils.class));
	}

}
