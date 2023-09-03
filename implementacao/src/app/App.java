package app;

import app.domain.*;
import app.util.Util;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Disciplina disciplina = new Disciplina();
		Professor osvaldo = new Professor("Osvaldo", List.of(disciplina));
		boolean serialize = Util.serialize(osvaldo);
		System.out.println("Serializado: " + serialize);

		Professor professor = Util.unSerialize(new Professor("Teste"));
		Util.unSerialize(professor);
		System.out.println(professor);
	}

}
