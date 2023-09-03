package app.domain;

import java.io.Serializable;
import java.util.List;

public class Secretaria implements Serializable {
	private List<Curriculo> curriculos;
	private List<Curso> cursos;
	private List<Professor> professores;
	private List<Aluno> alunos;	

	public Secretaria() {
		this.alunos = new ArrayList<Aluno>();
		this.cursos = new ArrayList<Curso>();
		this.curriculos = new ArrayList<Curriculo>();
		this.professores = new ArrayList<Professor>();
	}

	public List<Curriculo> getCurriculos() {
		return this.curriculos;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public List<Professor> getProfessores() {
		return this.professores;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}



	// Curriculo

	public Curriculo gerarCurriculo(int ano, int semestre, Curso curso, Aluno aluno ) {
		aluno.matricularEmCurso(curso);
		Curriculo curriculo = new Curriculo(ano, semestre, curso, aluno);	
		this.curriculos.add(curriculo);
		return curriculo;
	}

	public Curriculo buscarCurriculoAluno(Aluno aluno) {
		for (Curriculo curriculo : this.curriculos) {
			if (curriculo.getAluno().equals(aluno)) {
				return curriculo;
			}
		}
		return null;
	}

	public double calcularCustoDeCurriculo(String nome) {
		return this.consultarCurriculo(nome).calcularCargaHoraria();
	}

	public boolean removerCurriculo(Curriculo curriculo) {
		if(this.curriculos.isEmpty()) return false;

		return this.curriculos.remove(curriculo);
	}

	public boolean removerCurriculo(String nome) {
		if(this.curriculos.isEmpty()) return false;
		
		for (Curriculo curriculo : this.curriculos) {
			if (curriculo.getId().toString().equalsIgnoreCase(nome)) {
				return this.curriculos.remove(curriculo);
			}
		}

		return false;
	}

	public Curriculo consultarCurriculo(String nome) {
		if(this.curriculos.isEmpty()) return null;

		for (Curriculo curriculo : curriculos) {
			if (curriculo.getId().toString().equalsIgnoreCase(nome)) {
				return curriculo;
			}
		}
		return null;
	}




	// Aluno

	public boolean matricularNovoAluno(String nome) {
		return this.alunos.add(new Aluno(nome));
	}

	public Aluno consultarAluno(String nome) {
		if(this.alunos.isEmpty()) return null;

		for (Aluno aluno : alunos) {
			if (aluno.getNome().equalsIgnoreCase(nome) || aluno.getId().toString().equalsIgnoreCase(nome)) {
				return aluno;
			}
		}
		return null;
	}

	public boolean removerAluno(Aluno aluno) {
		if(this.alunos.isEmpty()) return false;
		return this.alunos.remove(aluno);
	}

	public boolean removerAluno(String nome) {
		if(this.alunos.isEmpty()) return false;
		
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equalsIgnoreCase(nome) || aluno.getId().toString().equalsIgnoreCase(nome)) {
				return this.alunos.remove(aluno);
			}
		}

		return false;
	}





	// Professor

	public boolean cadastrarNovoProfessor(String nome) {
		return this.professores.add(new Professor(nome));
	}

	public Professor consultarProfessor(String nome) {
		if(this.professores.isEmpty()) return null;

		for (Professor professor : professores) {
			if (professor.getNome().equalsIgnoreCase(nome) || professor.getId().toString().equalsIgnoreCase(nome)) {
				return professor;
			}
		}
		return null;
	}

	public boolean removerProfessor(Professor professor) {
		if(this.professores.isEmpty()) return false;

		return this.professores.remove(professor);
	}

	public boolean removerProfessor(String nome) {
		if(this.professores.isEmpty()) return false;
		
		for (Professor professor : this.professores) {
			if (professor.getNome().equalsIgnoreCase(nome) || professor.getId().toString().equalsIgnoreCase(nome)) {
				return this.professores.remove(professor);
			}
		}

		return false;
	}

	// Curso

	public boolean criarNovoCurso(String nome, int creditos) {
		return this.cursos.add(new Curso(nome, creditos));
	}

	public Curso consultarCurso(String nome) {
		if(this.cursos.isEmpty()) return null;

		for (Curso curso : cursos) {
			if (curso.getNome().equalsIgnoreCase(nome) || curso.getId().toString().equalsIgnoreCase(nome)) {
				return curso;
			}
		}
		return null;
	}

	public boolean removerCurso(Curso curso) {
		if(this.cursos.isEmpty()) return false;

		return this.cursos.remove(curso);
	}

	public boolean removerCurso(String nome) {
		if(this.cursos.isEmpty()) return false;
		
		for (Curso curso : this.cursos) {
			if (curso.getNome().equalsIgnoreCase(nome) || curso.getId().toString().equalsIgnoreCase(nome)) {
				return this.cursos.remove(curso);
			}
		}

		return false;
	}

	
}
