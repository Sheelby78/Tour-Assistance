package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Animator {

    Dane dane = new Dane();
    List<Event> daneMap = dane.getDaneMap();

    public void createList(String id, String name, int quantityMax, int quantityNow){
        List<Realizacja> propozycje = new ArrayList<>();
        for(int i=0;i<daneMap.size();i++){
            if(id.equals(daneMap.get(i).getNazwa())){
                this.daneMap.get(i).getZapotrzebowanie().add(new Inventory(name, quantityMax, quantityNow, propozycje));
            }
        }
        try {
            String fileName = "src/Zapotrzebowanie.csv";
            FileWriter writer = new FileWriter(fileName);
            writer.write("Item;quantityMax;quantityNow;" + System.lineSeparator());
            for (int i = 0; i < daneMap.size(); i++) {
                for(int j=0; j<daneMap.get(i).getZapotrzebowanie().size();j++){
                writer.write(daneMap.get(i).getZapotrzebowanie().get(j).getName() + ";");
                writer.write(daneMap.get(i).getZapotrzebowanie().get(j).getQuantityMax() + ";");
                writer.write(daneMap.get(i).getZapotrzebowanie().get(j).getQuantityNow() + ";");
                }
                writer.write(System.lineSeparator());
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewListZap(String id){
        for(int i=0;i<daneMap.size();i++){
            if(id.equals(daneMap.get(i).getNazwa())){
                        System.out.println("Kto | Co | Ile |");
                        System.out.println();
                for(int j=0;j< daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().size();j++){
                    System.out.print(daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().get(j).getKto() + " | ");
                    System.out.print(daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().get(j).getCo() + " | ");
                    System.out.print(daneMap.get(i).getZapotrzebowanie().get(i).getPropozycje().get(j).getIle() + " | \n");

                }
            }
        }
    }
}
