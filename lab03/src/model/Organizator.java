package model;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Organizator {

    Dane dane = new Dane();
    List<Event> daneMap = dane.getDaneMap();

    public void viewList() {
        System.out.println("Nazwa | Opis | Data | Deadline");
        System.out.println();
        for (int i = 0; i < daneMap.size(); i++) {
            System.out.print(daneMap.get(i).getNazwa() + " | ");
            System.out.print(daneMap.get(i).getOpis() + " | ");
            System.out.print(daneMap.get(i).getData() + " | ");
            System.out.print(daneMap.get(i).getDeadline() + "\n");
        }
    }

    public void createEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę nowego wydareznia:\n");
        String nazwa = scanner.nextLine();
        System.out.println("Podaj opis do nowego wydarzenia:\n");
        String opis = scanner.nextLine();
        System.out.println("Podaj date nowego wydarzenia: \n");
        String data = scanner.nextLine();
        System.out.println("Podaj termin nowego wydarzenia:\n");
        String deadline = scanner.nextLine();
        List<String> uczestnicy = new ArrayList<>();
        List<Inventory> zapotrzebowanie = new ArrayList<>();
        this.daneMap.add(new Event(nazwa, opis, data, deadline, uczestnicy, zapotrzebowanie));

        try {
            String fileName = "src/Dane.csv";
            FileWriter writer = new FileWriter(fileName);
            writer.write("Nazwa;Opis;Data;Deadline;" + System.lineSeparator());
            for (int i = 0; i < daneMap.size(); i++) {
                writer.write(daneMap.get(i).getNazwa() + ";");
                writer.write(daneMap.get(i).getOpis() + ";");
                writer.write(daneMap.get(i).getData() + ";");
                writer.write(daneMap.get(i).getDeadline() + ";" + System.lineSeparator());
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void editEvents(String id, String co, String naco) {
        for (int i = 0; i < daneMap.size(); i++) {
            if (id.equals(daneMap.get(i).getNazwa())) {
                if (co.equals("Nazwa")) {
                    daneMap.get(i).setNazwa(naco);
                }
                if (co.equals("Opis")) {
                    daneMap.get(i).setOpis(naco);
                }
                if (co.equals("Data")) {
                    daneMap.get(i).setData(naco);
                }
                if (co.equals("Deadline")) {
                    daneMap.get(i).setDeadline(naco);
                }
            }
        }
        try {
            String fileName = "src/Dane.csv";
            FileWriter writer = new FileWriter(fileName);
            writer.write("Nazwa;Opis;Data;Deadline;" + System.lineSeparator());
            for (int i = 0; i < daneMap.size(); i++) {
                writer.write(daneMap.get(i).getNazwa() + ";");
                writer.write(daneMap.get(i).getOpis() + ";");
                writer.write(daneMap.get(i).getData() + ";");
                writer.write(daneMap.get(i).getDeadline() + ";" + System.lineSeparator());
            }

            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void listaUczestników(String id) {
        for (int i = 0; i < daneMap.size(); i++) {
            if (id.equals(daneMap.get(i).getNazwa()))
                for (int j = 0; j < daneMap.get(i).getUczestnicy().size(); j++) {
                    System.out.println(daneMap.get(i).getUczestnicy().get(j));
                }
        }
    }
}
