package ru.bscmsc.task1;

public class ToDo {
    private final Out out = new Out();
    private final In in = new In();
    private Task task = null;

    public void exec() {
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
                    return command;
                case QUIT:
                    return command;
                case PRINT:
                    printCommand(getParams(readCommand));
                    return command;
                case TOGGLE:
                    toggleCommand(getParams(readCommand));
                    return command;
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
            if (task != null) {
                try {
                    int taskId = Integer.parseInt(param);
                    if (taskId != 1) {
                        out.print("The task with entered task id was not found.\n");
                    } else {
                        task.toggle();
                        out.printSuccessfully();
                    }
                } catch (NumberFormatException e) {
                    out.print("The task id must be number.\n");
                }
            } else {
                out.print("You have no tasks! Please create a task.\n");
            }
        }
    }

    private void printCommand(String param) {
        if (!param.isEmpty() && !"all".equalsIgnoreCase(param)) {
            out.print("The command does not correct parameters.\n");
            out.print("Format command: print [all]\n");
        } else {
            if (task != null) {
                if (!out.printTask(1, task, !param.isEmpty())) {
                    out.print("There is no information to output.\n");
                }
            } else {
                out.print("You have no tasks! Please create a task.\n");
            }
        }
    }

    private void addCommand(String description) {
        if (description.isEmpty()) {
            out.print("The description of command is not be empty.\n");
            out.print("Format command: add <description>\n");
        } else {
            task = new Task(description);
            out.printSuccessfully();
        }
    }

    private String getParams(String readCommands) {
        return readCommands.replaceFirst("^\\S*", "").trim();
    }
}
