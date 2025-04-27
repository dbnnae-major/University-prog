package GUI;


import client.Client;
import collectionCommands.CommandData;
import collectionCommands.InsertCommand;
import collectionCommands.UpdateIdCommand;
import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.Waypoint;
import org.jxmapviewer.viewer.WaypointPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class EditRouteForm extends javax.swing.JFrame {

    private AppForm appForm;
    private Client client;
    private String routename;
    private Coordinates routeCoordinates;
    private Location1 from;
    private Location2 to;
    private Float distance;
    private Route route;
    private int key = 0;
    String owner = CommandData.getUser().getUsername();

    private double tempX1;
    private double tempY1;
    private double tempX2;
    private double tempY2;
    public EditRouteForm(AppForm appForm, Client client, Route route) {
        this.appForm = appForm;
        this.client = client;
        this.route = route;
        this.routename = route.getName();
        this.routeCoordinates = route.getCoordinates();
        this.from = route.getFrom();
        this.to = route.getTo();
        this.distance = route.getDistance();
        this.key = route.getId();

        initComponents();
        setVisible(true);
        setSize(680, 180);
        setLocationRelativeTo(null);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Label_From = new javax.swing.JLabel();
        FieldRouteName = new javax.swing.JTextField();
        Label_RouteName = new javax.swing.JLabel();
        ButtonRouteCoordinates = new javax.swing.JButton();
        ButtonFromCoordinates = new javax.swing.JButton();
        Label_From1 = new javax.swing.JLabel();
        ButtonToCoordinates = new javax.swing.JButton();
        LabelInfo = new javax.swing.JLabel();
        ButtonConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(670, 175));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(670, 175));

        Label_From.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Label_From.setText("LOCATION FROM");

        FieldRouteName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FieldRouteNameActionPerformed(evt);
            }
        });

        Label_RouteName.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Label_RouteName.setText("ROUTE NAME");

        ButtonRouteCoordinates.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        ButtonRouteCoordinates.setText("Получить координаты");
        ButtonRouteCoordinates.setBackground(Color.WHITE);
        ButtonRouteCoordinates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRouteCoordinatesActionPerformed(evt);
            }
        });

        ButtonFromCoordinates.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        ButtonFromCoordinates.setText("Получить координаты");
        ButtonFromCoordinates.setBackground(Color.WHITE);
        ButtonFromCoordinates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonFromCoordinatesActionPerformed(evt);
            }
        });

        Label_From1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Label_From1.setText("LOCATION TO");

        ButtonToCoordinates.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        ButtonToCoordinates.setText("Получить координаты");
        ButtonToCoordinates.setBackground(Color.WHITE);
        ButtonToCoordinates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonToCoordinatesActionPerformed(evt);
            }
        });

        LabelInfo.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        LabelInfo.setText("При нажатии на \"Получить координаты\" Вам будет предоставлена возможность выбрать место.");

        ButtonConfirm.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        ButtonConfirm.setText("Потвердить выбор");
        ButtonConfirm.setBackground(Color.WHITE);
        ButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(LabelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(Label_RouteName)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(FieldRouteName, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(ButtonRouteCoordinates, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ButtonFromCoordinates)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(Label_From)
                                                                .addGap(23, 23, 23)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ButtonToCoordinates)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(35, 35, 35)
                                                                .addComponent(Label_From1))))
                                        .addComponent(ButtonConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Label_From1)
                                                        .addComponent(Label_From))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ButtonToCoordinates))
                                        .addComponent(ButtonFromCoordinates)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Label_RouteName)
                                                        .addComponent(FieldRouteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ButtonRouteCoordinates)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonConfirm)
                                .addContainerGap(76, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void ButtonRouteCoordinatesActionPerformed(java.awt.event.ActionEvent evt) {
        JXMapKit mapViewer = new JXMapKit();
        mapViewer.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
        mapViewer.setDataProviderCreditShown(true);


        JFrame frame = new JFrame("Map");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setVisible(true);


        mapViewer.getMainMap().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {

                    Point mousePoint = e.getPoint();
                    GeoPosition geoPos = mapViewer.getMainMap().convertPointToGeoPosition(mousePoint);


                    Set<Waypoint> waypoints = new HashSet<>();
                    waypoints.add(new DefaultWaypoint(geoPos));

                    WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
                    waypointPainter.setWaypoints(waypoints);

                    mapViewer.getMainMap().setOverlayPainter(waypointPainter);


                    String location = getLocationFromCoordinates(geoPos.getLatitude(), geoPos.getLongitude());
                    double elevation = getElevationFromCoordinates(geoPos.getLatitude(), geoPos.getLongitude());
                    System.out.println("Coordinates: " + geoPos.getLatitude() + ", " + geoPos.getLongitude());
                    System.out.println("Location: " + location);
                    System.out.println("Elevation: " + elevation + " meters");

                    routeCoordinates = new Coordinates(geoPos.getLatitude(), geoPos.getLongitude());
                }
            }
        });
    }

    private String getLocationFromCoordinates(double latitude, double longitude) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://nominatim.openstreetmap.org/reverse?format=json&lat=" + latitude + "&lon=" + longitude;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            JSONObject json = new JSONObject(responseBody);
            JSONObject address = json.getJSONObject("address");

            String country = address.optString("country", "N/A");
            String city = address.optString("city", address.optString("town", address.optString("village", "N/A")));
            String road = address.optString("road", "N/A");

            return country + ", " + city + ", " + road;
        } catch (IOException e) {
            e.printStackTrace();
            return "Unable to get location";
        } catch (JSONException e) {
            return "Unable to get location";
        }
    }

    private double getElevationFromCoordinates(double latitude, double longitude) {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.opentopodata.org/v1/test-dataset?locations=" + latitude + "," + longitude;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String responseBody = response.body().string();
            JSONObject json = new JSONObject(responseBody);
            JSONArray results = json.getJSONArray("results");
            if (results.length() > 0) {
                JSONObject result = results.getJSONObject(0);
                return result.getDouble("elevation");
            } else {
                return Double.NaN;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Double.NaN;
        }
    }

    private void ButtonFromCoordinatesActionPerformed(java.awt.event.ActionEvent evt) {
        JXMapKit mapViewer = new JXMapKit();
        mapViewer.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
        mapViewer.setDataProviderCreditShown(true);


        JFrame frame = new JFrame("Map");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setVisible(true);


        mapViewer.getMainMap().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {

                    Point mousePoint = e.getPoint();
                    GeoPosition geoPos = mapViewer.getMainMap().convertPointToGeoPosition(mousePoint);


                    Set<Waypoint> waypoints = new HashSet<>();
                    waypoints.add(new DefaultWaypoint(geoPos));

                    WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
                    waypointPainter.setWaypoints(waypoints);

                    mapViewer.getMainMap().setOverlayPainter(waypointPainter);


                    String location = getLocationFromCoordinates(geoPos.getLatitude(), geoPos.getLongitude());
                    double elevation = getElevationFromCoordinates(geoPos.getLatitude(), geoPos.getLongitude());
                    System.out.println("Coordinates: " + geoPos.getLatitude() + ", " + geoPos.getLongitude());
                    System.out.println("Location: " + location);
                    System.out.println("Elevation: " + elevation + " meters");

                    from = new Location1((int) geoPos.getLatitude(), (float) geoPos.getLongitude(), location);
                    tempX1 = geoPos.getLatitude();
                    tempY1 = geoPos.getLongitude();
                }
            }
        });
    }

    private void ButtonToCoordinatesActionPerformed(java.awt.event.ActionEvent evt) {
        JXMapKit mapViewer = new JXMapKit();
        mapViewer.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
        mapViewer.setDataProviderCreditShown(true);


        JFrame frame = new JFrame("Map");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setVisible(true);


        mapViewer.getMainMap().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {

                    Point mousePoint = e.getPoint();
                    GeoPosition geoPos = mapViewer.getMainMap().convertPointToGeoPosition(mousePoint);


                    Set<Waypoint> waypoints = new HashSet<>();
                    waypoints.add(new DefaultWaypoint(geoPos));

                    WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
                    waypointPainter.setWaypoints(waypoints);

                    mapViewer.getMainMap().setOverlayPainter(waypointPainter);


                    String location = getLocationFromCoordinates(geoPos.getLatitude(), geoPos.getLongitude());
                    double elevation = getElevationFromCoordinates(geoPos.getLatitude(), geoPos.getLongitude());
                    System.out.println("Coordinates: " + geoPos.getLatitude() + ", " + geoPos.getLongitude());
                    System.out.println("Location: " + location);
                    System.out.println("Elevation: " + elevation + " meters");

                    to = new Location2((int) geoPos.getLatitude(), geoPos.getLongitude(), elevation, location);
                    tempX2 = geoPos.getLatitude();
                    tempY2 = geoPos.getLongitude();
                }
            }
        });
    }

    private void FieldRouteNameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {


        if (FieldRouteName.getText() != null || !FieldRouteName.getText().trim().isEmpty()) {
            routename = FieldRouteName.getText();
        }
        if (routeCoordinates != null & from != null & to != null) {
            Route route = new Route(key, routename, routeCoordinates, from, to, distance, owner);
            if (routeCoordinates.validate() & from.validate() & to.validate() & route.validate()) {
                client.sendObjectToServer(new UpdateIdCommand(route));
                String message = client.receivedObjectFromServer();
                JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.DEFAULT_OPTION);
                setVisible(false);
                appForm.open();
            } else {
                System.out.println(route);
                JOptionPane.showMessageDialog(this, "Ошибка в создании объекта route.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                setVisible(false);
                appForm.open();
            }
        } else {
            System.out.println(route);
            JOptionPane.showMessageDialog(this, "Ошибка в создании объекта route.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            setVisible(false);
            appForm.open();
        }

    }


    private javax.swing.JButton ButtonConfirm;
    private javax.swing.JButton ButtonFromCoordinates;
    private javax.swing.JButton ButtonRouteCoordinates;
    private javax.swing.JButton ButtonToCoordinates;
    private javax.swing.JTextField FieldRouteName;
    private javax.swing.JLabel LabelInfo;
    private javax.swing.JLabel Label_From;
    private javax.swing.JLabel Label_From1;
    private javax.swing.JLabel Label_RouteName;
    private javax.swing.JPanel jPanel1;
}
