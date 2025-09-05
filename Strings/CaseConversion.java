package Strings;

public class CaseConversion {
    class Main {

        public static void main(String[] args) {

            // input=tGhkk

            // output=TgHKK

            String str="tGhkk";

            for(int i=0;i<str.length();i++)

            {

                Character ch=str.charAt(i);

                if(Character.isLowerCase(ch))

                {

                    str = str.substring(0, i) + Character.toUpperCase(ch)+ str.substring(i+1);

                }

                else{

                    str = str.substring(0, i) + Character.toLowerCase(ch)+ str.substring(i+1);

                }

            }

            System.out.println("The New String after converting is: "+str);

        }

    }
}
