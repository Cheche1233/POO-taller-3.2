// Clase abstracta ItemBiblioteca
public abstract class ItemBiblioteca {
    // Atributos
    protected int id;
    protected String titulo;
    protected String estado;

    // Constructor
    public ItemBiblioteca(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.estado = "Disponible"; // Estado por defecto al crear el ítem
    }

    // Métodos concretos
    public int obtenerId() {
        return id;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public String obtenerEstado() {
        return estado;
    }

    public void establecerEstado(String estado) {
        this.estado = estado;
    }

    // Método abstracto
    public abstract String toString();
}

// Interfaz Prestable
public interface Prestable {
    // Métodos abstractos
    void prestar();
    void devolver();
    boolean estaPrestado();
}

// Ejemplo de implementación de la interfaz Prestable en la clase Libro
public class Libro extends ItemBiblioteca implements Prestable {
    private boolean prestado;

    // Constructor
    public Libro(int id, String titulo) {
        super(id, titulo);
        this.prestado = false; // Al crear el libro, inicialmente no está prestado
    }

    // Implementación de los métodos abstractos de la interfaz Prestable
    @Override
    public void prestar() {
        if (!prestado) {
            establecerEstado("Prestado");
            prestado = true;
            System.out.println("El libro '" + obtenerTitulo() + "' ha sido prestado.");
        } else {
            System.out.println("El libro '" + obtenerTitulo() + "' ya está prestado.");
        }
    }

    @Override
    public void devolver() {
        if (prestado) {
            establecerEstado("Disponible");
            prestado = false;
            System.out.println("El libro '" + obtenerTitulo() + "' ha sido devuelto.");
        } else {
            System.out.println("El libro '" + obtenerTitulo() + "' no está prestado.");
        }
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }

    // Implementación del método abstracto toString() de la clase ItemBiblioteca
    @Override
    public String toString() {
        return "Libro [ID: " + obtenerId() + ", Título: " + obtenerTitulo() + ", Estado: " + obtenerEstado() + "]";
    }

    // Método adicional específico de Libro
    public void mostrarInformacion() {
        System.out.println("Información del libro:");
        System.out.println(toString());
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Libro libro1 = new Libro(1, "El Principito");
        libro1.mostrarInformacion(); // Muestra información del libro

        libro1.prestar(); // Prestar el libro
        libro1.mostrarInformacion(); // Muestra información actualizada del libro después de prestarlo

        libro1.devolver(); // Devolver el libro
        libro1.mostrarInformacion(); // Muestra información actualizada del libro después de devolverlo
    }
}
