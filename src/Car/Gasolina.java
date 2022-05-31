package Car;

public class Gasolina {
    private double gasolina;
    private boolean vazio;
    public Gasolina(){
        setDafaultValues();
    }
    private void setDafaultValues(){
        this.gasolina = 100;
        this.vazio = false;
    }
    public boolean isNotVazio(){
        return !this.vazio;
    }

    public double getGasolina(){
        return this.gasolina;
    }


    public void setGasolina(double quantidade){
        if(this.gasolina + quantidade <= 100){
            this.gasolina += quantidade;
        }
        this.vazio = !(this.gasolina > 0);
    }
}
