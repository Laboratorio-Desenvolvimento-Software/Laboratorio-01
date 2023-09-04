package app.domain;

import java.io.Serial;
import java.util.*;
import java.io.Serializable;
import java.util.List;

public class Disciplina implements Serializable {

	@Serial
	private static final long serialVersionUID = 6754145710048669351L;

	private UUID id;
	private String nome;
	private int periodo;
	private Professor professor;
	private List<Aluno> alunos;
	private boolean disponivel;
	private int creditos;
	private double preco;

	public Disciplina(String nome, int periodo, int creditos, double preco) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.disponivel = true;
		setCreditos(creditos);
		setPreco(preco);
	}

	public Disciplina(String nome, int periodo, int creditos, double preco, Professor professor) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.disponivel = true;
		setPeriodo(periodo);
		setCreditos(creditos);
		setPreco(preco);
		setProfessor(professor);
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return this.nome;
	}

	public int getPeriodo() {
		return this.periodo;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public List<Aluno> alunosMatriculados() {
		return this.alunos;
	}

	public boolean isTurmaVazia() {
		return this.alunos.size() < 3;
	}

	public boolean isTurmaCheia() {
		return this.alunos.size() == 25;
	}

	public int getCreditos() {
		return creditos;
	}

	public double getPreco() {
		return preco;
	}

	public boolean matricularAluno(Aluno aluno) {
		if(this.isTurmaCheia()) {
			System.out.println("Turma esta cheia");
			return false;
		}

		this.alunos.add(aluno);
		return true;
	}

	public void cancelarMatricula(Aluno aluno) {
		this.alunos.remove(aluno);
	}

	public void cancelarMatricula(UUID id) {
		for(Aluno aluno : this.alunos) {
			if(aluno.getId().equals(id)) {
				this.alunos.remove(aluno);
				return;
			}
		}
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Disciplina{" +
				"id=" + id +
				", nome=" + nome +
				", periodo=" + periodo +
				", professor=" + professor +
				", alunos=" + alunos +
				", disponivel=" + disponivel +
				", creditos=" + creditos +
				", preco=" + preco +
				'}';
	}

}
