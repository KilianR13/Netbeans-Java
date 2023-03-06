package figuras;

public class Circulo {

    private Punto centro;
    private double radio;

    public Circulo(){
        this(0,0,0);
    }

    public Circulo(Punto p, double radio){
        this(p.getX(), p.getY(), radio);
    }
    
    public Circulo(double origen_x, double origen_y, double radio){
        if(radio<0){
            throw new IllegalArgumentException("El radio debe ser mayor o igual que 0");
        }
        this.centro = new Punto(origen_x, origen_y);
        this.radio = radio;
    }
        
    public Circulo(Circulo c){
//        this.centro = new Punto(c.centro);
//        this.radio = c.radio;
        this(c.centro.getX(), c.centro.getY(), c.radio);
    }

    public Punto getCentro() {
        return new Punto(centro);
    }

    public void setCentro(Punto centro) {
        this.centro = new Punto(centro);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        if(radio>=0)
            this.radio = radio;
    }
    
    public double getArea(){
        return Math.PI*this.radio*this.radio;
    }
    
    public double getCircunferencia(){
        return 2*Math.PI*this.radio;
    }

    @Override
    public String toString() {
        return "[" + centro + "\t, radio=" + radio + "]";
    }
    
    public boolean equals(Circulo c){
        return this.radio==c.radio && this.centro.equals(c.centro);
    }
    
}
