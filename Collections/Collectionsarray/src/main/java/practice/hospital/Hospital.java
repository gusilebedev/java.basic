package practice.hospital;

import java.text.DecimalFormat;
import java.util.Arrays;

public class Hospital {
    private final static float MAX_TEMP = 40;
    private final static float MIN_TEMP = 32;

    private final static double MIN_HEALTH_TEMP = 36.2;
    private final static double MAX_HEALTH_TEMP = 36.9;

    public static float[] generatePatientsTemperatures(int patientsCount) {

        float[] temperatureData = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            float temperature = (float)(Math.random()*(MAX_TEMP-MIN_TEMP))+MIN_TEMP;
            int a = (int)(temperature * 10);
            temperatureData[i] = (float) a / 10;
        }
        return temperatureData;
    }
        public static String getReport(float[] temperatureData) {
        String regex = "[^0-9.' ']";
        String temperatures = Arrays.toString(temperatureData).replaceAll(regex,"");
        float sum = 0;
        int temperatureNormal = 0;
            for (int i = 0; i < temperatureData.length; i++) {
                sum = (sum + temperatureData[i]);
                if (temperatureData[i] <= (float)MAX_HEALTH_TEMP && temperatureData[i] >= (float)MIN_HEALTH_TEMP) {
                    temperatureNormal++;
                }
            }
            float average = sum / temperatureData.length;
            int a = (int)(average * 100);
            float temperatureAverage = (float) a / 100;

        String report =
            "Температуры пациентов: " +  temperatures +
            "\nСредняя температура: " +  temperatureAverage +
            "\nКоличество здоровых: " + temperatureNormal;

        return report;
    }
}

        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */
