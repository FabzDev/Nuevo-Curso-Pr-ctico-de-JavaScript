package edu.fabzdev.exercism;

public class Badge {
    public String print(Integer id, String name, String department) {
        return String.format("%s%s%S",
                id != null ? "[" + id + "] - " : "",
                name,
                department != null ? " - " + department.toUpperCase() : " - OWNER");
    }

    public static void main(String[] args) {
        Badge bg = new Badge();
        System.out.println(bg.print(874, "Ernest Johnny Payne", null));
    }
}
