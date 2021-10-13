package ru.bscmsc.task1;

import java.util.ArrayList;
import java.util.List;

public class ToDo {
    private final Out out = new Out();
    private final In in = new In();
    private final List<Task> tasks = new ArrayList<>();

    public ToDo() {
        out.printCommands();
        boolean quit = false;
        while (!quit) {
            out.selectCommand();
            quit = Command.QUIT.equals(controller(in.readCommand()));
        }
    }

    private Command controller(String readCommand) {
        String[] pars = readCommand.split(" ");

        if (pars[0].isEmpty()) {
            out.print("You have not entered a command\n");
            return null;
        }
        Command command = Command.byName(pars[0].toLowerCase());
        if (command != null) {
            switch (command) {
                case ADD:
                    addCommand(getParams(readCommand));
                    return Command.ADD;
                case QUIT:
                    return Command.QUIT;
                case PRINT:
                    printCommand(getParams(readCommand));
                    return Command.PRINT;
                case TOGGLE:
                    toggleCommand(getParams(readCommand));
                    return Command.TOGGLE;
                default:
                    out.printNoSupported();
            }
        } else {
            out.printNoSupported();
        }
        return null;
    }

    private void toggleCommand(String param) {
        if (param.isEmpty()) {
            out.print("The parameter of command is not be empty.\n");
            out.print("Format command: toggle <task id>.\n");
        } else {
            try {
                int taskId = Integer.parseInt(param);
                if (taskId < 1 || taskId > tasks.size()) {
                    out.print("The task with entered task id was not found.\n");
                } else {
                    tasks.get(taskId - 1).toggle();
                    out.printSuccessfully();
                }
            } catch (NumberFormatException e) {
                out.print("The task id must be number.\n");
            }
        }
    }

    private void printCommand(String param) {
        if (!param.isEmpty() && !"all".equalsIgnoreCase(param)) {
            out.print("The command does not correct parameters.\n");
            out.print("Format command: print [all]\n");
        } else {
            out.printTasks(tasks, !param.isEmpty());
        }
    }

    private void addCommand(String description) {
        if (description.isEmpty()) {
            out.print("The description of command is not be empty.\n");
            out.print("Format command: add <description>\n");
        } else {
            if (tasks.stream().anyMatch(task -> description.equals(task.getDescription()))) {
                out.print(String.format("The tasks with description (%s) exists\n", description));
            } else {
                tasks.add(new Task(description));
                out.printSuccessfully();
            }
        }
    }

    private String getParams(String readCommands) {
        return readCommands.replaceFirst("^\\S*", "").trim();
    }
}
