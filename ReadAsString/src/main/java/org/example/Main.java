package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

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

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        try(InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset)) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[1024];
            int bytesRead;

            while ((bytesRead = inputStreamReader.read(buffer)) != -1) {
                stringBuilder.append(buffer, 0, bytesRead);
            }

            return stringBuilder.toString();
        }
    }
}