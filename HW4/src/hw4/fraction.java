//David McClatchey, CSC2310, J.L. Bhola, Thursday 4-4:50 Classroom South 226
package hw4;
import java.util.*;

public class fraction {

    public static void main(String[] args) {
        String prompt = "yes";
        while(!prompt.equals("no")){
            
        Driver fracs= new Driver("a","b");
        System.out.println("Please enter fraction 1 in the form \"a/b\"." );
        Scanner s = new Scanner(System.in);
        String fractone = s.nextLine();
        fracs.setfrac1(fractone);
        System.out.println("Please enter your fraction 2 in the form \"a/b\"." );
        String fracttwo = s.nextLine();
        fracs.setfrac2(fracttwo);
        System.out.println("Your fractions are " + fracs.getfrac1()+ " and " +fracs.getfrac2() + ".");
        
        int slash1 = fracs.getfrac1().indexOf('/');//finds position of "/" to get each side of fraction
        int slash2 = fracs.getfrac2().indexOf('/');
        String numerator1 = fracs.getfrac1().substring(0, slash1);
        String numerator2 = fracs.getfrac2().substring(0, slash2);
        String denominator1 = fracs.getfrac1().substring(slash1+1, fracs.getfrac1().length());
        String denominator2 = fracs.getfrac2().substring(slash2+1, fracs.getfrac2().length());
        
        int numer1 = Integer.parseInt(numerator1);//converts string back to int
        int numer2 = Integer.parseInt(numerator2);
        int denom1 = Integer.parseInt(denominator1);
        int denom2 = Integer.parseInt(denominator2);
        
        //The next four if statements make it so negatives cancel and negatives in the denominator are moved to the numerator, or else some calculations do not give the correct result
        if(numer1<0 && denom1<0){//if both numerator and denominator are negative, makes negatives cancel
            numer1=numer1*(-1);
            denom1=denom1*(-1);
        }
        if(numer1>0 && denom1<0){//if numerator positive and denominator negative, makes numerator negative and denominator positive. Makes it possible to use fractions that have negative denominators
            numer1=numer1*(-1);
            denom1=denom1*(-1);
        }
        if(numer2<0 && denom2<0){//if both numerator and denominator are negative, makes negatives cancel
            numer2=numer2*(-1);
            denom2=denom2*(-1);
        }
        if(numer2>0 && denom2<0){//if numerator positive and denominator negative, makes numerator negative and denominator positive. Makes it possible to use fractions that have negative denominators
            numer2=numer2*(-1);
            denom2=denom2*(-1);
        }
        
        //addition case
        int additionnumerator = numer1*denom2+numer2*denom1;
        int additiondenominator = denom1*denom2;
        fracs.setnumerator(additionnumerator);
        fracs.setdenominator(additiondenominator);
        System.out.println("When you add the fractions together, you get " + fracs.fractionredux());
        
        //subtraction case
        int subtractionnumerator = numer2*denom1-numer1*denom2;
        int subtractiondenominator = denom1*denom2;
        fracs.setnumerator(subtractionnumerator);
        fracs.setdenominator(subtractiondenominator);
        System.out.println("When you subtract the first fraction from the second, you get " + fracs.fractionredux());
        
        //multiplication case
        int multnumerator = numer1*numer2;
        int multdenominator = denom1*denom2;
        fracs.setnumerator(multnumerator);
        fracs.setdenominator(multdenominator);
        System.out.println("When you multiply the fractions together, you get " + fracs.fractionredux());
        
        //division case
        int divnumerator = numer1*denom2;
        int divdenominator = numer2*denom1;
        if(divnumerator<0 && divdenominator<0){//if both numerator and denominator are negative, makes both positive
            divnumerator=divnumerator*(-1);
            divdenominator=divdenominator*(-1);
        }
        if(divnumerator>0 && divdenominator<0){//if denominator negative and numerator positive, makes denominator positive and numerator negative
            divnumerator=divnumerator*(-1);
            divdenominator=divdenominator*(-1);
        }
        fracs.setnumerator(divnumerator);
        fracs.setdenominator(divdenominator);
        System.out.println("When you divide the first fraction by the second fraction, you get " + fracs.fractionredux());
        
        //Prompt to play again, only "yes" and "no" are acceptable responses
        System.out.println("Would you like to play again?");
        prompt= s.nextLine().toLowerCase();
        while(!prompt.equals("yes") && !prompt.equals("no")){
            System.out.println("Please type \"yes\" or \"no\"");
            prompt= s.nextLine().toLowerCase();
        }
        }
        System.out.println("Ok, thanks for playing!");
    } 
}
