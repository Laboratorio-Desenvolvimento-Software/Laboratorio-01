package app.domain;

import java.util.List;

public class Disciplina {
	private int id;
	private int periodo;
	private Professor professor;
	private List<Aluno> alunos;
	private boolean disponivel;
	private int creditos;
	private double preco;
}
