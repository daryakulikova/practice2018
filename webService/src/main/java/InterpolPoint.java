import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class InterpolPoint implements Serializable{
    public InterpolPoint(){}
    public InterpolPoint(double[] x, double[] y){
        this.x_mas=x;
        this.y_mas=y;
    }

    private double[] x_mas;
    private double[] y_mas;


    public double[] getX_mas() {
        return x_mas;
    }

    public void setX_mas(double[] x_mas) {
        this.x_mas = x_mas;
    }

    public double[] getY_mas() {
        return y_mas;
    }

    public void setY_mas(double[] y_mas) {
        this.y_mas = y_mas;
    }
}
