import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmRegistrar extends JFrame implements ActionListener {

    static ImageIcon imgRegistrar, imgRegresar;
    static JButton btnRegresar,btnRegistrar;
    static JLabel lblIndicaciones, lblNombre, lblApellido, lblNombreUsuario, lblId;
    static JTextField txtNombre, txtApellido, txtNombreUsuario, txtId;
    static ArrayList<Jugador> listJugador;

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)) {
            frmLogin.ventanaIngresar.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(btnRegistrar)) {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String nombreUsuario = txtNombreUsuario.getText();
            String id = txtId.getText();

            Jugador nuevoJugador = new Jugador(nombre, apellido, nombreUsuario, id);
            listJugador.add(nuevoJugador);

            // limpiar los campos de texto después de registrar
            txtNombre.setText("");
            txtApellido.setText("");
            txtNombreUsuario.setText("");
            txtId.setText("");

        }
    }

    public frmRegistrar(ArrayList<Jugador> listJugador) {
        this.listJugador = listJugador;

        //Fondo
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo1 = new ImageIcon(".\\img\\fondo.jpg");
                g.drawImage(fondo1.getImage(), 0, 0, getWidth(), getHeight(), this);

                ImageIcon fondo = new ImageIcon(".\\img\\fond2.png");
                g.drawImage(fondo.getImage(), 20, 45, 335, 230, this);

            }
        };
        // Jlabels
        lblIndicaciones = new JLabel("REGISTRO");
        lblIndicaciones.setForeground(Color.white);

        Font fuente = new Font("Arial", Font.BOLD, 20);
        lblIndicaciones.setFont(fuente);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(Color.white);

        lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(Color.white);

        lblNombreUsuario = new JLabel("Nom. Usuario:");
        lblNombreUsuario.setForeground(Color.white);

        lblId = new JLabel("Id usuario:");
        lblId.setForeground(Color.white);

        //Imagenes
        imgRegistrar = new ImageIcon(".\\img\\registrar1.png");
        imgRegresar = new ImageIcon(".\\img\\regresar.png");

        //Botones
        btnRegresar = new JButton("Regresar", imgRegresar);
        btnRegistrar = new JButton("Registrar", imgRegistrar);

        //campos de texto
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtNombreUsuario = new JTextField();
        txtId = new JTextField();


        // setBuonds
        btnRegresar.setBounds(50, 220, 125, 25);
        btnRegistrar.setBounds(210,220,125,25);

        lblIndicaciones.setBounds(140, 20, 130, 20);

        lblNombre.setBounds(80, 70 , 80,20);
        txtNombre.setBounds( 160, 70, 145, 25);

        lblApellido.setBounds( 80, 100 ,80,20);
        txtApellido.setBounds(160, 100, 145, 25);

        lblNombreUsuario.setBounds(50, 130, 100, 20 );
        txtNombreUsuario.setBounds( 160, 130, 145, 25);

        lblId.setBounds(70,160,210,20);
        txtId.setBounds(160, 160, 145, 25);

        //actionListen
        btnRegresar.addActionListener(this);
        btnRegistrar.addActionListener(this);

        // adicionar
        contentPane.add(btnRegresar);
        contentPane.add(btnRegistrar);

        contentPane.add(lblIndicaciones);

        contentPane.add(lblNombre);
        contentPane.add(txtNombre);

        contentPane.add(lblApellido);
        contentPane.add(txtApellido);

        contentPane.add(lblNombreUsuario);
        contentPane.add(txtNombreUsuario);

        contentPane.add(lblId);
        contentPane.add(txtId);


        //configuracion de la ventana
        setContentPane(contentPane);
        setLayout(null);
        setSize(400, 350);
        setTitle("Registrar");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
