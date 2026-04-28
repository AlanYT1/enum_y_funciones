static String a;
static boolean jugar = true;
static boolean verificar;
static PPT ppt;
static Scanner s = new Scanner(System.in);

enum PPT {
    PIEDRA,
    PAPEL,
    TIJERA
}

void main() {
//    Realizar un juego de piedra papel o tijeras utilizando ENUM y Funciones
    do {
        ppt = elegirmano();
        ingresarDato();
        logicaJuego();
    }while(jugar);
}

public static void ingresarDato() {
    do {
        IO.println("Piedra, Papel o Tijera");
        a = s.nextLine().toUpperCase();
        if (a.equals("PIEDRA") || a.equals("PAPEL") || a.equals("TIJERA")) {
            verificar = true;
        } else {
            verificar = false;
            IO.println("Tipo de dato mal ingresado");
        }
    } while (!verificar);
}

public static void logicaJuego() {
    PPT eleccion = PPT.valueOf(a);

    if (eleccion == ppt){
        IO.println("Empataron");
    } else if (
            (eleccion == PPT.TIJERA && ppt == PPT.PAPEL)||
            (eleccion == PPT.PAPEL && ppt == PPT.PIEDRA)||
            (eleccion == PPT.PIEDRA && ppt == PPT.TIJERA)
    ){
        IO.println("Ganaste, la maquina eligio " + ppt);
    }else{
        IO.println("Perdiste, la maquina eligio " + ppt);
    }

    IO.println("Volver a jugar? (si o no)");
    a = s.nextLine();
    jugar = a.equals("si");
}

public static PPT elegirmano() {
    Random r = new Random();
    int manos = r.nextInt(3);

    if (manos == 0){
        return PPT.PIEDRA;
    }else if (manos == 1){
        return PPT.PAPEL;
    }else{
        return PPT.TIJERA;
    }
}