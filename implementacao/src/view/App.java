package view;

import java.util.Scanner;

import domain.Aluno;
import domain.Professor;
import domain.Secretaria;


public class App {

    public static void main(String[] args) {

        Secretaria secretaria = new Secretaria();
        Professor professor = new Professor("João");
        Aluno aluno = new Aluno("Maria");


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
        // You can add professor-specific functionality here


        return;
    }

    public static void alunoMenu(Scanner scanner) {
        System.out.println("Aluno");
        // You can add aluno-specific functionality here

        // To go back to the main menu, you can simply return from this method
        // The loop in the main method will continue, and the user can choose another option.
        return;
    }
}
