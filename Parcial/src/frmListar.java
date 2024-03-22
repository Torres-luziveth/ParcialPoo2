import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class frmListar extends JFrame implements ActionListener {
    static ImageIcon imgRegresar;
    static JButton btnRegresar;
    static JTable tabla;
    static DefaultTableModel model;
    static JScrollPane scrollpane;
    static JLabel lblTitulo;
    static ArrayList<Jugador> listJugador;


    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnRegresar)){
            frmLogin.ventanaIngresar.setVisible(true);
            this.setVisible(false);
            limpiarRegistros();
        }
    }
    public frmListar(ArrayList<Jugador> listJugador){
        this.listJugador = listJugador;

        //Fondo
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo1 = new ImageIcon(".\\img\\fondo.jpg");
                g.drawImage(fondo1.getImage(), 0, 0, getWidth(), getHeight(), this);

            }
        };

        //imagenes
        imgRegresar = new ImageIcon(".\\img\\regresar.png");

        //instanciar
        btnRegresar = new JButton("Regresar", imgRegresar);
        model = new DefaultTableModel();
        tabla = new JTable(model);
        scrollpane = new JScrollPane(tabla);
        lblTitulo = new JLabel("Jugadores registrados:");
        lblTitulo.setForeground(Color.white);

        Font fuente = new Font("Arial", Font.BOLD, 15);
        lblTitulo.setFont(fuente);

        //bounds
        btnRegresar.setBounds(155, 275, 125, 25);
        lblTitulo.setBounds(132, 10, 230, 25);

        //tamaño tabla
        scrollpane.setLocation(33,40);
        scrollpane.setSize(370,227);

        //action listen
        btnRegresar.addActionListener(this);

        //add columnas
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Nom. usuario");
        model.addColumn("Id usuario");

        // adicionar
        contentPane.add(btnRegresar);
        contentPane.add(scrollpane, BorderLayout.CENTER);
        contentPane.add(lblTitulo);

        /// ventana
        setContentPane(contentPane);
        setLayout(null);
        setSize(450, 350);
        setTitle("Revisar");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);;

    }
    static public void listar(){

        for (Jugador jugador : listJugador){
            model.addRow(jugador.getInformacion(jugador));
        }

    }

    static public void limpiarRegistros() {
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

}