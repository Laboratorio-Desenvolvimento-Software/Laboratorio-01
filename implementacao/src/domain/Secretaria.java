package domain;

import java.util.*;

public class Secretaria {

	private List<Curriculo> curriculos;
	private List<Curso> cursos;
	private List<Professor> professores;
	private List<Aluno> alunos;	

	public Secretaria() {}

	public List<Curriculo> getCurriculo() {
		return this.curriculos;
	}

	public boolean gerarCurriculo(int ano, int semestre, Curso curso, Aluno aluno ) {
		return this.curriculos.add(new Curriculo(ano, semestre, curso, aluno));
	}

	public Curriculo getCurriculo(Aluno aluno) {
		for (Curriculo curriculo : this.curriculos) {
			if (curriculo.getAluno().equals(aluno)) {
				return curriculo;
			}
		}
		return null;
	}

	public double calcularCustoDeCurriculo(Aluno aluno) {
		return this.getCurriculo(aluno).calcularCargaHoraria();
	}

	public boolean matricularNovoAluno(String nome) {
		return this.alunos.add(new Aluno(nome));
	}

	public boolean removerAluno(Aluno aluno) {
		return this.alunos.remove(aluno);
	}

	public boolean cadastrarNovoProfessor(String nome) {
		return this.professores.add(new Professor(nome));
	}

	public boolean removerProfessor(Professor professor) {
		return this.professores.remove(professor);
	}

	public boolean atribuirDisciplinaProfessor(int periodo, int creditos, double preco, Professor professor) {
		return professor.adicionarDisciplina(new Disciplina(periodo, creditos, preco));
	}

	public boolean criarCurso(String nome, int creditos) {
		return this.cursos.add(new Curso(nome, creditos));
	}


	
}
