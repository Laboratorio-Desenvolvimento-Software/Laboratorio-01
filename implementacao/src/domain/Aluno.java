package domain;

import java.util.*;

public class Aluno {
	private UUID id;
	private String nome;
	private Curso curso;
	private List<Disciplina> disciplinasObrigatorias;
	private List<Disciplina> disciplinasAlternativas;


	public Aluno(String nome) {
		this.id = UUID.randomUUID();
		setNome(nome);
	}

	public Aluno(String nome, Curso curso) {
		this.id = UUID.randomUUID();
		setNome(nome);
		this.matricularEmCurso(curso);
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return this.nome;
	}

	public Curso consultarMatricula() {
		return curso;
	}

	public void cancelarMatricula() {
		this.curso.removerAluno(this);
		this.curso = null;
	}

	public List<Disciplina> getDisciplinasObrigatorias() {
		return disciplinasObrigatorias;
	}

	public List<Disciplina> getDisciplinasAlternativas() {
		return disciplinasAlternativas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void matricularEmCurso(Curso curso) {
		curso.adicionarAluno(this);
		this.curso = curso;
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		if(this.disciplinasAlternativas.contains(disciplina) || this.disciplinasObrigatorias.contains(disciplina)) {
			System.out.println("Aluno ja esta matriculado nesta disciplina");
			return;
		}

		if(this.disciplinasObrigatorias.size() == 4) {
			if(this.disciplinasAlternativas.size() == 2) {
				System.out.println("Aluno ja esta matriculado em 6 disciplinas");
				return;
			}

			if(disciplina.matricularAluno(this)) {
				this.disciplinasAlternativas.add(disciplina);
			}

		}

		if(disciplina.matricularAluno(this)) {
			this.disciplinasObrigatorias.add(disciplina);
		}
					
	}

	public void removerDisciplina(Disciplina disciplina) {
		if(this.disciplinasAlternativas.contains(disciplina)) {
			this.disciplinasAlternativas.remove(disciplina);
			disciplina.cancelarMatricula(this);
			System.out.println("Disciplina removida com sucesso");			
			return;
		}
		
		if(this.disciplinasObrigatorias.contains(disciplina)) {
			this.disciplinasObrigatorias.remove(disciplina);
			disciplina.cancelarMatricula(this);
			System.out.println("Disciplina removida com sucesso");
			return;
		}

		System.out.println("Aluno nao esta matriculado nesta disciplina");
	}

	@Override
	public String toString() {
		return "Aluno{" +
				"id=" + id +
				", nome=" + nome +
				", curso=" + curso +
				", disciplinasObrigatorias=" + disciplinasObrigatorias +
				", disciplinasAlternativas=" + disciplinasAlternativas +
				'}';
	}

}
