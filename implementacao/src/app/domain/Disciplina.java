package app.domain;

import java.io.Serializable;
import java.util.List;

public class Disciplina implements Serializable {
	private int id;
	private int periodo;
	private Professor professor;
	private List<Aluno> alunos;
	private boolean disponivel;
	private int creditos;
	private double preco;
}
