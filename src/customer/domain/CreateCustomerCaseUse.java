package customer.domain;

import java.io.IOException;

public class CreateCustomerCaseUse {

    private  CustomerRepository customerRepository;

    public CreateCustomerCaseUse(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public  void execute(Customer customer){
        try {
            this.customerRepository.saveCustomer(customer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
