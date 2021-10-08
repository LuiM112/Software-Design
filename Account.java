public class Account {
    private int accNum;
    private int accType;
    private Customer accountholder;

    public Account(String name, String addr, int ssn, int accNum2, int accType2, double balance){
        accNum =accNum2;
        accType = accType2;

        accountholder = new Customer(name,addr,ssn);
    }

    public boolean equals(int num){
        boolean check = false;

        if (accNum == num){
            check = true;
        }
        return check;
    }
    public void update(String addr){
        accountholder.updateAddress(addr);
    }

}
