package com.functionalinterface.dataserialization;

import java.io.*;

public class BackupProcessor {
    public static void backupObject(Object obj) {
        if (!(obj instanceof BackupSerializable)) {
            System.out.println(" Object not marked for backup");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("backup.dat"))) {

            oos.writeObject(obj);
            System.out.println(" Object backed up successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}