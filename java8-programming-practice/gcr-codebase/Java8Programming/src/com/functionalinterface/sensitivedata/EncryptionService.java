package com.functionalinterface.sensitivedata;

class EncryptionService {
    static void encryptIfSensitive(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println(" Sensitive data detected");
        } else {
            System.out.println("Data is not sensitive");
        }
    }
}