package ru.bscmsc.task;

import java.util.Arrays;

public class Helper {
    public static String getParams(String readCommands) {
        return readCommands.replaceFirst("^\\S*", "").trim();
    }

    public static boolean isParamEmpty(Out out, String... params) {
        if (Arrays.stream(params).anyMatch(String::isEmpty)) {
            out.print("The parameter of command is not be empty.\n");
            return true;
        }
        return false;
    }
}
