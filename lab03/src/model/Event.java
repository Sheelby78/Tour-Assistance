package model;

import java.util.ArrayList;
import java.util.List;

public class Event {

    public Event(String nazwa, String opis, String data, String deadline, List<String> uczestnicy, List<Inventory> zapotrzebowanie){
        this.nazwa = nazwa;
        this.opis = opis;
        this.data = data;
        this. deadline = deadline;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    private String nazwa;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    private String opis;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private String data;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    private String deadline;

    public List<String> getUczestnicy() {
        return uczestnicy;
    }

    private List<String> uczestnicy = new ArrayList<>();

    public List<Inventory> getZapotrzebowanie() {
        return zapotrzebowanie;
    }

    private List<Inventory> zapotrzebowanie = new ArrayList<>();
}
