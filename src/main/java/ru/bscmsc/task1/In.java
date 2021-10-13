package ru.bscmsc.task1;

import java.util.Scanner;

public class In {
    private final Scanner scanner = new Scanner(System.in);

    public String readCommand() {
        return scanner.nextLine();
    }
}
