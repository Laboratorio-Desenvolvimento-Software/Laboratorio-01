package app.view;

import app.domain.Disciplina;
import app.domain.Professor;

import java.util.List;
import java.util.Scanner;

public class ProfessorMenu {
    Professor professor;
    Scanner scanner;

    public ProfessorMenu(Professor professor, Scanner scanner) {
        this.professor = professor;
        this.scanner = scanner;

        String opt;

        do {

            Logger.info("Menu Secretaria");
            System.out.println("1) - Consultar disciplinas lecionadas");
            System.out.println("2) - Consultar alunos matriculados");
            System.out.println("-1) - Sair");
            System.out.print("Opção: ");
            opt = scanner.next();

            switch (opt) {
                case "1" -> {
                    List<Disciplina> disciplinas = this.professor.getDisciplinas();

                    if(disciplinas.size() == 0) {
                        Logger.error("Você não está lecionando uma disciplina!");
                        break;
                    }

                    this.professor.getDisciplinas().forEach(disciplina -> {
                        Logger.info("Id= " + disciplina.getId() + " Nome= " + disciplina.getNome());
                    });
                }
                case "2" -> {
                    List<Disciplina> disciplinas = this.professor.getDisciplinas();

                    if(disciplinas.size() == 0) {
                        Logger.error("Você não está lecionando uma disciplina!");
                        break;
                    }

                    this.professor.getDisciplinas().forEach(disciplina -> {
                        Logger.info("Id= " + disciplina.getId() + " Nome= " + disciplina.getNome());
                    });

                    System.out.print("Digite o nome ou id da disciplina: ");
                    String id = scanner.nextLine();

                    Disciplina searchDisciplina = this.professor.consultarDisciplina(id);

                    if(searchDisciplina.getAlunos().size() == 0) {
                        Logger.error("Ainda não há alunos matriculados nesta disciplina!");
                        break;
                    }

                    searchDisciplina.alunosMatriculados().forEach(aluno -> {
                        if(aluno != null) {
                            Logger.info("Id= " + aluno.getId() + " Nome= " + aluno.getNome());
                        }
                    });

                }
                case "-1" -> {}
                default -> Logger.error(opt + " não é uma opção válida!");
            }

        }while(!opt.equals("-1"));
    }
}
