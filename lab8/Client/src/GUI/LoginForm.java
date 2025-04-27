    package GUI;

    import client.Client;
    import client.ClientData;
    import collectionCommands.CommandData;
    import database.User;

    import javax.swing.*;
            import java.awt.*;
            import java.util.Arrays;
    import java.util.Locale;
    import java.util.ResourceBundle;

    public class LoginForm extends javax.swing.JFrame {
        private Client client;
        private ClientData clientData;
        private AppForm appForm;
        private ResourceBundle bundle;
        private Locale locale;
        public LoginForm(Client client, ClientData clientData, AppForm appForm) {
            this.client = client;
            this.clientData = clientData;
            this.appForm = appForm;
            setTitle("クラッシュテスト");
            setLocationRelativeTo(null);
            initComponents();
            setVisible(true);
            setResizable(false);
        }

        private void initComponents() {
            setLocale(new Locale("ru"));
            this.bundle = ResourceBundle.getBundle("messages", getLocale());

            String welcomeText = bundle.getString("welcome.label");
            String logInText = bundle.getString("logInToYourAccount.label");
            String usernameText = bundle.getString("username.label");
            String passwordText = bundle.getString("password.label");
            String logInTextButton = bundle.getString("logInToYourAccount.button");
            String singUpTextButton = bundle.getString("signUpAccount.button");
            String dontHaveAnAccountText = bundle.getString("dontHaveAnAccount.label");


            jPanel7 = new BackgroundPanel("C:\\Users\\Artem\\Desktop\\Учеба\\Программирование\\8 Лаба\\CLIENT_TRUE\\src\\resourses\\icon3.jpg");
            Label_LoginToAccount = new javax.swing.JLabel();
            Label_Welcome = new javax.swing.JLabel();
            Label_Password = new javax.swing.JLabel();
            Label_Username = new javax.swing.JLabel();
            Field_Username = new javax.swing.JTextField();
            Field_Password = new javax.swing.JPasswordField();
            Button_SignUp = new javax.swing.JButton();
            Label_DontHaveAccount = new javax.swing.JLabel();
            Button_Login = new javax.swing.JButton();
            jComboBox1 = new javax.swing.JComboBox<>();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setPreferredSize(new java.awt.Dimension(400, 350));

            jPanel7.setBackground(new java.awt.Color(255, 255, 255));
            jPanel7.setPreferredSize(new java.awt.Dimension(400, 350));

            Label_LoginToAccount.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
            Label_LoginToAccount.setText(logInText);
    //        Label_LoginToAccount.setText("Log in to your account");
            Label_LoginToAccount.setForeground(Color.WHITE);

            Label_Welcome.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
            Label_Welcome.setText(welcomeText);
    //        Label_Welcome.setText("Welcome back!");
            Label_Welcome.setForeground(Color.WHITE);

            Label_Password.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
            Label_Password.setText(passwordText);
    //        Label_Password.setText("Password");
            Label_Password.setForeground(Color.WHITE);

            Label_Username.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
            Label_Username.setText(usernameText);
    //        Label_Username.setText("Username");
            Label_Username.setForeground(Color.WHITE);

            Field_Username.setMinimumSize(new java.awt.Dimension(64, 32));
            Field_Username.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Field_UsernameActionPerformed(evt);
                }
            });

            Field_Password.setPreferredSize(new java.awt.Dimension(64, 32));
            Field_Password.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Field_PasswordActionPerformed(evt);
                }
            });

            Button_SignUp.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
            Button_SignUp.setText(singUpTextButton);
    //        Button_SignUp.setText("Sign up");
            Button_SignUp.setBackground(Color.WHITE);
            Button_SignUp.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Button_SignUpActionPerformed(evt);
                }
            });

            Label_DontHaveAccount.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
            Label_DontHaveAccount.setText(dontHaveAnAccountText);
    //        Label_DontHaveAccount.setText("Don't have an account?");
            Label_DontHaveAccount.setForeground(Color.WHITE);

            Button_Login.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
            Button_Login.setText(logInTextButton);
    //        Button_Login.setText("Log in");
            Button_Login.setBackground(Color.WHITE);
            Button_Login.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Button_LoginActionPerformed(evt);
                }
            });

            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Русский", "Португальский", "Шведский", "Испанский" }));
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

            javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
            jPanel7.setLayout(jPanel7Layout);
            jPanel7Layout.setHorizontalGroup(
                    jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                    .addGap(44, 44, 44)
                                                    .addComponent(Label_Welcome)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                    .addGap(60, 60, 60)
                                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(Label_LoginToAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(Label_DontHaveAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(Button_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                            .addComponent(Field_Username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(Label_Username)
                                                                            .addComponent(Label_Password)
                                                                            .addComponent(Field_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                                    .addGap(97, 97, 97)
                                                                    .addComponent(Button_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addContainerGap(44, Short.MAX_VALUE))
            );
            jPanel7Layout.setVerticalGroup(
                    jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                    .addGap(14, 14, 14)
                                                    .addComponent(Label_Welcome))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addComponent(Label_LoginToAccount)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Label_Username)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Field_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Label_Password)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Field_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Button_Login)
                                    .addGap(18, 18, 18)
                                    .addComponent(Label_DontHaveAccount)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Button_SignUp)
                                    .addContainerGap(21, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            );
            pack();
        }// </editor-fold>

        private void Field_UsernameActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void Field_PasswordActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void Button_SignUpActionPerformed(java.awt.event.ActionEvent evt) {
            setVisible(false);
            SignUpForm signUpForm = new SignUpForm(client,clientData, appForm, getLocale());
        }
        private void updateUIElements() {
            this.bundle = ResourceBundle.getBundle("messages", getLocale());
            String welcomeText = bundle.getString("welcome.label");
            String logInText = bundle.getString("logInToYourAccount.label");
            String usernameText = bundle.getString("username.label");
            String passwordText = bundle.getString("password.label");
            String logInTextButton = bundle.getString("logInToYourAccount.button");
            String singUpTextButton = bundle.getString("signUpAccount.button");
            String dontHaveAnAccountText = bundle.getString("dontHaveAnAccount.label");

            Label_Welcome.setText(welcomeText);
            Label_LoginToAccount.setText(logInText);
            Label_Username.setText(usernameText);
            Label_Password.setText(passwordText);
            Button_Login.setText(logInTextButton);
            Button_SignUp.setText(singUpTextButton);
            Label_DontHaveAccount.setText(dontHaveAnAccountText);
        }
        private void Button_LoginActionPerformed(java.awt.event.ActionEvent evt) {
            User user = new User();
            Integer flag = 0;
            String username = Field_Username.getText();
            String password = new String(Field_Password.getPassword());
            if (username == null || username.trim().isEmpty() || username.length() > 15 || username.contains(" ")) {
                JOptionPane.showMessageDialog(this, "Username не может содержать больше 15 символов,быть пустым и содержать пробелы", "Ошибка", JOptionPane.ERROR_MESSAGE);
            } else {
                user.setUsername(username);
                flag += 1;
            }
            if (password == null || password.trim().isEmpty() || password.trim().length() > 15 || password.contains(" ")) {
                JOptionPane.showMessageDialog(this, "Password не может содержать больше 15 символов,быть пустым и содержать пробелы", "Ошибка", JOptionPane.ERROR_MESSAGE);
            } else {
                user.setPassword(password);
                flag += 1;
            }
            user.setRegFlag(1);
            CommandData.setUser(user);
            if (user != null && flag == 2) {
                client.sendObjectToServer(user);
                client.receivedObjectFromServer();
                if (clientData.getLoginFlag() && client.getFlag()) {user.setRegFlag(3); appForm.open(); setVisible(false);}
                else { JOptionPane.showMessageDialog(this, "Такого пользователя не существует", "Ошибка", JOptionPane.ERROR_MESSAGE);}
                clientData.setLoginFlag(true);
            }
        }


        private javax.swing.JButton Button_Login;
        private javax.swing.JButton Button_SignUp;
        private javax.swing.JPasswordField Field_Password;
        private javax.swing.JTextField Field_Username;
        private javax.swing.JLabel Label_DontHaveAccount;
        private javax.swing.JLabel Label_LoginToAccount;
        private javax.swing.JLabel Label_Password;
        private javax.swing.JLabel Label_Username;
        private javax.swing.JLabel Label_Welcome;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JComboBox<String> jComboBox1;
    }
