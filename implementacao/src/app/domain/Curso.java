package app.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Curso implements Serializable {
	private UUID id;
	private String nome;
	private int creditos;
	private List<Disciplina> disciplinas;
	private List<Aluno> alunos;
	
	Curso(String nome, int creditos){
		this.id = UUID.randomUUID(); 
		setCreditos(creditos);
		setNome(nome);
	}
	
	Curso(String nome, int creditos, List<Disciplina> disciplina, List<Aluno> alunos){
		this.id = UUID.randomUUID(); 
		setAlunos(alunos);
		setDisciplinas(disciplina);
		setCreditos(creditos);
		setNome(nome);
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
