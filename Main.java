package StudentInfo;

import java.io.*;
import java.util.*;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static Student register(List<Student> l){
        System.out.print("Student Number: ");
        String sn = sc.next();
        if (exist(l, sn) >= 0){
            System.out.print("Student already exist!\n");
            return register(l);
        }
        System.out.print("First Name: ");
        String fn = sc.next();
        System.out.print("Middle Initial: ");
        char mi = sc.next().toCharArray()[0];
        System.out.print("Last Name: ");
        String ln = sc.next();
        System.out.print("Program: ");
        String c = sc.next();
        System.out.print("Year Level: ");
        int yl = sc.nextInt();
        return new Student(sn, fn, mi, ln, c, yl);
    }

    public static int retrieve(List<Student> l){
        System.out.print("Search Student: ");
        String sn = sc.next();
        return exist(l, sn);

    }

    public static void delete(List<Student> l){
        System.out.print("Delete Student: ");
        String sn = sc.next();
        int i = exist(l, sn);
        if (i >= 0){
            l.remove(i);
        } else {
            System.out.println("Student Does not Exit");
        }
    }

    public static void update(List<Student> l){
        System.out.print("Enter Student Number: ");
        String sn = sc.next();
        System.out.print("First Name: ");
        String fn = sc.next();
        System.out.print("Middle Initial: ");
        char mi = sc.next().toCharArray()[0];
        System.out.print("Last Name: ");
        String ln = sc.next();
        System.out.print("Program: ");
        String c = sc.next();
        System.out.print("Year Level: ");
        int yl = sc.nextInt();
        int i = exist(l, sn);
        l.remove(i);
        l.add(i, new Student(sn, fn, mi, ln, c, yl));
    }

    public static void save(List<Student> l){
        if (!l.isEmpty()) {
            try {
                File file = new File("db.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }

                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (Student s : l) {
                    bw.write(s.getStudentNumber());
                    bw.newLine();
                    bw.write(s.getFirstName());
                    bw.newLine();
                    bw.write(s.getMiddleInitial());
                    bw.newLine();
                    bw.write(s.getLastName());
                    bw.newLine();
                    bw.write(s.getCourse());
                    bw.newLine();
                    bw.write(String.valueOf(s.getYearLevel()));
                    bw.newLine();
                }

                bw.close();

                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int exist(List<Student> l, String sn){
        if (l.isEmpty()) { return -1;}

        for (Student s: l){
            if (s.getStudentNumber().equals(sn)){
                return l.indexOf(s);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Student> l = new ArrayList<>();
        BufferedReader br = null;
        int yl;
        String sn = "", fn = "", ln = "", c = "";
        char mi = ' ';
        try {
            String sCurrentLine;
            int line = 1;
            br = new BufferedReader(new FileReader("db.txt"));
            while ((sCurrentLine = br.readLine()) != null) {
                if (line == 1){
                    sn = sCurrentLine; line++;
                } else if (line == 2) {
                    fn = sCurrentLine; line++;
                } else if (line == 3 ){
                    mi = sCurrentLine.charAt(0); line++;
                } else if (line == 4){
                    ln = sCurrentLine; line++;
                } else if (line == 5){
                    c = sCurrentLine; line++;
                } else if (line == 6){
                    yl = Integer.parseInt(sCurrentLine);
                    line = 1;
                    l.add(new Student(sn, fn, mi, ln, c, yl));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        boolean cont = true;
        while(cont){
            System.out.println("1. Register\n2. Search\n3. Update\n4. Delete\n5. Save\n6. Exit");
            System.out.print("Enter Option: ");
            int opt = sc.nextInt();
            if (opt == 1){
                l.add(register(l));
                System.out.println("Student Added!\n");
            } else if (opt == 2){
                int i = retrieve(l);
                System.out.println(l.size());
                if (i >= 0) {
                    System.out.println(l.get(i));
                } else {
                    System.out.println("Student Does Not Exist");
                }
            } else if (opt == 3){
                update(l);
                System.out.println("Student Info Updated");
            } else if (opt == 4){
                delete(l);
            } else if (opt == 5){
                save(l);
            } else if (opt == 6){
                cont = false;
            } else {
                System.out.println("Input a valid Option");
            }
        }
    }
}
