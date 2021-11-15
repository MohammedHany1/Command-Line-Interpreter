package cmd;
import java.io.File;
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
    public void ls(){
        File currentDirectory = new File(".");
        File[] filesList = currentDirectory.listFiles();
        for(File f : filesList){
            System.out.println(f.getName());
        }
    }
    public  void mkdir(String argument){
        boolean check = false;
        for (int i = 0; i < argument.length(); i++){
            if(argument.charAt(i) == '\\'){
                check = true;
            }
        }
        if(check){
            File f1 = new File(argument);
            f1.mkdir();
        }
        else{
            ArrayList<String> newFoldersNames = new ArrayList<>(5);
            String name = "";
            for(int i = 0; i < argument.length(); i++){
                if(argument.charAt(i) == ' '){
                    newFoldersNames.add(name);
                    name = "";
                    continue;
                }
                name += argument.charAt(i);
            }
            newFoldersNames.add(name);
            String path;
            for(int i = 0; i < newFoldersNames.size(); i++){
                path = System.getProperty("user.dir") + '\\' + newFoldersNames.get(i);
                File f1 = new File(path);
                f1.mkdir();
            }
        }
    }
   /* public  void rmdir(String argument){
        if(argument.length() == 1) {
            File currentDirectory = new File(".");
            File[] filesList = currentDirectory.listFiles();
            for(File f : filesList){
                if(f is empty)
                    System.out.println(f.getName());
            }
            String path = System.getProperty("user.dir");
            File f1 = new File(path);
        }
        else{
            File f1 = new File(argument);
            f1.mkdir();
        }
    }*/
    public void chooseCommandAction(){
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the command: ");
            String line = sc.nextLine();
            Parser parser = new Parser(line);
            switch (parser.getCommand()){
                case "echo":
                    echo(parser.getArgument());
                    break;
                case "pwd":
                    pwd();
                    break;
                case "ls":
                    ls();
                    break;
                case "mkdir":
                    mkdir(parser.getArgument());
                    break;
                /*case "rmdir":
                    rmdir(parser.getArgument());
                    break;*/
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error Wrong Command, Please Try Again!");
                    break;
            }
        }
    }
    public static void main(String[] args){
        Terminal cmd = new Terminal();
        cmd.chooseCommandAction();
    }
}
