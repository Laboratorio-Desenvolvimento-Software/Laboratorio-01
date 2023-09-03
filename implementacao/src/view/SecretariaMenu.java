package view;

import java.util.*;
import src.app.domain.*;

public class SecretariaMenu {

    Secretaria secretaria;
    Scanner scanner;
    
    public SecretariaMenu(Secretaria secretaria, Scanner scanner) {
        this.secretaria = secretaria;
        this.scanner = scanner;

        String opt = "";

        while (opt != "-1") { 
            Logger.info("Menu Secretaria");
            System.out.println("1) - Gerenciar alunos");
            System.out.println("2) - Gerenciar professores");
            System.out.println("3) - Gerenciar currículos");
            System.out.println("4) - Gerenciar curso");
            System.out.println("-1) - Sair");
            System.out.print("Opção: ");
            opt = scanner.next();

            switch (opt) {
                case "1":
                    gerenciarAluno();
                    break;
                case "2":
                    gerenciarProfessor();
                    break;
                case "3":
                    gerenciarCurriculo();
                    break;
                case "4":
                    genrenciarCurso();
                    break;
                case "-1":
                    break;
                default:
                    Logger.error(opt + " não é uma opção válida!");
                    break;
            }


            if(opt.equals("-1")) {
                break;
            }
        }
        return;
    }



    public void gerenciarAluno() {
        String opt = "";

        while (opt != "-1") { 
            Logger.info("Menu Secretaria | Gerenciar alunos");
            System.out.println("1) - Listar alunos");
            System.out.println("2) - Matricular novo aluno");
            System.out.println("3) - Cancelar matricula de aluno");
            System.out.println("4) - Buscar aluno");
            System.out.println("-1) - Sair");
            System.out.print("Opção: ");
            opt = this.scanner.next();

            switch (opt) {
                case "1":
                    List<Aluno> alunos = this.secretaria.getAlunos();

                    if(alunos == null || alunos.isEmpty()) {
                        Logger.error("Não há alunos cadastrados!");
                        break;
                    }

                    this.secretaria.getAlunos().forEach(aluno -> {
                        if (aluno != null) {
                            Logger.warning(aluno.toString());
                        }
                    });
                    break;

                case "2":
                    System.out.print("Digite o nome do aluno: ");
                    this.scanner.nextLine();
                    String newAluno = this.scanner.nextLine();

                    this.secretaria.matricularNovoAluno(newAluno);

                    Logger.success(newAluno + " matriculado com sucesso!");
                    break;
                case "3":
                    System.out.print("Digite o nome ou nº da matricula do aluno: ");
                    this.scanner.nextLine();
                    String removeAluno = this.scanner.nextLine();

                    this.secretaria.removerAluno(removeAluno);
                    Logger.success("matricula de " + removeAluno + " cancelada com sucesso!");
                    break;
                case "4":
                    System.out.print("Digite o nome ou nº da matricula do aluno: ");
                    this.scanner.nextLine();
                    String searchAluno = this.scanner.nextLine();;

                    Aluno aluno = this.secretaria.consultarAluno(searchAluno);
                    if(aluno == null) {
                        Logger.error(searchAluno + " não encontrado!");
                        break;
                    }

                    Logger.warning(aluno.toString());
                    break;
                case "-1":
                    break;
                default:
                    Logger.error(opt + " não é uma opção válida!");
                    break;
            }


            if(opt.equals("-1")) {
                break;
            }
        }
        return;
    }


    public void gerenciarProfessor() {
        String opt = "";

        while (opt != "-1") { 
            Logger.info("Menu Secretaria | Gerenciar professores");
            System.out.println("1) - Listar professores");
            System.out.println("2) - Cadastrar novo professores");
            System.out.println("3) - Remover professor");
            System.out.println("4) - Buscar professor");
            System.out.println("5) - Alocar professor em disciplina");
            System.out.println("-1) - Sair");
            System.out.print("Opção: ");
            opt = this.scanner.next();

            switch (opt) {
                case "1":
                    List<Professor> professor = this.secretaria.getProfessores();

                    if(professor == null || professor.isEmpty()) {
                        Logger.error("Não há professor cadastrados!");
                        break;
                    }

                    this.secretaria.getProfessores().forEach(p -> {
                        if (p != null) {
                            Logger.warning(p.toString());
                        }
                    });
                    break;

                case "2":
                    System.out.print("Digite o nome do professor: ");
                    this.scanner.nextLine();
                    String newProfessor = this.scanner.nextLine();

                    this.secretaria.cadastrarNovoProfessor(newProfessor);

                    Logger.success(newProfessor + " cadastrado com sucesso!");
                    break;
                case "3":
                    System.out.print("Digite o nome ou id do professor: ");
                    this.scanner.nextLine();
                    String removeProfessor = this.scanner.nextLine();

                    this.secretaria.removerProfessor(removeProfessor);
                    Logger.success(removeProfessor + " removido(a) do sistema com sucesso!");
                    break;
                case "4":
                    System.out.print("Digite o nome ou id do professor: ");
                    this.scanner.nextLine();
                    String searchProfessor = this.scanner.nextLine();;

                    Professor p = this.secretaria.consultarProfessor(searchProfessor);
                    if(p == null) {
                        Logger.error(searchProfessor + " não encontrado!");
                        break;
                    }

                    Logger.warning(p.toString());
                    break;
                case "5":
                    List<Professor> professor1 = this.secretaria.getProfessores();

                    if(professor1 == null || professor1.isEmpty()) {
                        Logger.error("Não há professor cadastrados!");
                        break;
                    }

                    professor1.forEach(p1 -> {
                        if (p1 != null) {
                            Logger.warning(p1.toString());
                        }
                    });

                    System.out.print("Digite o nome ou id do professor: ");
                    this.scanner.nextLine();
                    String nomeProfessor = this.scanner.nextLine();

                    Professor professorConsultado = this.secretaria.consultarProfessor(nomeProfessor);

                    if(professorConsultado == null) {
                        Logger.error(nomeProfessor + " não encontrado!");
                        break;
                    }

                    List<Curso> cursos = this.secretaria.getCursos();

                    if(cursos == null || cursos.isEmpty()) {
                        Logger.error("Não há cursos cadastrados!");
                        break;
                    }

                    cursos.forEach(p1 -> {
                        if (p1 != null) {
                            Logger.warning(p1.toString());
                        }
                    });

                    System.out.println("Digite o nome ou id do curso: ");
                    String nomeCurso = this.scanner.nextLine();

                    Curso cursoConsultado = this.secretaria.consultarCurso(nomeCurso);

                    if(cursoConsultado == null) {
                        Logger.error(nomeCurso + " não encontrado!");
                        break;
                    }

                    cursoConsultado.getDisciplinas().forEach(d -> {
                        if (d != null) {
                            Logger.warning(d.toString());
                        }
                    });

                    System.out.println("Digite o id da disciplina: ");
                    String nomeDisciplina = this.scanner.nextLine();

                    Disciplina disciplina = cursoConsultado.consultarDisciplina(nomeDisciplina);

                    if(disciplina == null) {
                        Logger.error(nomeDisciplina + " não encontrado!");
                        break;
                    }

                    professorConsultado.adicionarDisciplina(disciplina);

                    Logger.success("Disciplina " + disciplina.getId() + " alocada para " + professorConsultado.getNome());

                    break;
                case "-1":
                    break;
                default:
                    Logger.error(opt + " não é uma opção válida!");
                    break;
            }

            if(opt.equals("-1")) {
                break;
            }
        }
        return;
    }


    public void genrenciarCurso() {
        String opt = "";

        while (opt != "-1") { 
            Logger.info("Menu Secretaria | Gerenciar curso");
            System.out.println("1) - Listar cursos");
            System.out.println("2) - Cadastrar novo cursos");
            System.out.println("3) - Remover curso");
            System.out.println("4) - Buscar curso");
            System.out.println("5) - Adicionar disciplina a curso");
            System.out.println("-1) - Sair");
            System.out.print("Opção: ");
            opt = this.scanner.next();

            switch (opt) {
                case "1":
                    List<Curso> curso = this.secretaria.getCursos();

                    if(curso == null || curso.isEmpty()) {
                        Logger.error("Não há cursos cadastrados!");
                        break;
                    }

                    this.secretaria.getCursos().forEach(c -> {
                        if (c != null) {
                            Logger.warning(c.toString());
                        }
                    });
                    break;

                case "2":
                    System.out.print("Digite o nome do curso: ");
                    this.scanner.nextLine();
                    String newCursoNome = this.scanner.nextLine();

                    System.out.print("Quantos creditos terá esse curso?: ");
                    int newCursoCreditos = this.scanner.nextInt();

                    this.secretaria.criarNovoCurso(newCursoNome, newCursoCreditos);

                    Logger.success("Curso " + newCursoNome + " criado com sucesso!");
                    break;
                case "3":
                    System.out.print("Digite o nome ou id do curso: ");
                    this.scanner.nextLine();
                    String removeCurso = this.scanner.nextLine();

                    this.secretaria.removerCurso(removeCurso);
                    Logger.success("Curso " + removeCurso + " removido do sistema com sucesso!");
                    break;
                case "4":
                    System.out.print("Digite o nome ou id do curso: ");
                    this.scanner.nextLine();
                    String searchCurso = this.scanner.nextLine();

                    Curso c = this.secretaria.consultarCurso(searchCurso);
                    if(c == null) {
                        Logger.error("Curso " + searchCurso + " não encontrado!");
                        break;
                    }

                    Logger.warning(c.toString());
                    break;
                case "5": 
                    List<Curso> allCurso = this.secretaria.getCursos();

                    if(allCurso == null || allCurso.isEmpty()) {
                        Logger.error("Não há cursos cadastrados!");
                        break;
                    }

                    this.secretaria.getCursos().forEach(c2 -> {
                        if (c2 != null) {
                            Logger.warning(c2.toString());
                        }
                    });

                    System.out.print("Digite o nome ou id do curso: ");
                    this.scanner.nextLine();
                    String searchCurso2 = this.scanner.nextLine();

                    Curso cursoConsultado = this.secretaria.consultarCurso(searchCurso2);
                    if(cursoConsultado == null) {
                        Logger.error("Curso " + searchCurso2 + " não encontrado!");
                        break;
                    }

                    System.out.print("Digite o nome da disciplina: ");
                    String nomeDisciplina = this.scanner.nextLine();

                    System.out.print("Digite o periodo da disciplina: ");
                    int periodoDisciplina = this.scanner.nextInt();

                    if(periodoDisciplina < 0 || periodoDisciplina > 16) {
                        Logger.error("Periodo inválido!");
                        break;
                    }

                    System.out.print("Digite os creditos da disciplina: ");
                    int creditosDisciplina = this.scanner.nextInt();

                    System.out.print("Digite o preço da disciplina: ");
                    double precoDisciplina = this.scanner.nextDouble();

                    cursoConsultado.adicionarDisciplina(new Disciplina(nomeDisciplina, periodoDisciplina, creditosDisciplina, precoDisciplina));

                    break;
                case "-1":
                    break;
                default:
                    Logger.error(opt + " não é uma opção válida!");
                    break;
            }

            if(opt.equals("-1")) {
                break;
            }
        }
        return;
    }


    public void gerenciarCurriculo() {
        String opt = "";

        while (opt != "-1") { 
            Logger.info("Menu Secretaria | Gerenciar curriculo");
            System.out.println("1) - Listar curriculos");
            System.out.println("2) - Gerar novo curriculo");
            System.out.println("3) - Remover curriculo");
            System.out.println("4) - Buscar curriculo");
            System.out.println("5) - Calcular custo de curriculo");
            System.out.println("-1) - Sair");
            System.out.print("Opção: ");
            opt = this.scanner.next();

            switch (opt) {
                case "1":
                    List<Curriculo> curriculo = this.secretaria.getCurriculos();

                    if(curriculo == null || curriculo.isEmpty()) {
                        Logger.error("Não há curriculos cadastrados!");
                        break;
                    }

                    curriculo.forEach(c -> {
                        if (c != null) {
                            Logger.warning(c.toString());
                        }
                    });
                    break;

                case "2":
                    this.secretaria.getCursos().forEach(c -> {
                        if (c != null) {
                            Logger.warning(c.toString());
                        }
                    });
 
                    System.out.print("Digite o nome ou id do curso: ");
                    this.scanner.nextLine();
                    String newCurso = this.scanner.nextLine();

                    Curso curso = this.secretaria.consultarCurso(newCurso);
                    
                    if(curso == null) {
                        Logger.error("Curso " + newCurso + " não encontrado!");
                        break;
                    }
                    
                    this.secretaria.getAlunos().forEach(a -> {
                        if (a != null) {
                            Logger.warning(a.toString());
                        }
                    });

                    System.out.print("Digite o nome ou id do aluno: ");
                    String newAluno = this.scanner.nextLine();

                    Aluno aluno = this.secretaria.consultarAluno(newAluno);

                    if(aluno == null) {
                        Logger.error("Aluno " + newAluno + " não encontrado!");
                        break;
                    }

                    System.out.print("Digite o ano decorrente: ");
                    int newAno = this.scanner.nextInt();

                    if(newAno < 0 || newAno > 9999) {
                        Logger.error("Ano inválido!");
                        break;
                    }

                    System.out.print("Digite o semestre decorrente: ");
                    int newSemestre = this.scanner.nextInt();

                    if(newSemestre < 0 || newSemestre > 2) {
                        Logger.error("Semestre inválido!");
                        break;
                    }

                    aluno.setCurriculo(this.secretaria.gerarCurriculo(newAno, newSemestre, curso, aluno));

                    Logger.success("Curriculo cadastrado com sucesso!");
                    break;
                case "3":
                    System.out.print("Digite o id do curriculo: ");
                    this.scanner.nextLine();
                    String removeCurriculo = this.scanner.nextLine();

                    this.secretaria.removerCurriculo(removeCurriculo);
                    Logger.success("Curriculo " + removeCurriculo + " removido do sistema com sucesso!");
                    break;
                case "4":
                    System.out.print("Digite o id do curriculo: ");
                    this.scanner.nextLine();
                    String searchCurriculo = this.scanner.nextLine();

                    Curriculo c = this.secretaria.consultarCurriculo(searchCurriculo);

                    if(c == null) {
                        Logger.error("Curriculo " + searchCurriculo + " não encontrado!");
                        break;
                    }

                    Logger.warning(c.toString());
                    break;
                case "5":
                    System.out.print("Digite o id do curriculo: ");
                    this.scanner.nextLine();
                    String searchCurriculoNome = this.scanner.nextLine();

                    Curriculo c1 = this.secretaria.consultarCurriculo(searchCurriculoNome);

                    if(c1 == null) {
                        Logger.error("Curriculo " + searchCurriculoNome + " não encontrado!");
                        break;
                    }

                    double custo = this.secretaria.calcularCustoDeCurriculo(searchCurriculoNome);
                    Logger.success("Curriculo de " + c1.getAluno().getNome() + " custará " + custo + " reais");
                    break;
                case "-1":
                    break;
                default:
                    Logger.error(opt + " não é uma opção válida!");
                    break;
            }

            if(opt.equals("-1")) {
                break;
            }
        }
        return;
    }
}


