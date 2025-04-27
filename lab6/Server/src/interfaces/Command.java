package interfaces;

import server.Server;

/**
 * Интерфейс, который используют все команды, чтобы иметь определенный шаблон.
 */
public interface Command {
    void execute();
}
