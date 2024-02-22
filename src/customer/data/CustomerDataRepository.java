package customer.data;
import java.io.*;
import customer.domain.Customer;
import customer.domain.CustomerRepository;

public class CustomerDataRepository  implements CustomerRepository {
    private static CustomerRepository instance =null;


    private static final String rutaArchivo = "C:\\Users\\Borja\\Desktop\\Nueva carpeta (2)";

    @Override
    public void saveCustomer(Customer customer) throws IOException {

        File archivo = new File(rutaArchivo);

        // Si el archivo no existe, se crea uno nuevo
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        // Se abre un flujo de escritura para escribir en el archivo
        FileWriter escritor = new FileWriter(archivo, true);
        BufferedWriter bw = new BufferedWriter(escritor);

        // Se escribe el nombre del cliente en el archivo
        bw.write(customer.getName());
        bw.newLine();

        // Se cierran los flujos
        bw.close();
        escritor.close();
        System.out.println("Nombre '" + customer.getName() + "' escrito en el archivo correctamente.");
    }



    @Override
    public Customer obtainCustomer(String name) {

        try {
            File archivo = new File(rutaArchivo);

            // Si el archivo no existe, se indica que el cliente no fue encontrado
            if (!archivo.exists()) {
                System.out.println("El archivo no existe. No se puede buscar al cliente.");
                return null;
            }

            // Se abre un flujo de lectura para leer el archivo
            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);

            String linea;
            Customer customer = null;

            // Se lee línea por línea buscando el nombre del cliente
            while ((linea = br.readLine()) != null) {
                if (linea.equals(name)) {
                    // Si se encuentra el nombre del cliente, se crea un objeto Customer
                    customer = new Customer(name);
                    break;
                }
            }

            // Se cierran los flujos
            br.close();
            lector.close();

            if (customer != null) {
                System.out.println("Cliente encontrado: " + customer.getName());
                return customer;
            } else {
                System.out.println("El cliente con el nombre '" + name + "' no fue encontrado en el archivo.");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

}
