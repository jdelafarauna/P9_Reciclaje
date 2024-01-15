import java.util.Random;

public class Lata extends Residuo {

    private String fechaCaducidad;

    public Lata(){

        this.fechaCaducidad = generarFechaC();

    }

    private String generarFechaC(){

            return "15/02/2024";

    }

    public void mostrarCaducidad(){

        System.out.println("Fecha caducidad:" + this.fechaCaducidad);

    }

}
