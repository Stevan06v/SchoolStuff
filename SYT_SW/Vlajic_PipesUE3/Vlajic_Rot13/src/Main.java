import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int key = 0;

        if(args.length > 0){
            System.out.println(args[0]);
            key = Integer.parseInt(args[0]);
        }


        //jcnnq
        //hallo
        String saveStr = "";
        while(sc.hasNextLine()){
            saveStr = sc.nextLine();
            System.out.println("Encrypt: " +encrypt(saveStr,key));
            String encrypted = encrypt(saveStr, key);
            System.out.println("Decrypt: " + decrypt(encrypted,key));
            System.out.println("--------------------");
        }

    }

    // formel ceaser encrypt E(x):  (x + n) % 26
    // 26 + 6 % 26 = 6
    public static String encrypt(String line, int key){
        StringBuilder erg = new StringBuilder();
        for (char iterator : line.toCharArray()) {
            if(iterator != ' '){
                if(Character.isLowerCase(iterator)) {
                    erg.append( (char)((iterator  - 'a') + key % 26 + 'a') );
                }else if(Character.isUpperCase(iterator)){
                    erg.append( (char)((iterator - 'A') + key % 26 + 'A') );
                }
            }else{
                erg.append(iterator);
            }
        }
    return erg.toString();
    }


    // formel ceaser decrypt E(x): (x - n) % 26
    public static String decrypt(String line, int key){
        StringBuilder erg = new StringBuilder();
        for (char iterator : line.toCharArray()) {
            if(iterator != ' '){
                if(Character.isLowerCase(iterator)) {
                    erg.append( (char)( (((iterator - 'a') - key ) % 26 + 'a')));
                }else if(Character.isUpperCase(iterator)){
                    erg.append( (char)( ((( iterator - 'A') - key ) % 26 + 'A')));
                }
            }else{
                erg.append(iterator);
            }
        }
        return erg.toString();
    }

}
