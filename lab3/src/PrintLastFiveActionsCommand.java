import java.util.*;

public class PrintLastFiveActionsCommand implements Command{
    private Deque<Command> historyStack;
    public PrintLastFiveActionsCommand(Deque<Command> historyStack) {
        this.historyStack = historyStack;
    }

    @Override
    public void execute() {
        System.out.println("История последних вызовов:");
        if (!historyStack.isEmpty()) {
            int count = 5 - (historyStack.size() <= 5 ? historyStack.size() : 5);
            for (Command command : historyStack) {
                if (count == 5) {
                    break;
                }
                System.out.println(command);
                count++;
            }
        } else {
            System.out.println("Нет вызовов в истории((");
        }
    }

    @Override
    public String toString(){
        return "request";
    }
}
