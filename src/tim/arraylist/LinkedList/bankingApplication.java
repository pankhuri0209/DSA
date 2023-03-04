package tim.arraylist.LinkedList;

import java.util.ArrayList;

public class bankingApplication {

    record Customer(String name, ArrayList<Double> transactions)
    {
        public  Customer(String name, double initialDeposit)
        {
            this(name.toUpperCase(), new ArrayList<>(500));
            transactions.add(initialDeposit);
        }
    }
    public static void main(String[] args)
    {
        Customer bob= new Customer("Bob S", 1000.0);
        System.out.println(bob);

        Bank bank= new Bank("Chase");
        bank.addnewCustomer("Jane A",500);
        System.out.println(bank);

        bank.addTransactions("Jane A", -10.25);
        bank.addTransactions("jane A ",-75.01);
        bank.printStatements("Jane a");

        bank.addnewCustomer("bob s",25);
        bank.addTransactions("Bob S", 100);
        bank.printStatements("Bob S");


    }
    static class Bank
    {
        private String name;
        private ArrayList<Customer> customers= new ArrayList<>(5000);

        public Bank(String name)
        {
            this.name= name;
        }
        private Customer getCustomer(String customerName)
        {
            for(var customer: customers)
            {
                if(customer.name().equalsIgnoreCase(customerName))
                {
                    return customer;
                }
            }
            System.out.printf("Customer (%s) wasn't found %n",customerName);
            return null;
        }

        public void addnewCustomer(String customerName, int deposit)
        {
            if(getCustomer(customerName) ==null)
            {
                Customer customer= new Customer(customerName,deposit);
                customers.add(customer);
               System.out.println("New customer was added. "+customer);
            }
        }

        @Override
        public String toString() {
            return "Bank{" +
                    "name='" + name + '\'' +
                    ", customers=" + customers +
                    '}';
        }
        public void addTransactions(String name, double transactionAmount)
        {
            Customer customer= getCustomer(name);
            if (customer !=null)
            {
                customer.transactions().add(transactionAmount);
            }
        }
        public void printStatements(String customerName)
        {
            Customer customer= getCustomer(customerName);
            if(customer ==null)
            {
                return;
            }
            System.out.println("-".repeat(30));
            System.out.println("Customer name: " +customer.name());
            System.out.println("Transactions:");
            for(double d: customer.transactions())
            {
                System.out.printf("$%10.2f (%s)%n",d,d<0? "debit":"credit");
            }

        }
    }


}
