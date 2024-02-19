import java.io.*;

public class Fichero {
    private File file;

    public Fichero(String ruta) {
        file = new File(ruta);
    }

    public void crearFichero() {
        try {
            if (file.createNewFile()) {
                System.out.println("Fichero creado: " + file.getName());
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
    }

    public void buscarFichero() {
        if (file.exists()) {
            System.out.println("El fichero existe en la ruta: " + file.getPath());
        } else {
            System.out.println("El fichero no existe en la ruta: " + file.getPath());
        }
    }

    public void eliminarFichero() {
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Fichero eliminado: " + file.getName());
            } else {
                System.out.println("No se pudo eliminar el fichero.");
            }
        } else {
            System.out.println("El fichero no existe en la ruta: " + file.getPath());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String ruta = "C:\\Users\\Borja\\Desktop\\Nueva carpeta (2)";
        Fichero fichero = new Fichero(ruta);

        // Crear el fichero
        fichero.crearFichero();

        // Buscar el fichero
        fichero.buscarFichero();

        // Eliminar el fichero
        fichero.eliminarFichero();
    }
}
