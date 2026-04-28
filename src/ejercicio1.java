static String a;
static boolean verificar = true;
static boolean jugar = true;
static MONEDA moneda;
static Scanner s = new Scanner(System.in);

enum MONEDA {
    CARA,
    CRUZ
}

void main() {
    do {
        moneda = tirarMoneda();
        ingresarDato();
        logicaJuego();
    } while (jugar);
}

public static void ingresarDato() {
    do {
        IO.println("CARA o CRUZ?");
        a = s.nextLine().toUpperCase();
        if (a.equals("CARA") || a.equals("CRUZ")) {
            verificar = true;
        } else {
            verificar = false;
            IO.println("Tipo de dato mal ingresado");
        }
    } while (!verificar);
}

public static void logicaJuego() {
    MONEDA eleccion = MONEDA.valueOf(a);

    if (eleccion == moneda) {
        IO.println("Ganaste, era " + moneda);
    } else {
        IO.println("Perdiste, era " + moneda);
    }

    IO.println("Volver a jugar? (si o no)");
    a = s.nextLine();
    jugar = a.equals("si");
}

public static MONEDA tirarMoneda() {
    Random r = new Random();
    int lado = r.nextInt(2);

    return (lado == 0) ? MONEDA.CARA : MONEDA.CRUZ;
}