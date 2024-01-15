import java.util.Scanner;
import java.util.ArrayList;

public class Maquina {

    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Residuo> reciclado;

    public static void main(String[] args) {

        usuarios = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do{
        System.out.println("---------------------");
        System.out.println("MAQUINA DE RECICLAJE");
        System.out.println("Seleccione su opcion:");
        System.out.println("1.- Identificarse.");
        System.out.println("2.- Crear nuevo usuario.");
        System.out.println("3.- Salir.");
        System.out.println("---------------------");
        System.out.println("Opcion: ");
        opcion = scanner.nextInt();

        switch (opcion){
            case 1: identificarse();
            break;
            case 2: crearNuevoUsuario();
            break;
            case 3:System.out.println("Cerrando programa. Hasra luego!");
            break;
        }
        }while(opcion != 0);
        scanner.close();

    }

    private static void identificarse(){

        System.out.println("Escriba su nombre:");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();

        for(int i = 0; i< usuarios.size(); i++){
            if(usuarios.get(i).getNombre().equals(nombre)){
               comienzoMaquina(usuarios.get(i));
            }
        }

    }

    private static void crearNuevoUsuario(){

        System.out.println("Escriba su nombre:");
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        Usuario usuario = new Usuario(nombre);
        comienzoMaquina(usuario);

    }
    private static void comienzoMaquina(Usuario usuario){

        System.out.println("---------------------");
        System.out.println("Bienvenido, " + usuario.getNombre());
        System.out.println("Su saldo acumulado es de " + usuario.getSaldo());
        System.out.println("Puede usarlo en cualquier tienda del centro comercial.");
        System.out.println("¿Quiere empezar a reciclar? S/N");
        Scanner scanner = new Scanner(System.in);
        String reciclar = scanner.nextLine();
        if((reciclar.equals("S"))|| (reciclar.equals("s"))){
            usuario.reciclar();
        }else{
            usuario.mostrarReciclado();
            mostrarRecicladoTotal();
        }
        System.out.println("---------------------");

    }

    private static void mostrarRecicladoTotal(){
        ArrayList<Residuo> totalReciclado = new ArrayList<>();
        if(!(usuarios.isEmpty())) {
            for (int i = 0; i < usuarios.size(); i++) {
                totalReciclado.addAll(usuarios.get(i).getReciclado());
            }
            System.out.println(totalReciclado.toString());
        }else{
            System.out.println("No hay ningun usuario registrado. \n0 residuos reciclados.(0 euros)");
        }
    }


}
