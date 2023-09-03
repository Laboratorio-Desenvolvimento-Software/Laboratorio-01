package domain;

import java.util.*;
import java.io.Serializable;

public class Aluno implements Serializable{
	private UUID id;
	private String nome;
	private Curso curso;
	private Curriculo curriculo;
	private List<Disciplina> disciplinasObrigatorias;
	private List<Disciplina> disciplinasAlternativas;


	public Aluno(String nome) {
		this.id = UUID.randomUUID();
		setNome(nome);
		this.curso = null;
		this.disciplinasObrigatorias = new ArrayList<Disciplina>();
		this.disciplinasAlternativas = new ArrayList<Disciplina>();
		this.curriculo = null;
	}

	public Aluno(String nome, Curso curso) {
		this.id = UUID.randomUUID();
		setNome(nome);
		this.matricularEmCurso(curso);
		this.disciplinasObrigatorias = new ArrayList<Disciplina>();
		this.disciplinasAlternativas = new ArrayList<Disciplina>();
		this.curriculo = null;
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

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public void matricularEmCurso(Curso curso) {
		curso.adicionarAluno(this);
		this.curso = curso;
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		if(this.curriculo == null || this.curso == null) {
			System.out.println("Aluno nao esta matriculado em nenhum curso");
			return;
		}

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
				this.curriculo.adicionarDisciplina(disciplina);
			}

		}

		if(disciplina.matricularAluno(this)) {
			this.disciplinasObrigatorias.add(disciplina);
			this.curriculo.adicionarDisciplina(disciplina);
		}
					
	}

	public void removerDisciplina(Disciplina disciplina) {
		if(this.curriculo == null || this.curso == null) {
			System.out.println("Aluno nao esta matriculado em nenhum curso");
			return;
		}

		if(this.disciplinasAlternativas.contains(disciplina)) {
			this.disciplinasAlternativas.remove(disciplina);
			disciplina.cancelarMatricula(this);
			this.curriculo.removerDisciplina(disciplina);
			System.out.println("Disciplina removida com sucesso");			
			return;
		}
		
		if(this.disciplinasObrigatorias.contains(disciplina)) {
			this.disciplinasObrigatorias.remove(disciplina);
			disciplina.cancelarMatricula(this);
			this.curriculo.removerDisciplina(disciplina);
			System.out.println("Disciplina removida com sucesso");
			return;
		}

		System.out.println("Aluno nao esta matriculado nesta disciplina");
	}

	@Override
	public String toString() {
		if(curso == null) {
			return "Aluno{" +
					"id=" + id +
					", nome=" + nome +
					", curso=" + null +
					", disciplinasObrigatorias=" + disciplinasObrigatorias +
					", disciplinasAlternativas=" + disciplinasAlternativas +
				'}';

		}

		return "Aluno{" +
					"id=" + id +
					", nome=" + nome +
					", curso=" + curso.getNome() +
					", disciplinasObrigatorias=" + disciplinasObrigatorias +
					", disciplinasAlternativas=" + disciplinasAlternativas +
				'}';
	}

}
