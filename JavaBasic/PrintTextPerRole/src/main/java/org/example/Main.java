package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    private String printTextPerRole(String[] roles, String[] textLines) {
        Set<String> roleSet = new HashSet<>();
        Map<String, List<String>> roleToLines = new HashMap<>();
        for (String role : roles) {
            roleSet.add(role);
            roleToLines.put(role, new ArrayList<>());
        }

        for (int i = 0; i < textLines.length; i++) {
            String line = textLines[i];
            int colonIndex = line.indexOf(':');
            if (colonIndex == -1) continue;

            String role = line.substring(0, colonIndex);
            if (!roleSet.contains(role)) continue;
            String text = line.substring(colonIndex + 1);
            String numberedLine = (i + 1) + ")" + text;
            roleToLines.get(role).add(numberedLine);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            String role = roles[i];
            result.append(role).append(":\n");
            List<String> lines = roleToLines.get(role);
            for (String line : lines) {
                result.append(line).append("\n");
            }
            if (i < roles.length - 1) {
                result.append("\n");
            }
        }

        return result.toString();
    }
}