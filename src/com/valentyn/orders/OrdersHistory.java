package com.valentyn.orders;

import java.io.FileWriter;
import java.io.IOException;

public class OrdersHistory {
    public void addEntityHistory(String order) {
        try (FileWriter fileWriter = new FileWriter("src/resources/history.txt", true)) {
            fileWriter.write(order);
            fileWriter.append('\n');
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
