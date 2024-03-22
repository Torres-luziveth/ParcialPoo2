public class Jugador {
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String id;

    public Jugador(String nombre, String apellido, String nombreUsuario, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreUsuario = nombreUsuario;
        this.id = id;
    }

    public Object[] getInformacion(Jugador jugador) {

        Object[] lista = {jugador.getNombre(), jugador.getApellido(), jugador.getNombreUsuario(), jugador.getId()};

        return lista;
    }
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreUsuario = nombreJugador;
    }

    public String getId() {
        return id;
    }
}

