package com.functionalinterface.sensitivedata;

class UserCredential implements SensitiveData{
    private String username;
    private String password;
    UserCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "UserCredentials [username=" + username + ", password=" + password + "]";
    }
}