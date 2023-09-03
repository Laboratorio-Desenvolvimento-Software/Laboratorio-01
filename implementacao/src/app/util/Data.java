package app.util;

import app.domain.Secretaria;

public class Data {
    private static Data INSTANCE;

    public Secretaria secretaria = new Secretaria();

    private Data() {}

    public static Data getInstance() {
        if (INSTANCE == null) {
            Data data = new Data();
            data.secretaria = new Secretaria();
            data.secretaria = Util.unSerialize(data.secretaria);

            return data;
        }

        return INSTANCE;
    }

    public void save() {
        Util.serialize(secretaria);
    }
}
