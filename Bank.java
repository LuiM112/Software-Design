public class Bank {
    private String name;
    private Account[] accounts;
    private int max = 5;
    private String bankName;
    private static int numAcc = 0;




    public Bank(String aName){
        bankName = aName;
    }
    public boolean openAccount(String name, String addr, int ssn, int accNum, int accType, double balance){
        boolean success = true;
        accounts [numAcc] = new Account(name,addr, ssn,accNum,accType,balance);
        if (numAcc > 5){
            success = false;
        }
        numAcc++;
        return success;
    }
    public boolean closeAccount (int accNum){
        int acc = 0;
        int i = 0;
        int j = 0;
        boolean delete = false;
        while (!delete || i < 5) {
            if (accounts[i].equals(accNum) == true){
                delete = true;
            }
            i++;
            acc = i;
        }

        Account[] copy = new Account[numAcc - 1];

        for (i = 0, j = 0; i < numAcc; i++) {
            if (i != acc) {
                copy[j++] = accounts[i];
            }
        }
        numAcc -= 1;
        return true;
    }
    public boolean updateAccount(int accNum, String addr){
        boolean success = false;
            for (int i = 0; i < numAcc; i++){
                if(accounts[i].equals(accNum)){
                    accounts[i].update(addr);
                    success = true;
                }
            }

        return success;
    }
    public void bankInfo(){

    }
}
