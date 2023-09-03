package app.domain;

import java.io.Serializable;
import java.util.List;

public class Secretaria implements Serializable {
	private List<Curriculo> curriculos;
	private List<Curso> cursos;
	private List<Professor> professores;
	private List<Aluno> alunos;	
}
