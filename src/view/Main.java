package view;

import javax.swing.*;
import controller.taskcontroller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        taskcontroller procController= new taskcontroller();
        String sistemaOper=procController.os();

        Integer opc=Integer.parseInt(JOptionPane.showInputDialog("1- Ver processos \n 2-Matar por nome \n 3-Matar por PID"));
        switch (opc){
            case 1:
                procController.listProcess();
                break;
            case 2:
                    String name = JOptionPane.showInputDialog("Digite o nome da aplicação:");
                    procController.killName(name);
                break;
            case 3:
                String p=JOptionPane.showInputDialog("Digite o pid da aplicação");

                procController.killPid(p);
                break;
        }


    }
}
