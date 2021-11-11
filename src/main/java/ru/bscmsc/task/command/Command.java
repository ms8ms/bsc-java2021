package ru.bscmsc.task.command;

public abstract class Command {

    public boolean isName(String toLowerCase) {
        return name().equalsIgnoreCase(toLowerCase);
    }

    public abstract String name();
}
