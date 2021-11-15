package cmd;

public class Parser {
    private String command = "", argument = "";
    public Parser(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                for (int k = i+1; k < input.length(); k++){
                    argument += input.charAt(k);
                }
                break;
            }
            command += input.charAt(i);
        }
    }
    String getCommand(){
        return command;
    }
    String getArgument(){
        return argument;
    }
}
