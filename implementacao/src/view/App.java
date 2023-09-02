package view;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bemvindo ao sistema de gerenciamento interno da Faculdade LAYOFF");

            int opt = 0;
            
            System.out.println("Selecione um menu:");
            System.out.println("1 - Professor");
            System.out.println("2 - Secretaria");
            System.out.println("3 - Aluno");
            System.out.print("Opção: ");
            opt = scanner.nextInt();

            switch(opt) {
                case 1:
                    professorMenu();
                    break;
                case 2:
                    secretariaMenu();
                    break;
                case 3:
                    alunoMenu();
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

    }

    public static void professorMenu() {
        System.out.println("Professor");
    }

    public static void secretariaMenu() {
        System.out.println("Secretaria");
    }

    public static void alunoMenu() {
        System.out.println("Aluno");
    }
}
