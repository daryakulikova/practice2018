/**
 * Created by aleksandr on 10.02.17.
 */
public class SolutionSLAU {
        public String methodGaussa(double[][] mat, int size) {

        int changes = 0;
        String answer = " ";
        mat = MethodG.StageForm(mat, size, changes);
        mat = MethodG.BackStageForm(mat, size);
        double det = MethodG.GetDeterminant(mat, changes, size);//определитель матрицы
        answer = "Определитель:" + String.valueOf(det);
        //System.out.println(String.valueOf(det));

        if (MethodG.Rang(mat, size) == MethodG.RangRasshir(mat, size)) {
            answer = answer + "СЛАУ совместна !";
            if (MethodG.Rang(mat, size) == size) {
                answer = answer +"Система определенная !";
                int index = 1;
                String str;
                for (double d : MethodG.GetCertainAnswers(mat, size)) {
                    answer = answer +"X"+String.valueOf(index)+" = "+String.valueOf(d);
                    index++;
                }
            } else {
                answer = answer + "Система неопределенная !";
                answer = answer + MethodG.GetGeneralSolution(mat, size);
            }
        }
        else
            {
                answer = answer + "СЛАУ несовместна";
            }
        return answer;
    }
}