package GUI;

public class DistanceCalculator {
    private static final double EARTH_RADIUS = 6371.01; // Радиус Земли в километрах

    // Метод для вычисления расстояния между двумя точками
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Преобразование градусов в радианы
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Вычисление формулы Хаверсина
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Расстояние между точками (в километрах)
        double distance = EARTH_RADIUS * c;

        return distance;
    }
}
