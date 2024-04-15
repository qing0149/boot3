package design_patterns.command;

import java.util.ArrayList;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 15:50
 **/
public class Client {
    public static void main(String[] args) {
        ArrayList<ApplicationServer> instanceList = new ArrayList<>();
        instanceList.add(new ApplicationServer("192.168.31.100"));
        instanceList.add(new ApplicationServer("192.168.31.101"));
        instanceList.add(new ApplicationServer("192.168.31.102"));
        instanceList.add(new ApplicationServer("192.168.31.103"));

   /*     for (ApplicationServer server : instanceList) {
            //进行时间的校准
            server.syncTime();
            //备份数据库
            server.dump();
            //对应服务器关机
            server.shutdown();
        }*/
        //命令行方式执行
        ManagerServer managerServer = new ManagerServer();
        managerServer.addCommand(new DumpCommand(instanceList));
        managerServer.addCommand(new SyncTimeCommand(instanceList));
        managerServer.execute();

    }

}
