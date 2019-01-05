package by.htp.carservice.main;


import by.htp.carservice.hashpass.PasswordHash;


public class Runner {
    public static void main(String[] args) {

        PasswordHash hash = new PasswordHash();

        System.out.println(hash.getHashPAss("admin"));

    }
}
