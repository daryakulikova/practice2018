
import Db.DBOperations;
import Entities.CalculatorEntity;
import Entities.IntegrationEntity;
import Entities.SlauEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/service")
public class WebService {

    private DBOperations dbOperations;

    public WebService(){
        dbOperations = new DBOperations();
    }

    @Path("/slau")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response Slau(MyMatrix matrix) {
        SolutionSLAU solutionSLAU = new SolutionSLAU();

        String equations = "";
        Integer size=matrix.getMat_size();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1; j++) {
                equations=equations+matrix.getData()[i][j]+"*x"+j+"+";
            }
            equations=equations+matrix.getData()[i][matrix.getMat_size()-1]+
                    "*x"+(matrix.getMat_size()-1)+"="+matrix.getData()[i][matrix.getMat_size()]+"!";
        }
        String str = solutionSLAU.methodGaussa(matrix.getData(), matrix.getMat_size());
        dbOperations.setSlau(size,equations,str);

        return Response.ok("[\""+str+"\"]").header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .build();
    }

    @Path("/slau")
    @OPTIONS
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response meth() {
        return Response.ok().header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .build();
    }

    @Path("/interpol")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response Interpol(MyPoint[] points) {
        int size = points.length;
        double[] xMas = new double[size];
        double[] yMas = new double[size];
        for (int i = 0; i < size; i++) {
            xMas[i] = points[i].getX();
            yMas[i] = points[i].getY();
        }

        double l = xMas[0];
        double r = xMas[size - 1];
        int numPointsInterpol = (int) ((r - l) / 0.1 + 1);
        double[] xMasInterpol = new double[numPointsInterpol];
        double[] yMasInterpol = new double[numPointsInterpol];
        double valuePoint = l;
        for (int i = 0; i < numPointsInterpol; i++) {
            xMasInterpol[i] = valuePoint;
            valuePoint += 0.1;
        }

        for (int i = 0; i < numPointsInterpol; i++) {
            yMasInterpol[i] = methodNewton.f(xMas, yMas, xMasInterpol[i]);
        }

        InterpolPoint interpolpoints;

        interpolpoints = new InterpolPoint(xMasInterpol, yMasInterpol);

        return Response.ok(interpolpoints).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .build();
    }

    @Path("/interpol")
    @OPTIONS
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response met() {
        return Response.ok().header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .build();
    }

    @Path("calc/{op}/{x}/{y}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response Calculator(@PathParam("op") String op, @PathParam("x") String x,
                               @PathParam("y") String y) {
        double x_int = Double.parseDouble(x);
        double y_int = Double.parseDouble(y);
        Double answer=null;
        String ans = "";

        switch (op.charAt(0)) {
            case '+':
                answer = (x_int + y_int);
                ans = answer.toString();
                break;
            case '-':
                answer = x_int - y_int;
                ans = answer.toString();
                break;
            case '*':
                answer = x_int * y_int;
                ans = answer.toString();
                break;
            case ':':
                if (y_int == 0) {
                    ans = "Error";
                    break;
                }
                answer = x_int / y_int;
                ans = answer.toString();
                break;
        }
        dbOperations.setCalc(x_int,y_int,op,answer);
        return Response.ok(ans).header("Access-Control-Allow-Origin", "*").build();

    }

    @Path("integr/{c_x3}/{c_x2}/{c_x}/{c}/{a}/{b}/{numStep}/{metod}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response Integr(@PathParam("c_x3") String c_x3, @PathParam("c_x2") String c_x2,
                           @PathParam("c_x") String c_x, @PathParam("c") String c,
                           @PathParam("a") String a, @PathParam("b") String b,
                           @PathParam("numStep") String numStep, @PathParam("metod") String metod) {
        float c_x3_f = Float.parseFloat(c_x3);
        float c_x2_f = Float.parseFloat(c_x2);
        float c_x_f = Float.parseFloat(c_x);
        float c_f = Float.parseFloat(c);
        float a_f = Float.parseFloat(a);
        float b_f = Float.parseFloat(b);
        float numStep_f = Float.parseFloat(numStep);
        Float result = 0f;
        String ans = "";

        switch (metod.charAt(0)) {
            case '1':
                result = Integrate.methodRectangleIntegral(a_f, b_f, numStep_f, c_x3_f, c_x2_f, c_x_f, c_f);
                break;
            case '2':
                result = Integrate.methodTrapezeIntegral(a_f, b_f, numStep_f, c_x3_f, c_x2_f, c_x_f, c_f);
                break;
            case '3':
                result = Integrate.methodSimpsonaIntegral(a_f, b_f, numStep_f, c_x3_f, c_x2_f, c_x_f, c_f);
                break;

        }
        ans = result.toString();
        double c_x3_d = Double.parseDouble(c_x3);
        double c_x2_d = Double.parseDouble(c_x2);
        double c_x_d = Double.parseDouble(c_x);
        double c_d = Double.parseDouble(c);
        int numStep_i = Integer.parseInt(numStep);
        double a_d = Double.parseDouble(a);
        double b_d = Double.parseDouble(b);
        double result_d=(double)result;

        dbOperations.setIntegr(c_x3_d, c_x2_d, c_x_d, c_d,numStep_i,a_d,b_d,result_d);
        return Response.ok(ans).header("Access-Control-Allow-Origin", "*").build();
    }



    @Path("/calcbd")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response calcbd() {
        List<CalculatorEntity> result = dbOperations.getCalc();
        return Response.ok(result).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .build();
    }

    @Path("/integrbd")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response integrbd() {
        List<IntegrationEntity> result = dbOperations.getIntegr();
        return Response.ok(result).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .build();
    }

    @Path("/slaubd")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response slaubd() {
        List<SlauEntity> result = dbOperations.getSlau();
        return Response.ok(result).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "Access-Control-Allow-Origin,Content-Type")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .build();
    }

}