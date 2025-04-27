package interfaces;

import client.Client;

public interface Command {
    void execute(Client client);
}
