package psn.lotus.rpc.api;

/**
 * @project lotus
 * @time 2017/4/20 13:17
 */
public interface Invocation {

    /**
     * get method name.
     *
     * @serial
     * @return method name.
     */
    String getMethodName();

    /**
     * get parameter types.
     *
     * @serial
     * @return parameter types.
     */
    Class<?>[] getParameterTypes();

    /**
     * get arguments.
     *
     * @serial
     * @return arguments.
     */
    Object[] getArguments();

}
