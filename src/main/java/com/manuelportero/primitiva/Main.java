package com.manuelportero.primitiva;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int cant1=0;
    static int cant2=0;
    public static Scanner lector = new Scanner(System.in);
    public static Bombo bombo = new Bombo();
    public static Boleto boleto = new Boleto();
    public static  Game game=new Game();
    /**
     * Bucle principal donde se llama a los menú. Pide si quiere jugar con números aleatorios o introducidos manualmente. Seguidamente,
     * solicita los numeros en caso de que sean introducidos manualmente. Para finalizar muestra un segundo menú con las modalidades a elegir.
     * @param args
     */
    public static void main(String[] args) {
        String boletoUsuario=" ";
        String boletoGanador=" ";
        int[] num = new int[6];
        int numLector;
        boolean valido;
        do {
            menuPrimitiva();
            numLector = lector.nextInt();
            lector.nextLine();
            switch (numLector) {
                case 1:
                    for (int i = 1; i < num.length + 1; i++) {
                        System.out.println("Introduce tu numero " + i + " de la suerte:");
                        boleto.rellenarBoleto(lector.nextInt(), i-1);
                        lector.nextLine();
                    }
                    System.out.println("Este es tu numero de la suerte:");
                    boletoUsuario=boleto.combinarValoresUsuario();
                    System.out.println(boletoUsuario);


                    break;

                case 2:
                    boletoUsuario = boleto.crearBoletoUsuarioAleatorio();
                    boletoGanador = bombo.combinarValores();


                    break;
                default:
                    System.out.println("ERROR. INTRODUCE UN CARACTER VALIDO");
                    break;
            }
            }while (numLector != 1 && numLector != 2);
            do {
                menuModalidad();
                numLector = lector.nextInt();
                lector.nextLine();
                switch (numLector) {
                    case 1:
                        /*Jugaremos a un único sorteo y al finalizar mostrará la
                        combinación ganadora y si hemos obtenido algún premio.*/
                        System.out.println(Arrays.toString(boletoGanador.toCharArray()));
                        System.out.println(Arrays.toString(boletoUsuario.toCharArray()));
                        System.out.println(Arrays.toString(game.comprobarJuegoUnico(boletoGanador,boletoUsuario)));
                        break;
                    case 2:
                        /*El programa realizará varios sorteos hasta
                        que obtengamos algún tipo de premio (reintegro incluido)*/
                        break;
                    case 3:
                        /*El programa realizará
                        varios sorteos hasta que obtengamos algún tipo de premio (reintegro
                        excluido).*/
                        break;
                    case 4:
                        /*El programa realizará un ciclo de 10000 sorteos
                        y al final mostrará un resumen de los premios obtenidos de cada categoría*/
                        break;
                    case 5:
                        /*El programa jugará
                        sorteos hasta obtener un premio de la categoría especial. Al final mostrará
                        la combinación ganadora y el número de sorteos jugados hasta alcanzar el
                        premio.
                        */
                        break;
                    case 0:
                        //vuelve hacia atras
                        return;
                    default:
                        System.out.println("ERROR. INTRODUCE UN CARACTER VALIDO");
                        break;
                }
            }while(numLector > 5 || numLector < 0);

    }

    /**
     * Primer menu de la primitiva. Solo muestra por pantalla si desea introducir tus numeros de la suerte manuelmente o
     * de forma aleatoria.
     */
    public static void menuPrimitiva(){
        System.out.println("********************");
        System.out.println("** MENU PRIMITIVA **");
        System.out.println("********************");
        System.out.println("<<Desea introducir tus numeros de la suerte manuelmente?>>");
        System.out.println("------------------------------------------------------");
        System.out.println("1.-Si, deseo introducirlos.");
        System.out.println("2.-No, deseo que sean aleatorios.");
    }

    /**
     * Segundo menu. Solo muestra por pantalla las diferentes modalidades de juego que hay y el numero a introducir para
     * seleccionar cada una de ellas.
     */
    public static void menuModalidad(){
        System.out.println("********************");
        System.out.println("** MENU MODALIDAD **");
        System.out.println("********************");
        System.out.println("---------------------");
        System.out.println("1.-Juego único.");
        System.out.println("2.-Jugar hasta obtener premio..");
        System.out.println("3.-Jugar hasta obtener premio (sin reintegro).");
        System.out.println("4.-Ciclo de 10k sorteos.");
        System.out.println("5.-Jugar hasta obtener premio categoría especial.");
        System.out.println("0.-Volver al menú primitiva.");
    }
}



