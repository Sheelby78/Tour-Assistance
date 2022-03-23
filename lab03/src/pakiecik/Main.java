package pakiecik;

import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Organizator o = new Organizator();
        Animator a = new Animator();
        Uczestnik u = new Uczestnik();
        System.out.println(" Witaj w systemie planowania wydarzeń");
        System.out.println(" Wybierz swoją rolę");
        System.out.print(" [1] Organizator\n [2] Animator\n [3] Uczestnik\n");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if(i==1) {
            System.out.println("Wybierz numer działania: ");
            System.out.print(" [1] Wyswietl liste wydarzen\n [2] Edycja wydarzenia\n [3] Tworzenie wydarzenia\n [4] Wyswietl liste uczestnikow wydarzenia\n ");
            int j = scanner.nextInt();
            if(j==1){
                o.viewList();
            }
            if(j==2){
                System.out.println("Podaj nazwe wydarzenia do edycji: ");
                Scanner sc2 = new Scanner(System.in);
                String id = sc2.nextLine();
                System.out.println("Podaj jaki element chcesz edytować: ");
                String co = sc2.nextLine();
                System.out.println("Podaj nową wartość: ");
                String naco = sc2.nextLine();
                o.editEvents(id,co,naco);
            }
            if(j==3){
                o.createEvent();
            }
            if(j==4){
                Scanner sc6 = new Scanner(System.in);
                System.out.println("Podaj nazwe eventu z ktorego chcesz wyswietlic uczestnikow: ");
                String id = sc6.nextLine();
                o.listaUczestników(id);
            }
        }
        if(i==2){
            System.out.println("Wybierz numer działania: ");
            System.out.print(" [1] Wyswietl liste propozycji realizacji zapotrzebowania\n [2] Dodaj zapotrzebowanie do wydarzenia\n");
            int k = scanner.nextInt();
            if(k==1){
                System.out.println("Podaj nazwe wydarzenia do wyswietlenia propozycji realizacji zapotrzebowania: ");
                Scanner sc7 = new Scanner(System.in);
                String id = sc7.nextLine();
                a.viewListZap(id);
            }
            if(k==2){
                Scanner sc = new Scanner(System.in);
                System.out.println("Podaj nazwe wydarzenia do ktorego chcesz dodac zapotrzebowanie: ");
                String here = sc.nextLine();
                System.out.println("Podaj nazwe zapotrzebowania: ");
                String name = sc.nextLine();
                System.out.println("Podaj wymagana ilosc zapotzrebowania: ");
                int quantityMax = sc.nextInt();
                int quantityNow = 0;
                a.createList(here,name,quantityMax,quantityNow);
            }

        }
        if(i==3){
            System.out.println("Wybierz numer działania: ");
            System.out.print(" [1] Wyswietl liste wydarzen\n [2] Zglos udzial w wydarzeniu\n [3] Wyswietl liste zaptrzebowania\n [4] Zglos propozycje realizacji zapotrzebowania\n");
            int s = scanner.nextInt();
            if(s==1){
                u.viewList();
            }
            if(s==2){
                Scanner sc3 = new Scanner(System.in);
                System.out.println("Podaj nazwe wydarzenia do ktorego chcesz sie zpisac: ");
                String event = sc3.nextLine();
                System.out.println("Podaj swoje imie i nazwisko: ");
                String imieNazwisko = sc3.nextLine();
                u.selectEvent(event, imieNazwisko);
            }
            if(s==3){
                Scanner sc4 = new Scanner(System.in);
                System.out.println("Podaj nazwe wydarzenia do ktorego chcesz wyswietlic liste zapotrzebowania: ");
                String event = sc4.nextLine();
                u.viewListZap(event);
            }
            if(s==4){
                Scanner sc5 = new Scanner(System.in);
                System.out.println("Podaj nazwe wydarzenia do ktorego chcesz zglosic propozycje: ");
                String event = sc5.nextLine();
                System.out.println("Podaj swoje imie i nazwisko");
                String kto = sc5.nextLine();
                System.out.println("Podaj co przyniesiesz: ");
                String co = sc5.nextLine();
                System.out.println("Podaj ile przyniesiesz: ");
                int ile = sc5.nextInt();
                u.zglosRealizacje(event,kto,co,ile);
            }
        }



    }
}
