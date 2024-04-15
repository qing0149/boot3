package design_patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 对数据库进行备份
 * @Date 2024/3/26 16:55
 */
public class DumpCommand implements Command {
    List<ApplicationServer> instanceList = new ArrayList<>();

    public DumpCommand(ApplicationServer app) {
        instanceList.add(app);
    }

    public DumpCommand(List<ApplicationServer> instanceList) {
        this.instanceList = instanceList;
    }

    @Override
    public void execute() {
        System.out.println("=============对数据库进行备份开始=================");
        for (ApplicationServer server : instanceList) {
            System.out.println("[" + server.getIp() + "]正在进行DuMP");
            server.dump();
        }
        System.out.println("==============备份结束================");
    }
}
