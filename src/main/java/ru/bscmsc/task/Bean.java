package ru.bscmsc.task;

import lombok.Getter;
import ru.bscmsc.task.command.*;

import java.util.Arrays;
import java.util.List;

@Getter
public class Bean {
    private final IOut out = new Out();
    private final IInput in = new In();
    private final ITasks tasks = new Tasks();
    private final List<ICommand> listCommand = Arrays.asList(new Add(this), new Delete(this),
            new Edit(this), new Print(this), new Quit(this),
            new Search(this), new Toggle(this));
}
