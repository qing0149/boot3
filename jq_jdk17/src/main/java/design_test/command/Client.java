package design_test.command;

import java.util.ArrayList;

/**
 * @Description
 * @Date 2024/3/27 20:07
 */

public class Client {
    public static void main(String[] args) {
        ArrayList<ApplicationServer> applicationServers = new ArrayList<>();
        applicationServers.add(new ApplicationServer("169.168.10.100"));
        applicationServers.add(new ApplicationServer("169.168.10.101"));
        applicationServers.add(new ApplicationServer("169.168.10.102"));
        applicationServers.add(new ApplicationServer("169.168.10.103"));
        DumpCommand dumpCommand = new DumpCommand(applicationServers);
        SyncTimeCommand syncTimeCommand = new SyncTimeCommand(applicationServers);
        ShutDownCommand shutDownCommand = new ShutDownCommand(applicationServers);
        dumpCommand.execute();
        syncTimeCommand.execute();
        shutDownCommand.execute();

    }
}
