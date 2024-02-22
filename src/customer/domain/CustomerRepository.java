package customer.domain;

import java.io.IOException;

public interface CustomerRepository {


    void saveCustomer(Customer customer) throws IOException;

    Customer obtainCustomer(String name);
}
