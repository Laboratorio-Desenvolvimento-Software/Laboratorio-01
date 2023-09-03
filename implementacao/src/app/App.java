package app;

import java.util.Scanner;
import app.domain.*;
import app.util.Data;
import app.view.Logger;
import app.view.SecretariaMenu;

public class App {

    public static void main(String[] args) {
        Data data = Data.getInstance();
        Secretaria secretaria = data.secretaria;
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bem-vindo ao sistema de gerenciamento interno da Faculdade LAYOFF");

            int opt = 0;

            while (opt != -1) {
                Logger.info("Selecione um menu");
                System.out.println("1) - Secretaria");
                System.out.println("2) - Professor");
                System.out.println("3) - Aluno");
                System.out.println("-1) - Sair");
                System.out.print("Opção: ");
                opt = scanner.nextInt();

                switch (opt) {
                    case 1:
                        new SecretariaMenu(secretaria, scanner);
                        break;
                    case 2:
                        professorMenu(scanner);
                        break;
                    case 3:
                        alunoMenu(scanner);
                        break;
                    case -1:
                        System.out.println("Saindo do programa. Até logo!");
                        data.save();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        }
    }

    public static void professorMenu(Scanner scanner) {
        System.out.println("Professor");
    }

    public static void alunoMenu(Scanner scanner) {
        System.out.println("Aluno");
    }
}
