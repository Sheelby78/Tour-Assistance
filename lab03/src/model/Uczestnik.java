package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Uczestnik {

    Dane dane = new Dane();
    List<Event> daneMap = dane.getDaneMap();
    public void viewList(){
            System.out.println("Nazwa | Opis | Data | Deadline");
            System.out.println();
        for(int i=0; i< daneMap.size(); i++){
            System.out.print(daneMap.get(i).getNazwa() + " | ");
            System.out.print(daneMap.get(i).getOpis() + " | ");
            System.out.print(daneMap.get(i).getData() + " | ");
            System.out.print(daneMap.get(i).getDeadline() + "\n");
        }
    }
    public void selectEvent(String event, String imieNazwisko){
        for(int i=0;i< daneMap.size();i++){
            if(event.equals(daneMap.get(i).getNazwa())){
                daneMap.get(i).getUczestnicy().add(imieNazwisko);
            }
        }
        try {
            String fileName = "src/Uczestnicy.csv";
            FileWriter writer = new FileWriter(fileName);
            writer.write("Uczestnicy;" + System.lineSeparator());
            for (int i = 0; i < daneMap.size(); i++) {
                for (int j = 0; j < daneMap.get(i).getUczestnicy().size(); j++) {
                    writer.write(daneMap.get(i).getUczestnicy().get(j) + ";");
                }
                writer.write(System.lineSeparator());
            }
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewListZap(String event){
        for(int i=0;i<daneMap.size();i++){
            if(event.equals(daneMap.get(i).getNazwa())){
                System.out.println("Item | Wymagana ilość | Aktualna ilość |");
                System.out.println();
                for(int j=0;j< daneMap.get(i).getZapotrzebowanie().size();j++){
                    System.out.print(daneMap.get(i).getZapotrzebowanie().get(j).getName() + " | ");
                    System.out.print(daneMap.get(i).getZapotrzebowanie().get(j).getQuantityMax() + " | ");
                    System.out.print(daneMap.get(i).getZapotrzebowanie().get(j).getQuantityNow() + " | \n");

                }
            }
        }
    }

    public void zglosRealizacje(String event, String kto, String co, int ile){
        for(int i=0;i<daneMap.size();i++){
            if(event.equals(daneMap.get(i).getNazwa())){
                this.daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().add(new Realizacja(kto,co,ile));
            }
        }
        try {
            String fileName = "src/Realizacja.csv";
            FileWriter writer = new FileWriter(fileName);
            writer.write("Kto;Co;ile;" + System.lineSeparator());
            for (int i = 0; i < daneMap.size(); i++) {
                for(int j=0; j<daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().size();j++){
                    writer.write(daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().get(j).getKto() + ";");
                    writer.write(daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().get(j).getCo() + ";");
                    writer.write(daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().get(j).getIle() + ";");
                }
                writer.write(System.lineSeparator());
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
