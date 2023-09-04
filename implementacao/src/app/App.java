package app;

import java.util.Scanner;
import app.domain.*;
import app.util.Data;
import app.view.AlunoMenu;
import app.view.Logger;
import app.view.ProfessorMenu;
import app.view.SecretariaMenu;

public class App {

    public static void main(String[] args) {
        Data data = Data.getInstance();
        Secretaria secretaria = data.secretaria;
        Professor professor = data.professor;
        Aluno aluno = data.aluno;
        
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
                    case 1 -> new SecretariaMenu(secretaria, scanner);
                    case 2 -> new ProfessorMenu(professor, scanner);
                    case 3 -> new AlunoMenu(aluno, scanner);
                    case -1 -> {
                        System.out.println("Saindo do programa. Até logo!");
                        data.save();
                    }
                    default -> System.out.println("Opção inválida");
                }
            }
        }
    }

}
