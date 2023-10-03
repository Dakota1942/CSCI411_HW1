import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Scanner;

public class HW1 {
    public static void main(String args[]) {
        
        ArrayList<String> history = new ArrayList<>();

        while(true) {
                // print the bash symbol
                System.out.print("bash>");

                // read input from the keyboard - input is a command
                Scanner input = new Scanner(System.in);
                String command = input.nextLine();
                
                // add the command to the history
                history.add(command);

                // split the command into tokens
                String[] tokens = command.split(" ");

                if(command.equalsIgnoreCase("history")) {
                    for(int i=0; i<history.size(); i++) {
                        System.out.println(i+1 + ". " + history.get(i));
                    }
                } else if(command.equalsIgnoreCase("exit")) {
                    break;
                }

                if(tokens[0].equals("ls")) {
                    tokens[0]="dir";
                } else if(tokens[0].equals("pwd")) {
                    tokens[0]="cd";
                } else if(tokens[0].equals("cp")) {
                    tokens[0]="copy";
                } else if(tokens[0].equals("rm")) {
                    tokens[0]="del";
                } else if(tokens[0].equals("man")) {
                    tokens[0]="help";
                } else if(tokens[0].equals("nano")) {
                    tokens[0]="notepad";
                } else if(tokens[0].equals("grep")) {
                    tokens[0]="find";
                } else if(tokens[0].equals("uname")) {
                    tokens[0]="ver";
                } else if(tokens[0].equals("which")) {
                    tokens[0]="where";
                } else if(tokens[0].equals("env")) {
                    tokens[0]="set";
                } else if(tokens[0].equals("ifconfig")) {
                    tokens[0]="ipconfig";
                }

                try{
                    int size = tokens.length;
                    if(size==1) {
                        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", tokens[0]);
                        // start the process
                        Process process = pb.start();

                        // Obtain the input stream
                        Scanner sc = new Scanner(process.getInputStream());
                        // display the information from the process
                        while(sc.hasNext()) {
                            System.out.println(sc.nextLine());
                        }

                        // wait for the process to finish
                        process.waitFor();
                    } else if(size==2) {
                        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", tokens[0], tokens[1]);
                        // start the process
                        Process process = pb.start();

                        // Obtain the input stream
                        Scanner sc = new Scanner(process.getInputStream());
                        // display the information from the process
                        while(sc.hasNext()) {
                            System.out.println(sc.nextLine());
                        }

                        // wait for the process to finish
                        process.waitFor();
                    } else if(size==3) {
                        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", tokens[0], tokens[1], tokens[2]);
                        // start the process
                        Process process = pb.start();

                        // Obtain the input stream
                        Scanner sc = new Scanner(process.getInputStream());
                        // display the information from the process
                        while(sc.hasNext()) {
                            System.out.println(sc.nextLine());
                        }

                        // wait for the process to finish
                        process.waitFor();
                    }

                } catch(Exception err) {
                    err.printStackTrace();
                } 

        }

    }    

}
