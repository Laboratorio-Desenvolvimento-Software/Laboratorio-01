# Detalhes para o diagrama de classes

### Link do lucid
https://lucid.app/lucidchart/d71853f2-124e-4b1e-83b1-1ac19930a85d/edit?view_items=pFEnZ.56kr_H&invitationId=inv_0eeb98af-6bc1-4c4f-9fe4-ba13dd49bb27


### Descrição dos metodos
Aluno 

	*matricularEmCurso(curso: Curso): void*, o aluno é adicionado na lista de alunos do curso, e o curso é colocado no atributo curso do aluno
	
	*cancelarMatricula(curso: Curso): void*, o aluno é removido na lista de alunos do curso, e o curso é retirado do atributo curso do aluno
	
	*consultarMatricula(): Curso*, retorna o curso
	
	*adicionarDisciplina(disciplina: Disciplina): void*, adiciona até 6 disciplinas, as primeiras 4 sendo obrigatórias e as 2 ultimas alternativas
	

Professor 

	*consultarAlunos(disciplina: Disciplina): List<Alunos>*, retorna uma lista de alunos
	
	*consultarDisciplina(disciplina: Disciplina): Disciplina*, retorna a disciplina


Disciplina 

	*alunosMatriculados(): List<Aluno>*, retorna os alunos matriculados a disciplina
		
	*isTurmaVazia(): bool*, se a turma tiver menos de 3 alunos, ela é considerada vazia
	
	*isTurmaCheia(): bool*, se a turma tiver 60 alunos, ela é considerada cheia
	

Curso 

	*getAlunos(): List<Aluno>*, retorna uma lista com todos os alunos do curso
	
	*getDisciplina(): List<Disciplina>*, retorna uma lista com todas as disciplinas

Curriculo 

	*getDisciplinas(): List<Disciplinas>*, retorna uma lista de disciplinas
	
	*getAluno(): Aluno*, retorna um aluno
	
	*getSemestre(): int*, retorna o semestre do curriculo

    *getAno(): int*, retorna o ano que o curriculo foi criado

Secretaria

    *matricularAluno(aluno: Aluno): void*, um novo aluno é adicionado a lista de alunos da organização;

    *cadastrarProfessor(professor: Professor): void*, adiciona um novo professor a lista de professores  

    *gerarCurriculo(aluno: Aluno, semestre: int): void*, adiciona um novo curriculo a lista de curriculos da organização

    *calcularCustoDeCurriculo(curriculo: Curriculo): float*, retorna a soma do preço de todas disciplinas do curriculo