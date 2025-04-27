package GUI;


import classes.Routestorage;
import client.Client;
import collectionCommands.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.*;

import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;
import org.jxmapviewer.JXMapKit;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class AppForm extends javax.swing.JFrame {
    private Client client;
    private CommandData commandData;

    Timer timer = new Timer(10000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    });
    private ResourceBundle bundle;

    public AppForm(Client client, CommandData commandData) {
        this.client = client;
        this.commandData = commandData;

        initComponents();
        pack();
        setSize(2048, 480);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void open() {
        setVisible(true);
        timer.start();
    }

    public void update() {
        client.sendObjectToServer(new ShowCommand());
        String message = client.receivedObjectFromServer();
        if (message.equals("Во время входа произошла ошибка: такой пользователь не зарегистрирован.") || message.equals("Во время регистрации произошла ошибка: такой пользователь уже зарегистрирован.")) {
            JOptionPane.showMessageDialog(this, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {
            jTextArea1.setText(message);
        }

    }

    private void initComponents() {
        setLocale(new Locale("ru"));
        this.bundle = ResourceBundle.getBundle("messages", getLocale());

        String commandsText = bundle.getString("commands.label");
        String infoText = bundle.getString("info.label");
        String collectionInfoText = bundle.getString("collectionInfo.label");
        String deleteText = bundle.getString("delete.label");
        String addUpdateText = bundle.getString("addUpdate.label");
        String sortText = bundle.getString("sort.label");


        jPanel1 = new BackgroundPanel("C:\\Users\\Artem\\Desktop\\Учеба\\Программирование\\8 Лаба\\CLIENT_TRUE\\src\\resourses\\icon1.jpg");
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        Button_info = new JButton();
        jLabel4 = new JLabel();
        ButtonInsert = new JButton();
        jLabel5 = new JLabel();
        ButtonUpdate = new JButton();
        ButtonRemove = new JButton();
        Button_clear = new JButton();
        jLabel6 = new JLabel();
        jButton14 = new javax.swing.JButton();
        ButtonRemoveGreater = new JButton();
        ButtonRemoveLower = new JButton();
        jButton10 = new JButton();
        jLabel7 = new JLabel();
        ButtonCountGreaterDistance = new JButton();
        ButtonFilterByDistance = new JButton();
        ButtonFilterStartsWith = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel3 = new JLabel();
        ButtonShow = new JButton();
        jComboBox1 = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("それを読む人は誰でも死ぬでしょう");
        setBackground(new Color(255, 255, 255));
        setPreferredSize(new Dimension(850, 450));

        jLabel1.setFont(new Font("Segoe UI Black", 1, 24)); // NOI18N
//        jLabel1.setText("КОМАНДЫ");
        jLabel1.setText(commandsText);
        jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);

        jLabel2.setFont(new Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel2.setText("Зарядил койлом катану, режу горло суке в ванной...");

        Button_info.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
//        Button_info.setText("INFO");
        Button_info.setText(infoText);
        Button_info.setBackground(Color.WHITE);
        Button_info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonInfoAction(evt);
            }
        });

        jLabel4.setFont(new Font("Segoe UI Black", 1, 14)); // NOI18N
//        jLabel4.setText("Информация о коллекции");
        jLabel4.setText(collectionInfoText);

        ButtonInsert.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        ButtonInsert.setText("INSERT");
        ButtonInsert.setBackground(Color.WHITE);
        ButtonInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonInsertActionPerformed(evt);
            }
        });

        jLabel5.setFont(new Font("Segoe UI Black", 1, 14)); // NOI18N
//        jLabel5.setText("Добавление/Обновление объектов");
        jLabel5.setText(addUpdateText);

        ButtonUpdate.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        ButtonUpdate.setText("UPDATE");
        ButtonUpdate.setBackground(Color.WHITE);
        ButtonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonUpdateActionPerformed(evt);
            }
        });

        ButtonRemove.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        ButtonRemove.setText("REMOVE");
        ButtonRemove.setBackground(Color.WHITE);
        ButtonRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonRemoveActionPerformed(evt);
            }
        });

        Button_clear.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        Button_clear.setText("CLEAR");
        Button_clear.setBackground(Color.WHITE);
        Button_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonClearActionPerformed(evt);
            }
        });

        jLabel6.setFont(new Font("Segoe UI Black", 1, 14)); // NOI18N
//        jLabel6.setText("Удаление объектов");
        jLabel6.setText(deleteText);

        ButtonRemoveGreater.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        ButtonRemoveGreater.setText("REMOVE GREATER");
        ButtonRemoveGreater.setBackground(Color.WHITE);
        ButtonRemoveGreater.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonRemoveGreaterActionPerformed(evt);
            }
        });

        ButtonRemoveLower.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        ButtonRemoveLower.setText("REMOVE LOWER");
        ButtonRemoveLower.setBackground(Color.WHITE);
        ButtonRemoveLower.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonRemoveLowerActionPerformed(evt);
            }
        });

        jButton10.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setText("REMOVE LOWER KEY");
        jButton10.setBackground(Color.WHITE);
        jButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new Font("Segoe UI Black", 1, 14)); // NOI18N
//        jLabel7.setText("Сортировка/Подсчет");
        jLabel7.setText(sortText);

        ButtonCountGreaterDistance.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        ButtonCountGreaterDistance.setText("COUNT GREATER DISTANCE");
        ButtonCountGreaterDistance.setBackground(Color.WHITE);
        ButtonCountGreaterDistance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonCountGreaterDistanceActionPerformed(evt);
            }
        });

        ButtonFilterByDistance.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        ButtonFilterByDistance.setText("FILTER BY DISTANCE");
        ButtonFilterByDistance.setBackground(Color.WHITE);
        ButtonFilterByDistance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonFilterByDistanceActionPerformed(evt);
            }
        });

        ButtonFilterStartsWith.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        ButtonFilterStartsWith.setText("FILTER STARTS WITH");
        ButtonFilterStartsWith.setBackground(Color.WHITE);
        ButtonFilterStartsWith.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonFilterStartsWithActionPerformed(evt);
            }
        });

        ButtonShow.setBackground(Color.WHITE);
        ButtonShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ButtonShowActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton14.setText("MARKS");
        jButton14.setBackground(Color.WHITE);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel8.setText("神に感謝します私はとてもクソ素晴らしいです");

        jLabel9.setText("あなたは私と同じ世界に住んでいるどのように幸運です");

        jLabel10.setText("私は本当に伝説であり、すべての世代の声です");

        jLabel3.setText("私はここでハラキリをクソしています。");

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Русский", "Португальский", "Шведский", "Испанский" }));
        jComboBox1.setBackground(Color.WHITE);
        jComboBox1.addActionListener(e -> {
            int selectedIndex = jComboBox1.getSelectedIndex();
            switch (selectedIndex) {
                case 0: // Русский
                    setLocale(new Locale("ru"));
                    break;
                case 1: // Португальский
                    setLocale(new Locale("pt"));
                    break;
                case 2: // Шведский
                    setLocale(new Locale("sv"));
                    break;
                case 3: // Испанский
                    setLocale(new Locale("es", "CO")); // Колумбийский испанский
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Неверная выбрана локаль", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            updateUIElements();
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel8))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel1))
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jLabel3)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(ButtonRemoveLower, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(ButtonRemoveGreater, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(ButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(Button_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(ButtonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(ButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(54, 54, 54)
                                                                                .addComponent(jLabel6))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(94, 94, 94)
                                                                                .addComponent(Button_info, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(54, 54, 54)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ButtonCountGreaterDistance)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(ButtonFilterStartsWith, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(ButtonFilterByDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                .addGap(31, 31, 31))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addGap(62, 62, 62)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonShow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ButtonShow, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel8)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel9)
                                                        .addGap(2, 2, 2)
                                                        .addComponent(jLabel10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(jLabel7))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(Button_info, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ButtonCountGreaterDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel5)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(ButtonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(ButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel6)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(ButtonRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(Button_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(ButtonFilterByDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(ButtonFilterStartsWith, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(ButtonRemoveGreater, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ButtonRemoveLower, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void updateUIElements() {

        this.bundle = ResourceBundle.getBundle("messages", getLocale());

        String commandsText = bundle.getString("commands.label");
        String infoText = bundle.getString("info.label");
        String collectionInfoText = bundle.getString("collectionInfo.label");
        String deleteText = bundle.getString("delete.label");
        String addUpdateText = bundle.getString("addUpdate.label");
        String sortText = bundle.getString("sort.label");

        jLabel1.setText(commandsText);
        Button_info.setText(infoText);
        jLabel4.setText(collectionInfoText);
        jLabel5.setText(addUpdateText);
        jLabel7.setText(sortText);
        jLabel6.setText(deleteText);
    }

    private void ButtonShowActionPerformed(java.awt.event.ActionEvent evt) {
        client.sendObjectToServer(new ShowCommand());
        String message = client.receivedObjectFromServer();
        if (message.equals("Во время входа произошла ошибка: такой пользователь не зарегистрирован.") || message.equals("Во время регистрации произошла ошибка: такой пользователь уже зарегистрирован.")) {
            JOptionPane.showMessageDialog(this, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {
            jTextArea1.setText(message);
        }
    }

    private void ButtonInfoAction(java.awt.event.ActionEvent evt) {
        client.sendObjectToServer(new InfoCommand());
        String message = client.receivedObjectFromServer();
        JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.DEFAULT_OPTION);
    }

    private void ButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {
        InsertForm insertForm = new InsertForm(this, client);
        setVisible(false);
    }

    private void ButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        String inputValue = JOptionPane.showInputDialog("Введите значение key:");

        if (inputValue != null && !inputValue.isEmpty()) {
            try {
                int intValue = Integer.parseInt(inputValue);
                UpdateForm updateForm= new UpdateForm(intValue,this, client);
                setVisible(false);

            } catch (NumberFormatException e) {
                // Если введенное значение не является целым числом, отображаем сообщение об ошибке
                JOptionPane.showMessageDialog(null, "Некорректное значение! Введите целое число.", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void ButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        String inputValue = JOptionPane.showInputDialog("Введите значение key:");

        if (inputValue != null && !inputValue.isEmpty()) {
            try {
                int intValue = Integer.parseInt(inputValue);
                client.sendObjectToServer(CommandData.getUser());
                client.sendObjectToServer(new RemoveKeyCommand(commandData, intValue));
                String message = client.receivedObjectFromServer();
                JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.DEFAULT_OPTION);

            } catch (NumberFormatException e) {
                // Если введенное значение не является целым числом, отображаем сообщение об ошибке
                JOptionPane.showMessageDialog(null, "Некорректное значение! Введите целое число.", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void ButtonClearActionPerformed(java.awt.event.ActionEvent evt) {
        client.sendObjectToServer(CommandData.getUser());
        client.sendObjectToServer(new ClearCommand());
        String message = client.receivedObjectFromServer();
        JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.DEFAULT_OPTION);
    }
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {
        client.sendObjectToServer(new GetCollectionCommand(null));
        Routestorage routestorage = client.receiveCollectionFromServer();
        LinkedHashMap<Integer, Route> map = routestorage.getMap();

        List<Route> routes = new ArrayList<>(map.values());

        openMapWithMarkers(routes);

    }

    public void openMapWithMarkers(List<Route> routes) {
        JXMapKit mapViewer = new JXMapKit();
        mapViewer.setDefaultProvider(JXMapKit.DefaultProviders.OpenStreetMaps);
        mapViewer.setDataProviderCreditShown(true);

        JFrame frame = new JFrame("Map");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mapViewer);
        frame.setSize(800, 600);
        frame.setVisible(true);

        Set<Waypoint> waypoints = new HashSet<>();
        for (Route route : routes) {
            GeoPosition position = new GeoPosition(route.getCoordinates().getX(), route.getCoordinates().getY());
            waypoints.add(new CustomWaypoint(position, route));
        }

        WaypointPainter<Waypoint> waypointPainter = new WaypointPainter<>();
        waypointPainter.setWaypoints(waypoints);
        waypointPainter.setRenderer(new CustomWaypointRenderer());
        mapViewer.getMainMap().setOverlayPainter(waypointPainter);

        mapViewer.getMainMap().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point mousePoint = e.getPoint();
                GeoPosition geoPos = mapViewer.getMainMap().convertPointToGeoPosition(mousePoint);

                double threshold = 0.0001;
                for (Waypoint waypoint : waypoints) {
                    GeoPosition waypointPos = ((DefaultWaypoint) waypoint).getPosition();
                    if (isCloseTo(geoPos, waypointPos, threshold)) {
                        CustomWaypoint customWaypoint = (CustomWaypoint) waypoint;
                        Route route = customWaypoint.getRoute();
                        editRoute(route);
                    }
                }
            }
        });
    }

    private boolean isCloseTo(GeoPosition pos1, GeoPosition pos2, double threshold) {
        return Math.abs(pos1.getLatitude() - pos2.getLatitude()) < threshold &&
                Math.abs(pos1.getLongitude() - pos2.getLongitude()) < threshold;
    }

    private void editRoute(Route route) {
        JButton editButton = new JButton("Изменить");

        String routeDetails = "<html>Route:<br/>" +
                "id: " + route.getId() + "<br/>" +
                "name: " + route.getName() + "<br/>" +
                "coordinates: " + route.getCoordinates() + "<br/>" +
                "creationDate: " + route.getCreationDate() + "<br/>" +
                "from: " + route.getFrom() + "<br/>" +
                "to: " + route.getTo() + "<br/>" +
                "distance: " + route.getDistance() + "<br/>" +
                "owner: " + route.getOwner() + "<br/></html>";

        JLabel label = new JLabel(routeDetails);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        JDialog dialog = new JDialog((Frame) null, "Edit Route", true);
        dialog.getContentPane().add(panel);
        dialog.setSize(550, 350);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);

        editButton.addActionListener(e -> {
            performEditAction(route);
            dialog.dispose(); // Закрываем и освобождаем ресурсы окна
        });

        dialog.setVisible(true);

    }

    private void performEditAction(Route route) {
        EditRouteForm editRouteForm = new EditRouteForm(this, client, route);
        editRouteForm.setVisible(true);
    }

    class CustomWaypoint extends DefaultWaypoint {
        private Route route;

        public CustomWaypoint(GeoPosition position, Route route) {
            super(position);
            this.route = route;
        }

        public Route getRoute() {
            return route;
        }
    }

    class CustomWaypointRenderer implements WaypointRenderer<Waypoint> {
        @Override
        public void paintWaypoint(Graphics2D g, JXMapViewer map, Waypoint waypoint) {
            CustomWaypoint customWaypoint = (CustomWaypoint) waypoint;
            Route route = customWaypoint.getRoute();
            GeoPosition pos = customWaypoint.getPosition();
            Point2D point = map.getTileFactory().geoToPixel(pos, map.getZoom());

            g.setColor(Color.RED);
            g.fillOval((int) point.getX() - 5, (int) point.getY() - 5, 10, 10);

            String text = "name: " + route.getName() + " owner: " + route.getOwner();
            Font font = new Font("Arial", Font.BOLD, 14);
            FontMetrics metrics = g.getFontMetrics(font);
            int textWidth = metrics.stringWidth(text);
            int textHeight = metrics.getHeight();

            g.setFont(font);
            g.setColor(Color.WHITE);
            g.fillRect((int) point.getX() + 10, (int) point.getY() - textHeight, textWidth, textHeight);
            g.setColor(Color.BLACK);
            g.drawString(text, (int) point.getX() + 10, (int) point.getY());
        }
    }

    private void ButtonRemoveGreaterActionPerformed(java.awt.event.ActionEvent evt) {
        RemoveGreaterForm removeGreaterForm = new RemoveGreaterForm(this, client);
        setVisible(false);
    }

    private void ButtonRemoveLowerActionPerformed(java.awt.event.ActionEvent evt) {
        RemoveLowerForm removeLowerForm = new RemoveLowerForm(this, client);
        setVisible(false);
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        String inputValue = JOptionPane.showInputDialog("Введите значение key:");

        if (inputValue != null && !inputValue.isEmpty()) {
            try {
                int intValue = Integer.parseInt(inputValue);
                client.sendObjectToServer(CommandData.getUser());
                client.sendObjectToServer(new RemoveLowerKeyCommand(intValue));
                String message = client.receivedObjectFromServer();
                JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.DEFAULT_OPTION);

            } catch (NumberFormatException e) {
                // Если введенное значение не является целым числом, отображаем сообщение об ошибке
                JOptionPane.showMessageDialog(null, "Некорректное значение! Введите целое число.", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void ButtonCountGreaterDistanceActionPerformed(java.awt.event.ActionEvent evt) {
        String inputValue = JOptionPane.showInputDialog("Введите значение distance:");

        if (inputValue != null && !inputValue.isEmpty()) {
            try {
                Float floatValue = Float.parseFloat(inputValue);
                client.sendObjectToServer(CommandData.getUser());
                client.sendObjectToServer(new CountGreaterThanDistanceCommand(floatValue));
                String message = client.receivedObjectFromServer();
                JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.DEFAULT_OPTION);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Некорректное значение! Введите число.", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void ButtonFilterByDistanceActionPerformed(java.awt.event.ActionEvent evt) {
        String inputValue = JOptionPane.showInputDialog("Введите значение distance:");

        if (inputValue != null && !inputValue.isEmpty()) {
            try {
                Float floatValue = Float.parseFloat(inputValue);
                client.sendObjectToServer(CommandData.getUser());
                client.sendObjectToServer(new FilterByDistanceCommand(floatValue));
                String message = client.receivedObjectFromServer();
                JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.DEFAULT_OPTION);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Некорректное значение! Введите число.", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void ButtonFilterStartsWithActionPerformed(java.awt.event.ActionEvent evt) {
        String inputValue = JOptionPane.showInputDialog("Введите значение distance:");

        if (inputValue != null && !inputValue.isEmpty()) {
            try {
                client.sendObjectToServer(CommandData.getUser());
                client.sendObjectToServer(new FilterStartsWithNameCommand(inputValue));
                String message = client.receivedObjectFromServer();
                JOptionPane.showMessageDialog(this, message, "INFO", JOptionPane.DEFAULT_OPTION);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Некорректное значение!", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton ButtonShow;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton ButtonCountGreaterDistance;
    private javax.swing.JButton ButtonFilterByDistance;
    private javax.swing.JButton ButtonFilterStartsWith;
    private javax.swing.JButton Button_info;
    private javax.swing.JButton ButtonInsert;
    private javax.swing.JButton ButtonUpdate;
    private javax.swing.JButton ButtonRemove;
    private javax.swing.JButton Button_clear;
    private javax.swing.JButton ButtonRemoveGreater;
    private javax.swing.JButton ButtonRemoveLower;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jButton14;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration
}
