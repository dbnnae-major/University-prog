package collectionCommands;

import client.Client;
import interfaces.Command;
import java.io.Serializable;

public class CountGreaterThanDistanceCommand implements Command, Serializable {
    private static final long serialVersionUID = 12L;
    private Float distance;

    public CountGreaterThanDistanceCommand(Float distance) {
        this.distance = distance;
    }

    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new CountGreaterThanDistanceCommand(distance));
    }
}
