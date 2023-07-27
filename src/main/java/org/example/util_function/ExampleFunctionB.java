package org.example.util_function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;
import java.util.function.Function;

public class ExampleFunctionB {

static Function<BankAccount,BankAccount> openAccount = ba ->{
    ba.setBalance(100000L);
    return ba;
};

    public static void main(String[] args) {

        BankAccount newClient = openAccount.apply(new BankAccount(UUID.randomUUID(),0L,"BBVA"));

        System.out.println(newClient);
    }

}






@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
class  BankAccount {
    private UUID id;
    private Long balance;
    private String bankName;


}
