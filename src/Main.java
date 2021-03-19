
import java.util.Random;
import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static dice Dmg = new dice();
    public static String NazwaGracza;
    public static int HpGracza;
    public static int MaxHp;
    public static int MaxMana;
    public static int Mana;
    public static int DmgGracza;
    public static int xp;
    public static String NazwaPrzeciwnika;
    public static int HpPrzeciwnika;
    public static int DmgPrzeciwnika;
    public static int Level;
    public static String bron;
    public static String klasapostaci;
    public static boolean walka = false;







    private static void statystyki() {
        if(klasapostaci.equals("palladyn")){
            System.out.println(NazwaGracza + "\nhp: " + HpGracza + "\nMana: " + Mana + "\ndamage: " + DmgGracza + "\nxp: " + xp + "\n" + "broń: " + bron + "\n" + "klasa: " + klasapostaci + "\n");
        }
        if(klasapostaci.equals("zabojca")){
            System.out.println(NazwaGracza + "\nhp: " + HpGracza + "\nMana: " + Mana + "\ndamage: " + DmgGracza + "\nxp: " + xp + "\n" + "broń: " + bron +"\n" + "klasa: " + klasapostaci + "\n" );
        }
        if(klasapostaci.equals("mag")){
            System.out.println(NazwaGracza + "\nhp: " + HpGracza + "\nMana: " + Mana + "\ndamage: " + DmgGracza + "\nxp: " + xp + "\n" + "broń: " + bron +"\n" + "klasa: " + klasapostaci + "\n" );
        }
        if(klasapostaci.equals("wojownik")){
            System.out.println(NazwaGracza + "\nhp: " + HpGracza + "\nMana: " + Mana + "\ndamage: " + DmgGracza + "\nxp: " + xp + "\n" + "broń: " + bron +"\n" + "klasa: " + klasapostaci + "\n" );
            
        }
    }
    private static void StatystkiPrzeciwnika() {
        System.out.println( NazwaPrzeciwnika +"\nhp: " + HpPrzeciwnika + "\ndmg: " + DmgPrzeciwnika + "\n");
    }

    private static void  Wojownik() {
        klasapostaci = "wojownik";
        MaxHp = 20;
        HpGracza = 20;
        Mana = 20;
        MaxMana = 20;
        DmgGracza = 4;
        xp = 0;
        Level = 1;
        bron = "Mały Miecz";

    }
    private static void Mag() {
        klasapostaci = "mag";
        MaxHp = 10;
        HpGracza = 10;
        Mana = 20;
        MaxMana = 20;
        DmgGracza = 2;
        xp = 0;
        Level = 1;
        bron = "Mała pała";
    }
    private static void Palladyn() {
        klasapostaci = "palladyn";
        MaxHp = 10;
        HpGracza = 10;
        Mana = 30;
        MaxMana = 40;
        DmgGracza = 3;
        xp = 0;
        Level = 1;
        bron = "Mały boski miecz";
    }
    private static void Zabójca() {
        klasapostaci = "zabojca";
        MaxHp = 6;
        HpGracza = 10;
        Mana = 20;
        MaxMana = 20;
        DmgGracza = 4;
        xp = 0;
        Level = 1;
        bron = "Mały sztylet";
    }

    private static void Przeciwnik() {
        switch(Level){//przypadki na danego przeciwnika na pojawnienie się
            case 1:
                NazwaPrzeciwnika = "Damian Korah";
                HpPrzeciwnika = 9;
                DmgPrzeciwnika = 1;
                break;
            case 2:
                NazwaPrzeciwnika = "Anioł";
                HpPrzeciwnika = 19;
                DmgPrzeciwnika = 4;
                break;
            case 3:
                NazwaPrzeciwnika = "Demon";
                HpPrzeciwnika = 24;
                DmgPrzeciwnika = 6;
                break;
            case 4:
                NazwaPrzeciwnika = "Patus Patiro";
                HpPrzeciwnika = 32;
                DmgPrzeciwnika = 7;
                break;
            case 5:
                NazwaPrzeciwnika = "Szef Tartaglia";
                HpPrzeciwnika = 40;
                DmgPrzeciwnika = 9;
                break; //statystyki przeciwnika w zależności od ich poziomu postaci


        }
    }
    private static void fight() {
        String action;
        String Spell = null;

        System.out.println("Trafiłeś na przeciwnika!");
        Przeciwnik();
        walka = true;
        while(walka = true){
            System.out.println("Naciśnij 'a' żeby zaatakować\nNaciśnij 'i' żeby wyświetlić info");
            if(klasapostaci.equals("mag")){
                System.out.print("Naciśnij 's' żeby użyć umiejętnośći\n");
            }
            if(klasapostaci.equals("wojownik")){
                System.out.print("Naciśnij 'b' żeby użyć umiejętnośći\n");
            }
            if(klasapostaci.equals("palladyn")){
                System.out.print("Naciśnij 'v' żeby użyć umiejętnośći\n");
            }
            if(klasapostaci.equals("zabójca")){
                System.out.print("Naciśnij 'x' żeby użyć umiejętnośći\n");
            }
            action = scan.nextLine();
            if(action.charAt(0) == 'a'){
                walka = attack();
                if(walka == false){
                    switch(Level){
                        case 1:
                            xp = xp + 4;
                            break;
                        case 2:
                            xp = xp + 6;
                            break;
                        case 3:
                            xp = xp + 9;
                            break;
                        case 4:
                            xp = xp + 12;
                            break;
                    }
                    System.out.println("Zdobyłeś :" + xp + " xp");
                    LevelUp();
                    return;
                }
                AtakEnemy();
            }

            if(action.charAt(0) == 'i'){
                statystyki();
                StatystkiPrzeciwnika();

            }
            if(action.charAt(0) == 'v') {
                System.out.println("naciśnij 'u' żeby się uleczyć\n");
                Spell = scan.nextLine();
                if (Spell.charAt(0) == 'n') {
                    if (Dmg.roll10() > 2) {
                        Mana = Mana - 10;
                        if (Mana < 0) {
                            System.out.println("Nie masz wystarczająco many!");
                            Mana = Mana + 10;
                            System.out.println("Twoja mana została odnowiona o 10!");
                        } else {
                            int k = Dmg.roll10(); //Wybiera randomowy dmg od 1 do 10
                            System.out.println("Udeżyłeś za " + k + " obrażeń!");
                            HpPrzeciwnika = HpPrzeciwnika - k;
                            if (HpPrzeciwnika <= 0) {
                                System.out.println("Wygrałeś!");
                                switch (Level) {
                                    case 1:
                                        xp = xp + 4;
                                        break;
                                    case 2:
                                        xp = xp + 6;
                                        break;
                                    case 3:
                                        xp = xp + 9;
                                        break;
                                    case 4:
                                        xp = xp + 12;
                                        break;
                                }

                                System.out.println("You earned :" + xp + " xp");
                                LevelUp();
                                return;
                            }
                            AtakEnemy();
                        }
                    } else {
                        System.out.println("Nie trafiłeś!");
                        AtakEnemy();
                    }
                } else if (Spell.charAt(0) == 'u') {
                    Mana = Mana - 8;
                    if (Mana < 0) {
                        System.out.println("Nie masz wystarczająco many!");
                        Mana = Mana + 8;
                        System.out.println("Twoja mana została odnowiona o 8!");
                    } else {
                        int x = Dmg.roll10(); //healuje randomowo  1-8
                        System.out.println("Wyleczyłeś się!");
                        System.out.println("+ " + x + " hp");
                        HpGracza = HpGracza + x;
                        if (HpGracza > MaxHp) {
                            HpGracza = MaxHp;
                        }
                        AtakEnemy();
                    }
                }
            }
            if(action.charAt(0) == 's'){
                System.out.println("Naciśnij 'f' żeby użyć fireball'a\n");
                Spell = scan.nextLine();
                if(Spell.charAt(0) == 'f'){
                    if(Dmg.roll10() > 2){
                        Mana = Mana - 10;
                        if(Mana <0){
                            System.out.println("Nie masz wystarczająco many!");
                            Mana = Mana + 10;
                            System.out.println("Twoja mana została odnowiona o 10!");
                        }

                        else{
                            int k = Dmg.roll10(); //Wybiera randomowy dmg od 1 do 10
                            System.out.println("Udeżyłeś za " + k + " obrażeń!");
                            HpPrzeciwnika = HpPrzeciwnika - k;
                            if(HpPrzeciwnika <= 0){
                                System.out.println("Wygrałeś!");
                                switch(Level){
                                    case 1:
                                        xp = xp + 4;
                                        break;
                                    case 2:
                                        xp = xp + 6;
                                        break;
                                    case 3:
                                        xp = xp + 9;
                                        break;
                                    case 4:
                                        xp = xp + 12;
                                        break;
                                }

                                System.out.println("You earned :" + xp + " xp");
                                LevelUp();
                                return;
                            }
                            AtakEnemy();
                        }
                    }
                    else{
                        System.out.println("Nie trafiłeś!");
                        AtakEnemy();
                    }
                }else
                if(Spell.charAt(0) == 'u'){
                    Mana = Mana - 8;
                    if(Mana <0){
                        System.out.println("Nie masz wystarczająco many!");
                        Mana = Mana + 8;
                        System.out.println("Twoja mana została odnowiona o 8!");
                    }else{
                        int x = Dmg.roll10(); //healuje randomowo  1-8
                        System.out.println("Wyleczyłeś się!");
                        System.out.println("+ " + x + " hp");
                        HpGracza = HpGracza + x;
                        if(HpGracza>MaxHp){
                            HpGracza = MaxHp;
                        }
                        AtakEnemy();
                    }
                }

            }
            if(action.charAt(0) == 'b'){
                System.out.println("Naciśnij 's' żeby użyć szarży\n");
                Spell = scan.nextLine();
                if(Spell.charAt(0) == 's'){
                    if(Dmg.roll10() > 2){
                        Mana = Mana - 10;
                        if(Mana <0){
                            System.out.println("Nie masz wystarczająco many!");
                            Mana = Mana + 10;
                            System.out.println("Twoja mana została odnowiona o 10!");
                        }

                        else{
                            int k = Dmg.roll10(); //Wybiera randomowy dmg od 1 do 10
                            System.out.println("Udeżyłeś za " + k + " obrażeń!");
                            HpPrzeciwnika = HpPrzeciwnika - k;
                            if(HpPrzeciwnika <= 0){
                                System.out.println("Wygrałeś!");
                                switch(Level){
                                    case 1:
                                        xp = xp + 4;
                                        break;
                                    case 2:
                                        xp = xp + 6;
                                        break;
                                    case 3:
                                        xp = xp + 9;
                                        break;
                                    case 4:
                                        xp = xp + 12;
                                        break;
                                }

                                System.out.println("You earned :" + xp + " xp");
                                LevelUp();
                                return;
                            }
                            AtakEnemy();
                        }
                    }
                    else{
                        System.out.println("Nie trafiłeś!");
                        AtakEnemy();
                    }

                }
            }

        }
    }

    private static void LevelUp() {
        if(xp >= 100 && Level == 4){
            System.out.println("Level 5!");
            Level = Level + 1;
            MaxHp = MaxHp + 25;
            HpGracza = MaxHp;
            if(klasapostaci.equals("mag")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Mega kurewsko wielka pałą";
            }
            if(klasapostaci.equals("wojownik")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Mega kurewsko wielki miecz";
            }
            if(klasapostaci.equals("palladyn")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Mega kurewsko wielki boski miecz";
            }
            if(klasapostaci.equals("zabojca")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Mega kurewsko wielki sztylet";
            }
            DmgGracza = DmgGracza + 3;
            statystyki();
        }else
        if(xp >= 50 && Level == 3){
            System.out.println("Level 4!");
            Level = Level + 1;
            MaxHp = MaxHp + 20;
            HpGracza = MaxHp;
            if(klasapostaci.equals("mag")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Kurewsko wielka pałą";
            }
            if(klasapostaci.equals("wojownik")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Kurewsko wielki miecz";
            }
            if(klasapostaci.equals("palladyn")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Kurewsko wielki boski miecz";
            }
            if(klasapostaci.equals("zabojca")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Kurewsko wielki sztylet";
            }
            DmgGracza = DmgGracza + 2;
            statystyki();
        }else
        if(xp >= 25 && Level == 2){
            System.out.println("Level 3!");
            Level = Level + 1;
            MaxHp = MaxHp + 10;
            HpGracza = MaxHp;
            if(klasapostaci.equals("mag")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Wielka pałą";
            }
            if(klasapostaci.equals("wojownik")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Wielki miecz";
            }
            if(klasapostaci.equals("palladyn")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Wielki boski miecz";
            }
            if(klasapostaci.equals("zabojca")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Wielki sztylet";
            }
            DmgGracza = DmgGracza + 2;
            statystyki();
        }else
        if(xp >= 10 && Level == 1){
            System.out.println("Level 2!");
            Level = Level + 1;
            MaxHp = MaxHp + 5;
            HpGracza = MaxHp;

            if(klasapostaci.equals("mag")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Pała";
            }
            if(klasapostaci.equals("wojownik")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Miecz";
            }
            if(klasapostaci.equals("palladyn")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Boski miecz";
            }
            if(klasapostaci.equals("zabojca")){
                MaxMana = MaxMana + 7;
                Mana = MaxMana;
                bron = "Sztylet";
            }
            DmgGracza = DmgGracza + 1;
            statystyki();
        }//Dodaje statystki wraz z rosnącym levelem

    }
    private static void AtakEnemy() {
        if(Dmg.roll6() > 2){
            System.out.println("Przeciwnik trafił!");
            HpGracza = HpGracza - DmgPrzeciwnika;
            if(HpGracza <= 0){
                gameover();
                System.exit(0);//Gra się kończy wraz z hp  < 0
            }
        }else{
            System.out.println("Przeciwnik nie trafił!");
        }
    }
    private static boolean attack() {
        if(Dmg.roll6() > 2){
            System.out.println("Trafiłeś!");
            HpPrzeciwnika = HpPrzeciwnika - DmgGracza;
            if(HpPrzeciwnika <= 0){
                System.out.println("Wygrałeś!"); //Wyświetla się napis jeśli hp przeciwnika < 0
                return false;
            }
        }else{
            System.out.println("Nie trafiłeś!");
        }
        return true;
    }

    private static void gameover() {
        System.out.println(NazwaGracza + " Gratulacje! nie żyjesz") ;
        System.exit(0); //koniec jeśli przegrałeś
        return;
    }
    public static void main(String[] args) {
        String klasapostaci;
        int num = 2;
        while(num > 1){
            System.out.println("Dungeon RPG!\n ");
            System.out.println("Rozpocznij swoją przygodę!\n ");
            System.out.println("Podaj swoje imię: ");
            NazwaGracza = scan.nextLine();
            System.out.println("Wybierz klase: ");
            System.out.println("'w' = Wojownik");
            System.out.println("'m' = Mag");
            System.out.println("'p' = Palladyn");
            System.out.println("'z' = Zabójca");
            klasapostaci = scan.nextLine();
            while(klasapostaci.charAt(0) != 'w' && klasapostaci.charAt(0) != 'a' && klasapostaci.charAt(0) != 'm'  && klasapostaci.charAt(0) != 'z'  && klasapostaci.charAt(0) != 'p'){
                System.out.println("'w' = wojownika");
                System.out.println("'m' = Maga");
                System.out.println("'p' = Palladyn");
                System.out.println("'z' = Zabójca");
                klasapostaci = scan.nextLine();
            }
            if(klasapostaci.charAt(0) == 'w'){
                Wojownik();
            }
            if(klasapostaci.charAt(0) == 'm'){
                Mag();
            }
            if(klasapostaci.charAt(0) == 'p'){
                Palladyn();
            }
            if(klasapostaci.charAt(0) == 'z'){
                Zabójca();
            }
            statystyki();
            while(Level == 1){
                fight();
            }
            System.out.println("Pokonałeś przeciwnika, Idź dalej\n");
            while(Level == 2){
                fight();
            }
            System.out.println("Pokonałeś przeciwnika, Idź dalej!\n");
            while(Level == 3){
                fight();
            }
            System.out.println("Pokonałeś przeciwnika, Idź dalej!\n");
            while(Level == 4){
                fight();
            }
            System.out.println("Pokonałeś przeciwnika, Idź dalej!\n");
            while(Level == 5){
                fight();
            }//
        }

    }
}




class dice {

    public int roll6(){
        Random rand = new Random();
        int a = rand.nextInt(7);
        while(a == 0){
            a = rand.nextInt(7);
        }//1-6
        return a;
    }
    public int roll10(){
        Random rand = new Random();
        int a = rand.nextInt(11);
        while(a == 0){
            a = rand.nextInt(11);
        }
        return a;
    }//1-10
    public int roll20(){
        Random rand = new Random();
        int a = rand.nextInt(21);
        while(a == 0){
            a = rand.nextInt(21);
        }//1-20
        return a;
    }

}