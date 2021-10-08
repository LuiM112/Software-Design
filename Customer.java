public class Customer {
    private String name;
    private int ssn;
    private String address;

    public Customer(String aName,String addr,int ssn2){
        name = aName;
        address = addr;
        ssn = ssn2;
    }

    public void updateAddress(String addr){
        address = addr;
    }


}
