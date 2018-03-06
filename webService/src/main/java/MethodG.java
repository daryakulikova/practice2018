import java.util.ArrayList;

/**
 * Created by Александр on 11.02.2017.
 */
public class MethodG {
    public static double[][] StageForm(double[][] mat, int size, int perestanovki)
    {
        for(int i=0;i<size-1;i++)
        {
            if(IfColumnZero(mat,i,size)==false)//Если в колонке не только нули
            {
                if(mat[i][i]==0)//Если элемент диагонали = 0, меняем строки местами
                {
                    mat = Swap(mat, i,perestanovki, size);
                }
                mat = MakeZero(mat, i, size);
            }
            else
            {
                continue;
            }
        }
        return mat;
    }

    public static double[][] BackStageForm(double[][] mat, int size)
    {
        for (int i = size - 1; i > 0; i--)
        {
            if (mat[i][ i] == 0)//Если элемент диагонали = 0, пропустить
            {
                continue;
            }
            if (IfColumnZero(mat, i,size) == false)//Если в колонке не только нули
            {
                mat = MakeZeroBack(mat, i, size);
            }
            else
            {
                continue;
            }
        }
        return mat;
    }

    public static int Rang(double[][] mat, int size)
    {
        int number = 0;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(mat[i][j]!=0)
                {
                    number++;
                    break;
                }
            }
        }
        return number;
    }

    public static int RangRasshir(double[][] mat, int size)
    {
        int number = 0;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j <= size; j++)
            {
                if (mat[i][ j] != 0)
                {
                    number++;
                    break;
                }
            }
        }
        return number;
    }

    public static ArrayList<Double> GetCertainAnswers(double[][] mat, int size)
    {
        ArrayList<Double> answers = new ArrayList<Double>();
        for(int i=0;i<size;i++)
        {
            answers.add(mat[i][size] / mat[i][i]);
        }
        return answers;
    }

    public static String GetGeneralSolution(double[][] mat, int size)
    {
        String str = "Решение:";
        double d;
        for (int i = 0; i < Rang(mat, size); i++)
        {
            d = mat[i][i];
            str += "\nx" + String.valueOf(i + 1) + " = " + String.valueOf(mat[i][ size] / d);
            for (int j = i + 1; j < size; j++)
            {
                double curr = mat[i][ j];
                if (curr != 0)
                {
                    str += " " + OppositeSign(curr) + " " + String.valueOf(Math.abs((curr / d))) + "*x" + String.valueOf(j + 1);
                }
            }
        }
        return str;
    }

    public static double GetDeterminant(double[][] mat, int perestanovki, int size)
    {
        double determinant = 1;
        for(int i=0;i<size;i++)
        {
            determinant *= mat[i][ i];
        }
        determinant *= Math.pow(-1, perestanovki);
        return determinant;
    }

    private static char OppositeSign(double value)
    {
        if(value<0)
        {
            return '+';
        }
        else
        {
            return '-';
        }
    }

    private static double[][] ChangeRows(double[][] mat, int row1, int row2, int size)
    {
        double[][] tmp = new double[size][size+1];
        for(int i=0;i<=size;i++)
        {
            tmp[row1][ i] = mat[row1][ i];
            mat[row1][i] = mat[row2][i];
            mat[row2][i] = tmp[row1][ i];
        }
        return mat;
    }

    private static boolean IfColumnZero(double[][] mat,int column, int size)
    {
        for(int i=0;i<size;i++)
        {
            if(mat[i][column]!=0)
            {
                return false;
            }
        }
        return true;
    }

    private static double[][] Swap(double[][] mat, int column, int perestanovki, int size)
    {
        for(int i=column;i<size;i++)
        {
            if(mat[i][column]!=0)
            {
                mat = ChangeRows(mat, column, i, size);
                perestanovki++;
                break;
            }
        }
        return mat;
    }

    private static double[][] MakeZero(double[][] mat, int row1, int size)
    {
        for(int i=row1+1;i<size;i++)
        {
            if(mat[row1][row1]!=0)
            {
                double coef = mat[i][ row1] / mat[row1][ row1];
                for (int j = 0; j <= size; j++)
                {
                    mat[i][j] = mat[i][j] - mat[row1][ j] * coef;
                    if (Math.abs(mat[i][ j]) < 1.0E-10)
                    {
                        mat[i][ j] = 0;
                    }
                }
            }
        }
        return mat;
    }

    private static double[][] MakeZeroBack(double[][] mat, int row1, int size)
    {
        for (int i = row1-1; i >= 0; i--)
        {
            double coef = mat[i][row1] / mat[row1][row1];
            for (int j = 0; j <= size; j++)
            {
                mat[i][j] = mat[i][ j] - mat[row1][ j] * coef;
                if(Math.abs(mat[i][j])<1.0E-10)
                {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }
}
