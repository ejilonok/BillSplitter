public class CostUtils {
    public static String costToString(double cost) {
        String resultRub;
        //String resultKop;

        int costRub = (int) Math.floor(cost);
        //int costKop = ((int) (Math.floor(cost * 100.0f))) / 100;

        // 0,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,25,26,27,28,29,30.. рублей
        // 1,21,31... рубль
        // 2,3,4,22,23,24,32,33,34... рубля

        int costRubLast2Digits = costRub % 100;
        int costRubLastDigit = costRub % 10;

        if (((costRubLast2Digits >=5) && (costRubLast2Digits <= 20)) || (costRubLastDigit == 0) || (costRubLastDigit >= 5)) {
            resultRub = String.format("%.2f рублей", cost).replace(',','.');
        } else if (costRubLastDigit == 1) {
            resultRub = String.format("%.2f рубль", cost).replace(',','.');
        } else {
            resultRub = String.format("%.2f рубля", cost).replace(',','.');
        }

        /* Здесь был код для работы и с копейками тоже
        if (((costRubLast2Digits >=5) && (costRub <= 20)) || (costRubLastDigit == 0) || (costRubLastDigit >= 5)) {
            resultRub = costRub + " рублей ";
        } else if (costRubLastDigit == 1) {
            resultRub = costRub + " рубль ";
        } else {
            resultRub = costRub +  " рубля ";
        }

        int costKopLastDigit = costKop % 10;

        if (((costKop >=5) && (costKop <= 20)) || (costKopLastDigit == 0) || (costKopLastDigit >= 5)) {
            resultKop = costKop + " копеек";
        } else if (costKopLastDigit == 1) {
            resultKop = costKop + " копейка";
        } else {
            resultKop = costKop +  " копейки";
        }

        return resultRub + resultKop;*/

        return resultRub;
    }

    public static boolean hasKopParts(double cost) {
        return (cost - costFloorToKop(cost)) != 0.0;
    }

    public static double costFloorToKop(double cost) {
        return Math.floor(cost * 100.0) / 100.0;
    }
}
