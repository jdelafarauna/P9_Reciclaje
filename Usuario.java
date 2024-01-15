
import java.util.Scanner;
import java.util.ArrayList;
public class Usuario {

    private String nombre;
    private double saldo;
    private ArrayList<Residuo> reciclado;

    public Usuario(String nombre){

        this.nombre = nombre;
        this.saldo = 0;
        this.reciclado = new ArrayList<>();

    }

    public String getNombre(){

        return this.nombre;

    }

    public double getSaldo() {
        return saldo;
    }

    public void aumentarSaldo(double incremento){

        this.saldo += incremento;

    }

    public void reciclar() {
        char residuo;
        Residuo envase = null;
        do {
            System.out.println("¿Que va a reciclar?");
            System.out.println("(L) lata, (B)botella o (V) vidrio");
            Scanner scanner = new Scanner(System.in);
            residuo = scanner.next().charAt(0);
            residuo = Character.toUpperCase(residuo);
            switch (residuo) {
                case 'L':
                    envase = new Lata();
                    break;
                case 'B':
                    envase = new Botella();
                    break;
                case 'V':
                    envase = new Vidrio();
                    break;
            }
            scanner.close();
        } while (residuo == 'L' || residuo == 'B' || residuo == 'V');

        if (envase instanceof Lata) {

            this.reciclado.add(envase);
            System.out.println("Acaba de reciclar una lata y obtener 0.1 euros");
            this.aumentarSaldo(0.1);


        }else if(envase instanceof Botella){
            this.reciclado.add(envase);   // no importa el tamaño
            Scanner scanner = new Scanner(System.in);
            char capacidad = scanner.next().charAt(0);
            capacidad = Character.toUpperCase(capacidad);
            if (capacidad == 'G'){

                System.out.println("Acaba de reciclar una botella grande y obtener 0.2 euros");
                this.aumentarSaldo(0.2);
            }else if (capacidad == 'P'){
                System.out.println("Acaba de reciclar una botella pequeña y obtener 0.15 euros");
                this.aumentarSaldo(0.15);
            }

        }else if(envase instanceof Vidrio){

            this.reciclado.add(envase);
            System.out.println("Acaba de reciclar un vidrio y obtener 0.3 euros");
            this.aumentarSaldo(0.3);

        }

    }

    public ArrayList<Residuo> getReciclado(){
        return this.reciclado;

    }

    public void mostrarReciclado(){
        System.out.println(reciclado.toString());
    }

}
