package app.domain;

import java.util.*;
import java.io.Serializable;

public class Professor implements Serializable {
	private UUID id;
	private String nome;
	private List<Disciplina> disciplinas;

	public Professor(String nome) {
		this.id = UUID.randomUUID();
		setNome(nome);
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public UUID getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	} 

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public Disciplina consultarDisciplina(Disciplina disciplina) {
		int index = this.disciplinas.indexOf(disciplina);
		return this.disciplinas.get(index);
	}

	public Disciplina consultarDisciplina(String nome) {
		for(Disciplina disciplina : this.disciplinas) {
			if(disciplina.getNome().equalsIgnoreCase(nome) || disciplina.getId().toString().equalsIgnoreCase(nome)) {
				return disciplina;
			}
		}
		return null;
	}

	public List<Aluno> consultarAlunos(Disciplina disciplina) {
		return this.consultarDisciplina(disciplina).alunosMatriculados();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean adicionarDisciplina(Disciplina disciplina) {
		if(this.disciplinas.contains(disciplina)) return false;

		disciplina.setProfessor(this);
		return this.disciplinas.add(disciplina);
	}

	@Override
	public String toString() {
		if(this.disciplinas.size() == 0) {
			return "Professor{" +
				"id=" + id +
				", nome=" + nome +
				", disciplinas=" + disciplinas +
				'}';
		}
		return "Professor{" +
				"id=" + id +
				", nome=" + nome +
				", disciplinas=" + disciplinas +
				'}';
	}
}
