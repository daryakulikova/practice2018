import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class MyMatrix implements Serializable{

    public MyMatrix(){}

//    private List<List<Double>> data;
    private double[][] data;
    private int mat_size;


    public int getMat_size() {
        return mat_size;
    }

    public void setMat_size(int mat_size) {
        this.mat_size = mat_size;
    }

    public double[][] getData() {
        return data;
    }

    public void setData(double[][] data) {
        this.data = data;
    }
}
