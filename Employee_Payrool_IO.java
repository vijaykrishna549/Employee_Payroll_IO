package com.bridgelabz.test;
import java.io.*;
import java.util.*;

   class Employee_data implements Comparable {
        int id;
        String name;
        String address;
        int phoneNo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(int phoneNo) {
            this.phoneNo = phoneNo;
        }

        public int compareTo(Object ob) throws ClassCastException {
            if (!(ob instanceof Employee_data))
                throw new ClassCastException("Error");
            int ide = ((Employee_data) ob).getId();
            return this.id - ide;
        }
    }

    public class Employee_Payrool_IO {

        public static void main(String[] args) throws Exception {
            Scanner scan = new Scanner(System.in);
            int menu = 0;
            System.out.println();
            System.out.println("1. Accept Data");
            System.out.println("2. Search");
            System.out.println("3. Remove Data");
            System.out.println("4. List of all persons");
            System.out.println("5. Exit");
            boolean quit = false;
            do {
                System.out.print("Please enter your choice: ");
                menu = scan.nextInt();
                System.out.println();

                switch (menu) {
                    case 1:
                        System.out.print("Enter Employee ID: ");
                        int ID = scan.nextInt();
                        System.out.print("Enter Name: ");
                        String name = scan.next();
                        System.out.print("Enter Address: ");
                        String address = scan.next();
                        System.out.println("Enter Phone No: ");
                        int no = scan.nextInt();
                        FileWriter fw = new FileWriter(new File("directory.txt"), true);
                        BufferedWriter out = new BufferedWriter(fw);
                        out.write(ID + " " + name + " " + address + " " + no);
                        out.newLine();
                        out.close();
                        break;
                    case 2:
                        System.out.print("Enter name to search information: ");
                        String n = scan.next();
                        File f = new File("directory.txt");
                        try {
                            BufferedReader freader = new BufferedReader(new FileReader(f));
                            String s;
                            while ((s = freader.readLine()) != null) {
                                String[] st = s.split(" ");
                                String id = st[0];
                                String nm = st[1];
                                String add = st[2];
                                String phoneNo = st[3];
                                if (n.equals(nm)) {
                                    System.out
                                            .println("***********Information**************");
                                    System.out.println("Address : " + add);
                                    System.out.println("PhoneNo : " + phoneNo);
                                }
                            }
                            freader.close();
                        } catch (Exception e) {
                        }
                        break;
                    case 3:
                        System.out.println("\n Enter the name to remove");
                        name = scan.next();


                    case 4:
                        FileInputStream fis = new FileInputStream(new File("directory.txt"));
                        DataInputStream dis = new DataInputStream(fis);
                        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(dis));
                        String st;
                        ArrayList al = new ArrayList();
                        while ((st = reader.readLine()) != null) {
                            al.add(st);
                        }
                        Iterator itr;
                        for (itr = al.iterator(); itr.hasNext();) {
                            String str = itr.next().toString();
                            String[] splitSt = str.split(" ");
                            String id = "", na = "", ada = "", ph = "";
                            for (int i = 0; i < splitSt.length; i++) {
                                id = splitSt[0];
                                na = splitSt[1];
                                ada = splitSt[2];
                                ph = splitSt[3];
                            }
                            System.out.println(id + " " + na + " " + ada + " " + ph);
                        }
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid Entry!");
                }
            } while (!quit);
        }
    }

