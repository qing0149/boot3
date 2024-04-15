package design_patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2024/3/26 17:04
 */
public class SyncTimeCommand implements Command {
    List<ApplicationServer> applicationServerList = new ArrayList<>();

    public SyncTimeCommand(List<ApplicationServer> applicationServerList) {
        this.applicationServerList = applicationServerList;
    }

    public SyncTimeCommand(ApplicationServer applicationServer) {
        this.applicationServerList.add(applicationServer);
    }

    @Override
    public void execute() {
        System.out.println("=============对数据库同步时间开始=================");
        for (ApplicationServer server : applicationServerList) {
            System.out.println("[" + server.getIp() + "]正在进行syncTime");
            server.syncTime();
        }
        System.out.println("==============对数据库同步时间结束================");
    }
}
