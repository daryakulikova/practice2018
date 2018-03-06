public class Integrate {
    public static float methodRectangleIntegral(Float a, Float b, Float numStep, Float c_x3, Float
            c_x2, Float c_x, Float c) {
        Integer i;
        Float result, h;
        result = 0f;
        h = (b - a) / numStep;
        for (i = 0; i < numStep; i++) {
            result += InFunction((a + h * (i + 1 / 2)), c_x3, c_x2, c_x, c);
        }
        result *= h;
        return result;
    }

    public static float methodTrapezeIntegral(Float a, Float b, Float numStep, Float c_x3, Float
            c_x2, Float c_x, Float c) {
        Integer i;
        Float result, h;
        result = 0f;
        h = (b - a) / numStep;
        for (i = 1; i <= numStep; i++) {
            result += ((InFunction((a+(i-1)*h), c_x3, c_x2, c_x, c)+InFunction((a+i*h), c_x3, c_x2, c_x, c))/2);
        }
        result *= h;
        return result;
    }
    public static float methodSimpsonaIntegral(Float a, Float b, Float numStep, Float c_x3, Float
            c_x2, Float c_x, Float c) {
        Integer i;
        Float result1,result2,result, h;
        result = 0f;
        result1=0f;
        result2 =0f;
        h=(b-a)/(2*numStep);
        for (i = 1; i <= numStep; i++) {
            result1+=InFunction((a+(2*i-1)*h), c_x3, c_x2, c_x, c);
        }
        for (i = 1; i <= (numStep-1); i++) {
            result2+=InFunction((a+2*i*h), c_x3, c_x2, c_x, c);
        }
        result=(h/3)*(a+4*result1+2*result2+b);
        return result;
    }

    public static float InFunction(Float x, Float c3, Float c2, Float c1, Float c) {
        return c3 * x * x * x + c2 * x * x + c1 * x + c;
    }
}
