package design_patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2024/3/26 17:08
 */
public class ManagerServer {
    List<Command> commandList = new ArrayList<>();
    public void addCommand(Command command) {
        commandList.add(command);
    }
    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
    }

}
