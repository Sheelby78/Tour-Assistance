package model;

public class Realizacja {
    public Realizacja(String kto, String co, int ile){
        this.kto = kto;
        this.co = co;
        this.ile = ile;
    }

    public String getKto() {
        return kto;
    }

    private String kto;

    public String getCo() {
        return co;
    }

    private String co;

    public int getIle() {
        return ile;
    }

    private int ile;
}
