import customer.data.CustomerDataRepository;
import customer.domain.Customer;

import java.io.IOException;

public class Main {
public  static  void  main(String [] args) {
    // Crear una instancia de CustomerDataRepository
    CustomerDataRepository repository = new CustomerDataRepository();

    try {
        // Guardar un nuevo cliente
        Customer nuevoCliente = new Customer("Nuevo Cliente");
        repository.saveCustomer(nuevoCliente);

        // Obtener un cliente por nombre
        Customer clienteObtenido = repository.obtainCustomer("NombreCliente");

        // Hacer algo con el cliente obtenido, si es necesario
        if (clienteObtenido != null) {
            System.out.println("Cliente obtenido: " + clienteObtenido.getName());
        }
    } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
    }

}
}
