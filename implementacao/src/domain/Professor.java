package domain;

import java.util.List;
import java.util.UUID;

public class Professor {
	private UUID id;
	private String nome;
	private List<Disciplina> disciplinas;
	
	Professor(String nome) {
		this.id = UUID.randomUUID();
		setNome(nome);
	}
	
	Professor(String nome, List<Disciplina> disciplinas) {
		this.id = UUID.randomUUID();
		setNome(nome);
		setDisciplinas(disciplinas);
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
