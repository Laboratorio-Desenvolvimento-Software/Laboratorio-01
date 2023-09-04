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

        if(secretaria.consultarAluno(aluno.getNome()) == null)
            secretaria.matricularAluno(aluno);
        if(secretaria.consultarProfessor(professor.getNome()) == null)
            secretaria.cadastrarProfessor(professor);

        try (Scanner scanner = new Scanner(System.in)) {

            Logger.info("Sistema de gerenciamento interno da Faculdade LAYOFF");

            String opt;

            do {
                Logger.info("Selecione um menu");
                System.out.println("1) - Secretaria");
                System.out.println("2) - Professor");
                System.out.println("3) - Aluno");
                System.out.println("-1) - Sair");
                System.out.print("Opção: ");
                opt = scanner.next();

                switch (opt) {
                    case "1" -> new SecretariaMenu(secretaria, scanner, data);
                    case "2" -> new ProfessorMenu(professor, scanner, data);
                    case "3" -> new AlunoMenu(aluno, scanner, data);
                    case "-1" -> {
                        System.out.println("Saindo do programa. Até logo!");
                        data.save();
                    }
                    default -> System.out.println("Opção inválida");
                }
            } while (!opt.equals("-1"));
        }
    }

}
