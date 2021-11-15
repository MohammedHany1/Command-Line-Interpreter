package cmd;

import java.util.*;
public class Terminal {
    public String echo(String line){
        System.out.println(line);
        return line;
    }
    public String pwd(){
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        return currentDirectory;
    }
    public static void main(String[] args){
        Terminal cmd = new Terminal();
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter 1 to write the command or 2 to exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter the command: ");
                    String l = sc.nextLine();
                    String line = sc.nextLine();
                    Parser parser = new Parser(line);
                    switch (parser.getCommand()){
                        case "echo":
                            cmd.echo(parser.getArgument());
                        case "pwd":
                            cmd.pwd();
                        default:
                            System.out.println("Error Wrong Command!");
                    }
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Error Wrong Choice!");
            }
        }
    }
}
