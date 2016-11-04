import java.io.*;
import java.util.*;


public class StudentDb{
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
        System.out.print("========\n");
        System.out.print("Favorite subject code: ");
        String cCode = sc.next();
        System.out.print("Description of Favorite subject: ");
        String cDesc = sc.next();
        System.out.print("Crush Name: ");
        String cName = sc.next();

        
        return new Student(sn, fn, mi, ln, c, yl, new Course(cCode, cDesc), cName);
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
        System.out.print("========\n");
        System.out.print("Favorite subject code: ");
        String cCode = sc.next();
        System.out.print("Description of Favorite subject: ");
        String cDesc = sc.next();
        System.out.print("Crush Name: ");
        String cName = sc.next();
        int i = exist(l, sn);
        l.remove(i);
        l.add(i, new Student(sn, fn, mi, ln, c, yl, new Course(cCode, cDesc), cName));
    }

    public static void save(List<Student> l){
        if (!l.isEmpty()) {
            try {
                File file = new File("db.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileOutputStream output = new FileOutputStream("db.txt");
                ObjectOutputStream ous = new ObjectOutputStream(output);
                ous.writeObject(l);

                ous.close();

                System.out.println("Done");

            } catch (Exception e) {
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
        List<Student> l = new ArrayList<Student>();
        BufferedReader br = null;
        int yl;
        String sn = "", fn = "", ln = "", c = "";
        char mi = ' ';
        try {
            File r = new File("db.txt");           
            if (r.length() == 0){
            	System.out.println("File is is Empty");
            } else {
            	ObjectInputStream ois = new ObjectInputStream(new FileInputStream(r));
	            l = (List<Student>) ois.readObject();
	        }
        } catch (Exception e) {
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
