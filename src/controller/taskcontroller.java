package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class taskcontroller {

    public taskcontroller() {
        super();
    }

    public String os() {
        return System.getProperty("os.name");
    }

    private boolean isWindows() {
        return os().equals("Windows 10");
    }

    private boolean isLinux() {
        return os().equals("Linux");
    }

    public String readProcess(final String process) {
        try {
            final Process executedProcess = Runtime.getRuntime().exec(process);
            final InputStream stream = executedProcess.getInputStream();
            final InputStreamReader reader = new InputStreamReader(stream);
            final BufferedReader buffer = new BufferedReader(reader);

            String line = buffer.readLine();

            while (line != null) {
                System.out.println(line);
                line = buffer.readLine();
            }

            buffer.close();
            reader.close();
            stream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return process;
    }

    public void listProcess() {
        String command = null;

        if (isWindows()) command = "TASKLIST /FO TABLE";
        if (isLinux()) command = "ps -ef";

        readProcess(command);
    }

    public void killName(String name) {
        String command = null;

        if (isWindows()) command = "TASKKILL /IM " + name+".exe";
        if (isLinux()) command = "pkill -f" + name;

        readProcess(command);
    }

    public void killPid(String pid) {
        String command = null;

        if (isWindows()) command = "TASKKILL /PID " + pid;
        if (isLinux()) command = "kill -9 " + pid;

        readProcess(command);
    }
}