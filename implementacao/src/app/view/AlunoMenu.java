package app.view;

import app.domain.Aluno;
import app.domain.Curriculo;
import app.domain.Secretaria;

import java.util.Scanner;

public class AlunoMenu {
    Aluno aluno;
    Scanner scanner;


    public AlunoMenu(Aluno aluno, Scanner scanner) {
        this.aluno = aluno;
        this.scanner = scanner;

        String opt;

        do {
            Logger.info("Menu Aluno");
            System.out.println("1) - Consultar disciplinas disponíveis");
            System.out.println("2) - Consultar disciplinas matriculadas");
            System.out.println("3) - Matricular em disciplina");
            System.out.println("4) - Cancelar matrícula em disciplina");
            System.out.println("5) - Consultar curriculo");
            System.out.println("6) - Calcular boleto bancário");
            System.out.println("-1) - Sair");
            System.out.print("Opção: ");
            opt = scanner.next();

            switch (opt) {
                case "1" -> {
                    if(this.aluno.getCurso() == null) {
                        Logger.error("Aluno não está matriculado em nenhum curso");
                        break;
                    }

                    this.aluno.getCurso().getDisciplinas().forEach(disciplina -> {
                        Logger.warning("Id= " + disciplina.getId()
                                + " Nome= " + disciplina.getNome()
                                + " Creditos= " + disciplina.getCreditos()
                                + " Preco= " + disciplina.getPreco());
                    });
                }
                case "2" -> {
                    if(this.aluno.getCurso() == null) {
                        Logger.error("Aluno não está matriculado em nenhum curso");
                        break;
                    }

                    if(this.aluno.getDisciplinasObrigatorias().size() == 0 || this.aluno.getDisciplinasAlternativas().size() == 0) {
                        Logger.error("Aluno não está matriculado em nenhuma disciplina");
                        break;
                    }

                    this.aluno.getDisciplinasObrigatorias().forEach(disciplina -> {
                        Logger.warning("Id= " + disciplina.getId() + " Nome= " + disciplina.getNome() + " Creditos= " + disciplina.getCreditos() + " Preco= " + disciplina.getPreco());
                    });

                    this.aluno.getDisciplinasAlternativas().forEach(disciplina -> {
                        Logger.warning("Id= " + disciplina.getId() + " Nome= " + disciplina.getNome() + " Creditos= " + disciplina.getCreditos() + " Preco= " + disciplina.getPreco());
                    });
                }
                case "3" -> {
                  if(this.aluno.getCurso() == null) {
                      Logger.error("Aluno não está matriculado em nenhum curso");
                      break;
                  }

                    this.aluno.getCurso().getDisciplinas().forEach(disciplina -> {
                        Logger.warning("Id= " + disciplina.getId()
                                + " Nome= " + disciplina.getNome()
                                + " Creditos= " + disciplina.getCreditos()
                                + " Preco= " + disciplina.getPreco());
                    });

                    System.out.println("Digite o id da disciplina: ");
                    String id = scanner.nextLine();

                    this.aluno.adicionarDisciplina(this.aluno.getCurso().consultarDisciplina(id));
                    Logger.success("Disciplina adicionada com sucesso");

                }
                case "4" -> {
                    if(this.aluno.getCurso() == null) {
                        Logger.error("Aluno não está matriculado em nenhum curso");
                        break;
                    }

                    this.aluno.getCurso().getDisciplinas().forEach(disciplina -> {
                        Logger.warning("Id= " + disciplina.getId()
                                + " Nome= " + disciplina.getNome()
                                + " Creditos= " + disciplina.getCreditos()
                                + " Preco= " + disciplina.getPreco());
                    });

                    System.out.println("Digite o id da disciplina: ");
                    String id = scanner.nextLine();

                    this.aluno.removerDisciplina(this.aluno.getCurso().consultarDisciplina(id));
                }
                case "5" -> {
                    if(this.aluno.getCurso() == null) {
                        Logger.error("Aluno não está matriculado em nenhum curso");
                        break;
                    }

                    Curriculo curriculo = this.aluno.getCurriculo();
                    Logger.warning("Id= " + curriculo.getId()
                                    + " Ano= " + curriculo.getAno()
                                    + " Semestre= " + curriculo.getSemestre()
                                    + " Curso= " + curriculo.getCurso().getNome());
                }
                case "6" -> {
                    if(this.aluno.getCurso() == null) {
                        Logger.error("Aluno não está matriculado em nenhum curso");
                        break;
                    }

                    Curriculo curriculo = this.aluno.getCurriculo();
                    double boleto = curriculo.calcularCargaHoraria();
                    Logger.success("Boleto bancário: " + boleto + " reais");
                }
                case "-1" -> {
                    Logger.info("Saindo do menu aluno");
                }
                default -> {
                    Logger.error("Opção inválida");
                }
            }
        } while (!opt.equals("-1"));


    }
}
