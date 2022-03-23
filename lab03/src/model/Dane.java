package model;

import utils.CsvReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Dane {
    public Dane(){
        readDane();
        readUcz();
        readZap();
        readPro();
        createDane();
        createUcz();
        createZap();
        createPro();
    }

    public void readZap(){
        String fileName = "src/Zapotrzebowanie.csv";
        Reader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvReader csvReader = new CsvReader(reader);
        zap = csvReader.readRecords();
    }

    public void readUcz(){
        String fileName = "src/Uczestnicy.csv";
        Reader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvReader csvReader = new CsvReader(reader);
        ucz = csvReader.readRecords();
    }

    public void readPro() {
        String fileName = "src/Realizacja.csv";
        Reader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvReader csvReader = new CsvReader(reader);
        pro = csvReader.readRecords();
    }

    public void readDane() {
        String fileName = "src/Dane.csv";
        Reader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        CsvReader csvReader = new CsvReader(reader);
        dane = csvReader.readRecords();
    }

    public void createZap(){
        List<Realizacja> propozycje = new ArrayList<>();
        for(int i =0;i<zap.size();i++){
            for(int j=0;j<(zap.get(i).size());j+=3){
                String name = zap.get(i).get(j);
                int quantityMax = Integer.parseInt(zap.get(i).get(j+1));
                int quantityNow = Integer.parseInt(zap.get(i).get(j+2));

                daneMap.get(i).getZapotrzebowanie().add(new Inventory(name, quantityMax, quantityNow, propozycje));

            }
        }
    }

    public void createUcz(){
        for(int i=0;i<ucz.size();i++){
            for(int j=0;j<ucz.get(i).size();j++){
                daneMap.get(i).getUczestnicy().add(ucz.get(i).get(j));

            }
        }
    }

    public void createPro(){
        for(int i=0; i<pro.size();i++){
            for(int j=0; j<pro.get(i).size();j+=3){
                String kto = pro.get(i).get(j);
                String co = pro.get(i).get(j+1);
                int ile = Integer.parseInt(pro.get(i).get(j+2));
                daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().add(new Realizacja(kto, co, ile));
            }
        }
    }

    public void createDane() {
            List<String> uczestnicy = new ArrayList<>();
            List<Inventory> zapotrzebowanie = new ArrayList<>();
        for (int i = 0; i < dane.size(); ++i) {
            String nazwa = dane.get(i).get(0);
            String opis = dane.get(i).get(1);
            String data = dane.get(i).get(2);
            String deadline = dane.get(i).get(3);
            daneMap.add(new Event(nazwa, opis, data, deadline, uczestnicy, zapotrzebowanie));
        }
    }

    public List<List<String>> getDane() {
        return dane;
    }

    public List<List<String>> dane;
    public List<List<String>> ucz;
    public List<List<String>> zap;
    public List<List<String>> pro;

    public List<Event> getDaneMap() {
        return daneMap;
    }

    public List<Event> daneMap = new ArrayList<>();


}
