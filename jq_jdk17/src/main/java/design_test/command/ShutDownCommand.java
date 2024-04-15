package design_test.command;

import java.util.List;

/**
 * @Description
 * @Date 2024/3/27 20:07
 */
public class ShutDownCommand implements Command {
    List<ApplicationServer> applicationServerList;

    public ShutDownCommand(List<ApplicationServer> applicationServerList) {
        this.applicationServerList = applicationServerList;
    }

    @Override
    public void execute() {
        for (ApplicationServer applicationServer : applicationServerList) {
            applicationServer.shutdown();
        }
    }
}
