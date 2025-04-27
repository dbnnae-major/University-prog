package GUI;

import client.Client;
import client.ClientData;
import collectionCommands.CommandData;
import database.User;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class SignUpForm extends javax.swing.JFrame {

    private Client client;
    private ClientData clientData;
    private AppForm appForm;
    private ResourceBundle bundle;

    public SignUpForm(Client client, ClientData clientData, AppForm appForm, Locale locale) {
        setLocale(locale);
        this.appForm = appForm;
        this.client = client;
        this.clientData = clientData;
        setTitle("クラッシュテスト");
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }


    private void initComponents() {
        this.bundle = ResourceBundle.getBundle("messages", getLocale());

        String SignUpForFreeText = bundle.getString("signUpForFree.label");
        String usernameText = bundle.getString("username.label");
        String passwordText = bundle.getString("password.label");
        String confirmPasswordText = bundle.getString("confirmPassword.label");
        String singUpTextButton = bundle.getString("signUpAccount.button");

        jPanel7 = new BackgroundPanel("C:\\Users\\Artem\\Desktop\\Учеба\\Программирование\\8 Лаба\\CLIENT_TRUE\\src\\resourses\\icon3.jpg");
        Label_SignUpForFree = new javax.swing.JLabel();
        Label_Password = new javax.swing.JLabel();
        Label_Username = new javax.swing.JLabel();
        Field_Username = new javax.swing.JTextField();
        Field_Password = new javax.swing.JPasswordField();
        Button_SignUp = new javax.swing.JButton();
        Label_ConfirmPassword = new javax.swing.JLabel();
        Field_ConfirmPassword = new javax.swing.JPasswordField();
        Button_Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(340, 350));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(325, 300));

        Label_SignUpForFree.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        Label_SignUpForFree.setText(SignUpForFreeText);
//        Label_SignUpForFree.setText("Sign up for free");
        Label_SignUpForFree.setForeground(Color.WHITE);

        Label_Password.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        Label_Password.setText(passwordText);
//        Label_Password.setText("Password");
        Label_Password.setForeground(Color.WHITE);

        Label_Username.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        Label_Username.setText(usernameText);
//        Label_Username.setText("Username");
        Label_Username.setForeground(Color.WHITE);

        Field_Username.setMinimumSize(new java.awt.Dimension(64, 32));

        Field_Password.setPreferredSize(new java.awt.Dimension(64, 32));

        Button_SignUp.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Button_SignUp.setText(singUpTextButton);
//        Button_SignUp.setText("Sign up");
        Button_SignUp.setBackground(Color.WHITE);
        Button_SignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SignUpActionPerformed(evt);
            }
        });

        Label_ConfirmPassword.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        Label_ConfirmPassword.setText(confirmPasswordText);
//        Label_ConfirmPassword.setText("Confirm password");
        Label_ConfirmPassword.setForeground(Color.WHITE);
        Field_ConfirmPassword.setPreferredSize(new java.awt.Dimension(64, 32));

        Button_Back.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        Button_Back.setText("<-");
        Button_Back.setBackground(Color.WHITE);
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Button_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(Label_SignUpForFree, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(Field_Username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Label_Username)
                                                                        .addComponent(Label_Password)
                                                                        .addComponent(Field_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(Label_ConfirmPassword)
                                                                .addComponent(Field_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Button_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Button_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(Label_SignUpForFree)
                                .addGap(29, 29, 29)
                                .addComponent(Label_Username)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Field_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Label_Password)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Field_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(Label_ConfirmPassword)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Field_ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_SignUp)
                                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void updateUIElements() {
    }

    private void Button_SignUpActionPerformed(java.awt.event.ActionEvent evt) {
        User user = new User();
        Integer flag = 0;
        String username = Field_Username.getText();
        String password1 = new String(Field_Password.getPassword());
        String password2 = new String(Field_ConfirmPassword.getPassword());
        if (username == null || username.trim().isEmpty() || username.length() > 15 || username.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Username не может содержать больше 15 символов,быть пустым и содержать пробелы", "Ошибка", JOptionPane.ERROR_MESSAGE);
        } else {
            flag += 1;
            user.setUsername(username);
        }
        if (password1 == null || password1.trim().isEmpty() || password1.trim().length() > 15 || password1.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Password не может содержать больше 15 символов,быть пустым и содержать пробелы", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        if (password2 == null || password2.trim().isEmpty() || password2.trim().length() > 15 || password2.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Password не может содержать больше 15 символов,быть пустым и содержать пробелы", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        if (password1.equals(password2)) {
            user.setPassword(password1);
            flag += 1;
        } else {
            JOptionPane.showMessageDialog(this, "Password не совпадает", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
        user.setRegFlag(0);
        CommandData.setUser(user);
        if (user != null && flag == 2) {
            client.sendObjectToServer(user);
            client.receivedObjectFromServer();
            if (clientData.getLoginFlag() && client.getFlag()) {user.setRegFlag(3);   appForm.open(); setVisible(false);}
            clientData.setRegFlag(true);

        }
    }

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {
        LoginForm loginForm = new LoginForm(client,clientData, appForm);
        setVisible(false);
    }


    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_SignUp;
    private javax.swing.JPasswordField Field_ConfirmPassword;
    private javax.swing.JPasswordField Field_Password;
    private javax.swing.JTextField Field_Username;
    private javax.swing.JLabel Label_ConfirmPassword;
    private javax.swing.JLabel Label_Password;
    private javax.swing.JLabel Label_SignUpForFree;
    private javax.swing.JLabel Label_Username;
    private javax.swing.JPanel jPanel7;
}
