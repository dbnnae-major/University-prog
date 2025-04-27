package interfaces;

import collectionCommands.CommandData;

/**
 * Интерфейс, который используют все команды, чтобы иметь определенный шаблон.
 */
public interface Command {
    void execute(CommandData commandData);
}
