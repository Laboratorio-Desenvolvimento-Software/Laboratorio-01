package app;

import app.domain.*;
import app.util.Util;

public class App {

	public static void main(String[] args) {
		Professor osvaldo = new Professor("Osvaldo");
		boolean serialize = Util.serialize(osvaldo);
		System.out.println("Serializado: " + serialize);

		Professor professor = Util.unSerialize(new Professor("Teste"));
		Util.unSerialize(professor);
		System.out.println(professor);
	}

}
