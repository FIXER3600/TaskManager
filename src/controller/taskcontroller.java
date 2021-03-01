package controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class taskcontroller {
    public taskcontroller() {
        super();
    }

    public String so() {
        String so = System.getProperty("os.name");

        return so;
    }

    public String readProcess(String process) {

            try {
                Process p = Runtime.getRuntime().exec(process);
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();

                while (linha != null) {
                    System.out.println(linha);

                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        return process;
        }
        public void listProcess(String so) {
            so = System.getProperty("os.name");
            if (so.equals("Windows 10")) {
                String process = "TASKLIST /FO TABLE";
                try {
                    Process p = Runtime.getRuntime().exec(process);
                    InputStream fluxo = p.getInputStream();
                    InputStreamReader leitor = new InputStreamReader(fluxo);
                    BufferedReader buffer = new BufferedReader(leitor);
                    String linha = buffer.readLine();

                    while (linha != null) {
                        System.out.println(linha);

                        linha = buffer.readLine();
                    }
                    buffer.close();
                    leitor.close();
                    fluxo.close();

                } catch (IOException e) {
                    e.printStackTrace();

                }
            } else if (so.equals("Linux")) {
                String process = "ps -ef";
            return;
            }
        }
    public void killName(String so, String param) {
        StringBuffer buffer = new StringBuffer();
        if (so.equals("Windows 10")) {
        String cmdNome = "TASKKILL /IM";

            buffer.append(cmdNome);
            buffer.append(" ");
            buffer.append(param);
        } else if (so.equals("Linux")) {
            String cmdNome = "pkill -f" + param;
  
            buffer.append(cmdNome);
            buffer.append(" ");
            buffer.append(param);

        }
        readProcess(buffer.toString());
    }

    public void killPid(String so, String param) {
        StringBuffer buffer = new StringBuffer();
        if (so.equals("Windows 10")) {
            String cmdPid = "TASKKILL /PID";
            int pid = 0;
            pid = Integer.parseInt(param);
            buffer.append(cmdPid);
            buffer.append(" ");
            buffer.append(pid);
        }else if(so.equals("Linux")){
            String cmdPid="kill -9"+param;
            int pid = 0;
            pid = Integer.parseInt(param);
            buffer.append(cmdPid);
            buffer.append(" ");
            buffer.append(pid);
        }
        readProcess(buffer.toString());
    }
}

