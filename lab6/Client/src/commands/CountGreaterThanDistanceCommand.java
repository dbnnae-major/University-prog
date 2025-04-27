package commands;

import client.Client;
import interfaces.Command;
import java.io.Serializable;

public class CountGreaterThanDistanceCommand implements Command, Serializable {
    private static final long serialVersionUID = 12L;
    private Float distance;
    private CommandData commandData;

    public CountGreaterThanDistanceCommand(CommandData commandData) {
        this.commandData = commandData;
    }

    @Override
    public void execute(Client client) {
        distance = commandData.getDistance();
        client.sendObjectToServer(distance);
        client.sendObjectToServer(new CountGreaterThanDistanceCommand(commandData));
    }
}
