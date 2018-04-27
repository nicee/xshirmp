package psn.lotus.cloud.transport;

/**
 * 定义终端类型
 *
 * @project lotus
 * @time 2018/4/27 15:50
 */
public enum TerminalType {

    /**
     * 终端类型：服务端
     */
    SERVER("TRANSPORT SERVER"),
    /**
     * 终端类型：客户端
     */
    CLIENT("TRANSPORT CLIENT");

    private String name;

    TerminalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
