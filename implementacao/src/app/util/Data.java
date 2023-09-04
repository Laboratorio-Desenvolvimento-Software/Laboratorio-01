package app.util;

import app.domain.Aluno;
import app.domain.Professor;
import app.domain.Secretaria;

public class Data {
    private static Data INSTANCE;

    public Secretaria secretaria = new Secretaria();
    public Professor professor = new Professor("João");
    public Aluno aluno = new Aluno("João");

    private Data() {}

    public static Data getInstance() {
        if (INSTANCE == null) {
            Data data = new Data();

            data.secretaria = Util.unSerialize(data.secretaria);
            data.professor = Util.unSerialize(data.professor);
            data.aluno = Util.unSerialize(data.aluno);

            data.save();
            INSTANCE = data;
            return data;
        }

        return INSTANCE;
    }

    public void save() {
        Util.serialize(this.secretaria);
        Util.serialize(this.professor);
        Util.serialize(this.aluno);
    }
}
