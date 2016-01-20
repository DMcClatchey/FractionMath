//David McClatchey, CSC2310, J.L. Bhola, Thursday 4-4:50 Classroom South 226
package hw4;

public class Driver {
    private String frac1;
    private String frac2;
    private int numerator;
    private int denominator;
    
    public Driver(String f1, String f2){//consructor
        frac1=f1;
        frac2=f2;
    }
    
    public void setfrac1(String f1){
        frac1 = f1;			//setter
	}
    public String getfrac1(){
	return frac1;			//getter
    }
    public void setfrac2(String f2){
        frac2 = f2;			//setter
	}
    public String getfrac2(){
	return frac2;			//getter
    }
    public void setnumerator(int n){
        numerator=n;
    }
    public int getnumerator(){
        return numerator;
    }
    public void setdenominator(int d){
        denominator=d;
    }
    public int getdenominator(){
        return denominator;
    }
    public String fractionredux(){
        if(numerator%denominator==0){//case when the answer is an integer, fastest calculation, goes first
            String x = Integer.toString(numerator/denominator);//must convert to string to be compatible with type
            return x;
        }
        else if((Math.abs(numerator))<Math.abs(denominator)){//case when numerator's absolute value is smaller than denominator's absolute value and fraction can be simplified further
                for(int i=Math.abs(numerator);i>1;i--){
                    if((numerator%i==0)&&(denominator%i==0)){
                        numerator=numerator/i;
                        denominator=denominator/i;
                        return numerator + "/" + denominator;
                    }                     
                }  
        }
        else
            for(int i=Math.abs(denominator);i>1;i--){//case when denominator's absolute value is smaller than numerator's absolute value and fraction can be simplified further
                    if((numerator%i==0)&&(denominator%i==0)){
                        numerator=numerator/i;
                        denominator=denominator/i;
                        return numerator + "/" + denominator;
                    }
            }
        return numerator + "/" + denominator;//if none of the if statements above apply, then the fraction, as is, cannot be simplified further
    }
        
}
