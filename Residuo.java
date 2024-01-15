import java.util.Random;

public class Residuo {

    private float peso;

    public Residuo(){

        Random random = new Random();
        this.peso = random.nextInt(1 - 0 + 1) + 0;

    }

    public double getPeso(){
        return this.peso;
    }

}
