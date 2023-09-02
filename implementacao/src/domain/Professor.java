package domain;

import java.util.*;

public class Professor {
	private UUID id;
	private String nome;
	private List<Disciplina> disciplinas;

	public Professor(String nome) {
		this.id = UUID.randomUUID();
		setNome(nome);
	}

	//getters and setters
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

	public List<Aluno> consultarAlunos(Disciplina disciplina) {
		return this.consultarDisciplina(disciplina).alunosMatriculados();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean adicionarDisciplina(Disciplina disciplina) {
		return this.disciplinas.add(disciplina);
	}

	@Override
	public String toString() {
		return "Professor{" +
				"id=" + id +
				", nome=" + nome +
				", disciplinas=" + disciplinas +
				'}';
	}
}
