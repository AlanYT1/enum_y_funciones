
static Scanner leer = new Scanner(System.in);

enum RESULTADO{
    MAYOR,
    MENOR,
    IGUAL
}


void main() {
//    Realizar un juego en el cual adivinas el numero de la pc,
//    este numero se genera al azar y tienes máximo 10 intentos para adivinarlo,
//    ingresas un numero y si es mayor o menor
    int numsecret = numero();
    jugar(numsecret);

}

public static int numero(){
    Random r = new Random();
    return r.nextInt(100) + 1; //se utiliza r.nextInt(100) + 1 ya que puede devolver 0 y con el +1 devuelve ese 1, y tambien pq llega hasta 99 y con el +1 llega a 100
}

public static void jugar(int numsecret){
    int intentos = 0;
    boolean adivinar = false;

    IO.println("Adivine el numero secreto");
    IO.println("Tiene 10 intentos para adivinar");
    while(intentos < 10 && !adivinar){
        IO.println("Ingrese un numero del 1 al 100 ");
        int numuser = leer.nextInt();
        if (numuser >= 1 && numuser <= 100) {
            RESULTADO resultado = verificar(numuser, numsecret);
            intentos++;
            IO.println("Intento: " + intentos);

            switch (resultado) {
                case MAYOR:
                    IO.println("El numero secreto es menor");
                    break;
                case MENOR:
                    IO.println("El numero secreto es mayor");
                    break;
                case IGUAL:
                    IO.println("Ganaste en " + intentos + " intento");
                    adivinar = true;
                    break;
            }
        }else{
            IO.println("Ingrese un numero valido");
        }
    }
    if (!adivinar) {
        IO.println("Perdiste te pasaste de 10 intentos. El numero era " + numsecret);
    }
}

public static RESULTADO verificar(int numuser, int numsecret){
    if (numuser > numsecret){
        return RESULTADO.MAYOR;
    }else if (numuser < numsecret){
        return RESULTADO.MENOR;
    }else{
        return RESULTADO.IGUAL;
    }
}