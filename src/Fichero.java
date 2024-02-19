import java.io.*;



public class Fichero {
    private File file;

    public Fichero(String ruta) {
        file = new File(ruta);
    }

    public void crearFichero() {
        if (file.exists()) {
            System.out.println(" No se imprime nada ");
            return;
        }

        try {
            if (file.createNewFile()) {
                System.out.println(" Imprime un Boton verde ");
            } else {
                System.out.println(" No se imprime nada ");
            }
        } catch (IOException e) {
            System.out.println("Error ");
        }
    }

    public void buscarFichero() {
        if (file.exists()) {
            System.out.println("El fichero existe en la ruta: " + file.getPath());
        } else {
            System.out.println("El fichero no existe en la ruta: " + file.getPath());
        }
    }



    public static void main(String[] args) {
        // Ejemplo de uso
        String ruta = "C:\\Users\\Borja\\Desktop\\Nueva carpeta (2) ";
        Fichero fichero = new Fichero(ruta);

        // Crear el fichero (solo si no existe)
        fichero.crearFichero();

        // Buscar el fichero
        fichero.buscarFichero();


    }
}

