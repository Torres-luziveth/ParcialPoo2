import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frmInicioAdmin extends JFrame implements ActionListener {

    //definir imagenes
    static ImageIcon imgListar, imgRegistrar, imgbuscar, imgSalir, imgHome;

    //definri jlabels
    static JLabel lblTitle, lblRegistrar, lblListar, lblHome;

    // definir botones
    static JButton btnRegistrarJugadores, btnListarJugadores, btnCerrarSesion;

    // ventanas
    static frmRegistrar ventanaRegistrar;
    static frmListar ventanaListar;

    static ArrayList<Jugador> listJugador = new ArrayList();

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegistrarJugadores)) {
            ventanaRegistrar.setVisible(true);
            this.setVisible(false);

        }

        if (e.getSource().equals(btnListarJugadores)) {
            ventanaListar.setVisible(true);
            this.setVisible(false);
            frmListar.listar();
        }

        if (e.getSource().equals(btnCerrarSesion)) {
            frmLogin.ventana.setVisible(true);
            this.setVisible(false);

        }
    }

    public frmInicioAdmin() {

            //Fondo
            JPanel contentPane = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon fondo1 = new ImageIcon(".\\img\\fondo.jpg");
                    g.drawImage(fondo1.getImage(), 0, 0, getWidth(), getHeight(), this);

                }
            };

            ventanaListar = new frmListar(listJugador);
            ventanaRegistrar = new frmRegistrar(listJugador);


            // imagenes
            imgHome = new ImageIcon(".\\img\\home.png");
            imgRegistrar = new ImageIcon(".\\img\\registrar.png");
            imgListar = new ImageIcon(".\\img\\listar.png");
            imgbuscar = new ImageIcon(".\\img\\buscar.png");
            imgSalir = new ImageIcon(".\\img\\salir.png");

            // Jlabels
            lblHome = new JLabel(imgHome);
            lblTitle = new JLabel("Gestión de jugadores:");
            lblRegistrar = new JLabel("Registrar jugador");
            lblListar = new JLabel("Listar jugadores");

            lblTitle.setForeground(Color.white);
            lblRegistrar.setForeground(Color.white);
            lblListar.setForeground(Color.white);

            Font fuente = new Font("Arial", Font.BOLD, 13);
            lblTitle.setFont(fuente);


            // botones
            btnRegistrarJugadores = new JButton(imgRegistrar);
            btnListarJugadores = new JButton(imgListar);
            btnCerrarSesion = new JButton("Cerrar sesión", imgSalir);

            // setBounds
            lblHome.setBounds(134, 8, 68, 68);
            lblTitle.setBounds(95, 70, 250, 25);

            btnRegistrarJugadores.setBounds(50, 130, 100, 70);
            lblRegistrar.setBounds(50, 200, 120, 20);

            btnListarJugadores.setBounds(190, 130, 100, 70);
            lblListar.setBounds(195, 200, 120, 20);

            btnCerrarSesion.setBounds(90, 250, 160, 25);


            //adicionar
            contentPane.add(lblHome);
            contentPane.add(lblTitle);
            contentPane.add(btnRegistrarJugadores);
            contentPane.add(lblRegistrar);

            contentPane.add(btnListarJugadores);
            contentPane.add(lblListar);

            contentPane.add(btnCerrarSesion);


            // adicionar actionListen
            btnRegistrarJugadores.addActionListener(this);
            btnListarJugadores.addActionListener(this);
            btnCerrarSesion.addActionListener(this);

            //configuracion de la ventana
            setContentPane(contentPane);
            setLayout(null);
            setSize(350, 350);
            setTitle("Saludar");
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

    }


}