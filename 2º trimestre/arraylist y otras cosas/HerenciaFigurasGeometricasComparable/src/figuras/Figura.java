
package figuras;


public abstract class Figura implements Comparable<Figura>{
    
    public Figura(){
        
    }
    
    public double area(){
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); 
    }

    @Override
    public int compareTo(Figura o) {
        return (int) (this.area() - o.area());
    }

    



    
    
}
