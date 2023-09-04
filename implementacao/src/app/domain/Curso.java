package app.domain;

import java.io.Serial;
import java.util.*;
import java.io.Serializable;

public class Curso implements Serializable {

	@Serial
	private static final long serialVersionUID = 6441138151809754126L;

	private UUID id;
	private String nome;
	private int creditos;
	private List<Disciplina> disciplinas;
	private List<Aluno> alunos;

	public Curso(String nome, int creditos) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.creditos = creditos;
		this.alunos = new ArrayList<Aluno>();
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public Curso(String nome, int creditos, List<Disciplina> disciplinas) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.creditos = creditos;
		this.disciplinas = disciplinas;
	}

	public Curso(String nome, int creditos, List<Disciplina> disciplinas, List<Aluno> alunos) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.creditos = creditos;
		this.disciplinas = disciplinas;
		this.alunos = alunos;
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	@Override
	public String toString() {
		return "Curso{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", creditos=" + creditos +
				", disciplinas=" + disciplinas +
				", alunos=" + alunos +
				'}';
	}

	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	public void removerAluno(Aluno aluno) {
		this.alunos.remove(aluno);
	}

	public void removerAluno(UUID id) {
		for (Aluno aluno : this.alunos) {
			if (aluno.getId() == id) {
				this.alunos.remove(aluno);
				break;
			}
		}
	}

	public Disciplina consultarDisciplina(Disciplina disciplina) {
		int index = this.disciplinas.indexOf(disciplina);
		return this.disciplinas.get(index);
	}

	public Disciplina consultarDisciplina(String nome) {
		for (Disciplina disciplina : this.disciplinas) {
			if (disciplina.getId().toString().equalsIgnoreCase(nome)) {
				return disciplina;
			}
		}

		return null;
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}

	public void removerDisciplina(Disciplina disciplina) {
		this.disciplinas.remove(disciplina);
	}

	public void removerDisciplina(UUID id) {
		for (Disciplina disciplina : this.disciplinas) {
			if (disciplina.getId() == id) {
				this.disciplinas.remove(disciplina);
				break;
			}
		}
	}

}
