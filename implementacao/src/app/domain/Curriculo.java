package app.domain;

import java.io.Serializable;
import java.util.List;

public class Curriculo implements Serializable {
	private int id;
	private int ano;
	private int semestre;
	private Curso curso;
	private List<Disciplina> disciplinas;
	private Aluno aluno;	
	
	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public int getId() {
		return id;
	}

	public int getAno() {
		return ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public Curso getCurso() {
		return curso;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
