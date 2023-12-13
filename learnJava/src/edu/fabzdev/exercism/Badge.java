package edu.fabzdev.exercism;

public class Badge {
    public String print(Integer id, String name, String department) {
        String badge = null;
        if(id == null){
            if(department == null){
                badge = String.format("%s - OWNER", name);
            }else {
                badge = String.format("%s - %S", name, department);
            }
        } else if(department == null){
            badge = String.format("[%d] - %s - OWNER", id, name);
        } else {
            badge = String.format("[%d] - %s - %S", id, name, department);
        }
        return badge;
    }

    public static void main(String[] args) {
        Badge bg = new Badge();
        System.out.println(bg.print(734, "Ernest Johnny Payne", "Strategic Communication"));
    }
}
