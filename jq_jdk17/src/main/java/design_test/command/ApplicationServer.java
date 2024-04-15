package design_test.command;

/**
 * @Description
 * @Date 2024/3/27 19:54
 */
public class ApplicationServer {
    private String ip;

    public ApplicationServer(String ip) {
        this.ip = ip;
    }

    public void dump() {
        System.out.println(ip + "备份数据库");
    }

    public void syncTime() {
        System.out.println(ip + "进行时间的校准");
    }

    public void shutdown() {
        System.out.println(ip + "对应服务器关机");
    }


}
