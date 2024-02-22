package customer.domain;

public class GetCustomerUserCase {

    private   CustomerRepository customerRepository;

    public GetCustomerUserCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public  Customer execute(String name){
        return  this.customerRepository.obtainCustomer(name);
    }
}
