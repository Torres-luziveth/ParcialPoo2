import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmLogin extends JFrame implements ActionListener {

    // Definir JLabels
    static JLabel lblUsuario, lblContraseña, lblLogin;
    static JTextField txtUsuario, txtContraseña;

    static JButton btnIngresar;

    static ImageIcon imgLogin;

    static frmInicioAdmin ventanaIngresar;
    static frmLogin ventana;


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnIngresar)) {
            String usuario = txtUsuario.getText();
            String contraseña = txtContraseña.getText();
            if(Usuarios.validarUsuario(usuario,contraseña)){
                ventanaIngresar.setVisible(true);
                this.setVisible(false);
                txtUsuario.setText("");
                txtContraseña.setText(" ");
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append("Usuario o clave incorrecta.");
                JOptionPane.showMessageDialog(null, sb.toString());
            }

        }
    }

    public frmLogin() {

        //otras ventanas
        ventanaIngresar= new frmInicioAdmin();

        // img
        imgLogin = new ImageIcon(".\\img\\login.png");
        // Crear JPanel personalizado para el fondo

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo1 = new ImageIcon(".\\img\\fondo1.jpg");
                g.drawImage(fondo1.getImage(), 0, 0, getWidth(), getHeight(), this);

                ImageIcon fondo = new ImageIcon(".\\img\\fond.png");
                g.drawImage(fondo.getImage(), 10, 60, 200, 200, this);
            }
        };
        contentPane.setLayout(null);

        // JLabels
        lblUsuario = new JLabel("Usuario:");
        lblContraseña = new JLabel("Contraseña:");
        lblLogin = new JLabel(imgLogin);

        // TextFields
        txtUsuario = new JTextField();
        txtContraseña = new JTextField();

        //boton
        btnIngresar = new JButton("Ingresar");

        // setBounds
        lblLogin.setBounds(75, 13, 70, 70);
        lblUsuario.setBounds(35, 90, 80, 25);
        txtUsuario.setBounds(35, 110, 150, 27);
        lblContraseña.setBounds(35, 140, 80, 25);
        txtContraseña.setBounds(35, 160, 150, 27);
        btnIngresar.setBounds(35, 205, 150, 25);


        // Adicionar
        contentPane.add(lblUsuario);
        contentPane.add(txtUsuario);
        contentPane.add(lblContraseña);
        contentPane.add(txtContraseña);
        contentPane.add(lblLogin);
        contentPane.add(btnIngresar);

        //action listener
        btnIngresar.addActionListener(this);


        // Configuración de la ventana
        setContentPane(contentPane);
        setLayout(null);
        setSize(450, 350);
        setTitle("Login");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        ventana = new frmLogin();
        ventana.setVisible(true);
    }
}
