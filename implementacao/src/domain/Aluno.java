package domain;

import java.util.List;
import java.util.UUID;

public class Aluno {
	private UUID id;
	private Curso curso;
	private List<Disciplina> disciplinasObrigatorias;
	private List<Disciplina> disciplinasAlternativas;
	
	Aluno(){
		
	}
	Aluno(Curso curso) {
		matricularEmCurso(curso);
	}
	
	public UUID getId() {
		return id;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public List<Disciplina> getDisciplinasObrigatorias() {
		return disciplinasObrigatorias;
	}
	
	public List<Disciplina> getDisciplinasAlternativas() {
		return disciplinasAlternativas;
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		if(this.disciplinasObrigatorias.size() < 4) {
			this.disciplinasObrigatorias.add(disciplina);
			return;
		} else {
			if(this.disciplinasAlternativas.size() < 2) {
				this.disciplinasAlternativas.add(disciplina);
				return;
			}
		}
		System.out.println("Limite de 6 disciplinas atingido!");
		return;
	}
	
	public void matricularEmCurso(Curso curso) {
		if(this.curso == null) {
			System.out.println("Aluno já esta matriculado em um curso");
			return;
		}
		
		this.curso = curso;
		curso.getAlunos().add(this);
	}
	
	public void cancelarMatricula() {
		if(this.curso == null) {
			System.out.println("Aluno não está matriculado em um curso");
			return;
		}
		
		this.curso.getAlunos().remove(this);
		this.curso = null;
	}
	
}
