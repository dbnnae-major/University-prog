package database;

public class Const {
    // ТАБЛИЦА USERS
    public static final String USER_TABLE = "users";
    public static final String USER_ID = "id";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";

    // ТАБЛИЦА ROUTES
    public static final String ROUTES_TABLE = "routes";
    public static final String ROUTES_OWNER = "owner";
    public static final String ROUTES_ID = "route_id";
    public static final String ROUTES_NAME = "route_name";
    public static final String ROUTES_COORDINATES_X = "route_coordinates_x";
    public static final String ROUTES_COORDINATES_Y = "route_coordinates_y";
    public static final String ROUTES_DATE = "route_date";
    public static final String ROUTES_LOCATION1_X = "route_location1_x";
    public static final String ROUTES_LOCATION1_Y = "route_location1_y";
    public static final String ROUTES_LOCATION1_NAME = "route_location1_name";
    public static final String ROUTES_LOCATION2_X = "route_location2_x";
    public static final String ROUTES_LOCATION2_Y = "route_location2_y";
    public static final String ROUTES_LOCATION2_Z = "route_location2_z";
    public static final String ROUTES_LOCATION2_NAME = "route_location2_name";
    public static final String ROUTES_DISTANCE = "route_distance";

    // ЗАПРОСЫ К БД
    public static final String ADD_USER_REQUEST = "INSERT INTO " + USER_TABLE + "(" +
            USER_USERNAME + "," + USER_PASSWORD + ") VALUES (?, ?)";
    public static final String FIND_USERNAME_REQUEST = "SELECT COUNT(*) AS count FROM " +
            USER_TABLE + " WHERE " + USER_USERNAME + " = ?";
    public static final String SELECT_USERNAME_PASSWORD_FROM_USERS_REQUEST = "SELECT " + USER_USERNAME + ", " +
            USER_PASSWORD + " FROM " + USER_TABLE + " WHERE " + USER_USERNAME + " = ?";
    public static final String SELECT_ALL_FROM_ROUTES_REQUEST = "SELECT * FROM " + ROUTES_TABLE;
    public static final String ADD_ROUTES_REQUEST = "INSERT INTO " + ROUTES_TABLE + " (" +
            ROUTES_OWNER + "," + ROUTES_ID + "," + ROUTES_NAME + "," + ROUTES_COORDINATES_X + "," + ROUTES_COORDINATES_Y + "," +
            ROUTES_DATE + "," + ROUTES_LOCATION1_X + "," + ROUTES_LOCATION1_Y + "," + ROUTES_LOCATION1_NAME + "," +
            ROUTES_LOCATION2_X + "," + ROUTES_LOCATION2_Y + "," + ROUTES_LOCATION2_Z + "," + ROUTES_LOCATION2_NAME + "," +
            ROUTES_DISTANCE + ") VALUES (?,DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE_ROUTES_REQUEST = "UPDATE " + ROUTES_TABLE + " SET " +
            ROUTES_NAME + " = ?," + ROUTES_COORDINATES_X + " = ?," + ROUTES_COORDINATES_Y + " = ?," +
            ROUTES_DATE + " = ?," + ROUTES_LOCATION1_X + " = ?," +
            ROUTES_LOCATION1_Y + " = ?," + ROUTES_LOCATION1_NAME + " = ?," +
            ROUTES_LOCATION2_X + " = ?," + ROUTES_LOCATION2_Y + " = ?," +
            ROUTES_LOCATION2_Z + " = ?," + ROUTES_LOCATION2_NAME + " = ?," +
            ROUTES_DISTANCE + " = ? WHERE " + ROUTES_ID + " = ?";
    public static final String SELECT_ROUTES_OWNER_REQUEST = "SELECT " +
            ROUTES_OWNER + " FROM " + ROUTES_TABLE + " WHERE " + ROUTES_ID + " = ?";
    public static final String DELETE_ALL_ROUTES_REQUEST = "DELETE FROM " + ROUTES_TABLE + " WHERE " +
            ROUTES_OWNER + " = ?";
    public static final String DELETE_ROUTES_BY_KEY_REQUEST = "DELETE FROM " + ROUTES_TABLE + " WHERE " +
            ROUTES_ID + " = ? AND " + ROUTES_OWNER + " = ?";
}
