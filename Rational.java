//Anna Qu
//Pd 9
//HW27
//2013-11-18

public class Rational {

    private int num;
    private int den;

    //------------------PHASE UNO-------------------

    //constructor - creates a new Rational with the value of 0/1
    public Rational() {
	num = 0;
	den = 1;
    }

    //constructor - takes 2 parameters, num & den
    //if an invalid denominator is attempted, should print a message and set the number to 0/1
    public Rational(int n, int d) {
	num = n;
	den = d;
	if ( d == 0 ) {
	    System.out.println("Invalid denominator!");
	    //this();
	    num = 0;
	    den = 1;
	}
    }

    //accessor methods
    public int getNum() {
	return num;
    }

    public int getDen() {
	return den;
    }

    //toString - returns a string representation of the rational number
    public String toString() {
	return "" + num + "/" + den;
    }

    //floatValue - returns a floating point value of the number
    //uses the most precise floating point primitive
    public double floatValue() {
	return (num * 1.0) / (den * 1.0);
    }

    /*multiply - takes 1 Rational object as a parameter and multiplies it by
      this Rational object 
      does not return any value
      should modify this object and leave the parameter alone
      need not reduce the fraction*/
    public void multiply( Rational r ) {
	num *= r.getNum();
	den *= r.getDen();
    }

    //divide - works the same as multiply, except the operation is division
    public void divide( Rational r ) {
	num /= r.getNum();
	den /= r.getDen();
    }

    //------------------PHASE DOS-------------------

    //add - takes 1 Rational object and adds it to original object
    public void add( Rational r ) {
	num = ( num * r.getDen() ) + ( r.getNum() * den );
	den *= r.getDen(); 
    }

    //subtract - works the same as add, except operation is subtraction
    public void subtract( Rational r ) {
	num = ( num * r.getDen() ) - ( r.getNum() * den );
	den *= r.getDen();
    }

    //gcd - returns gcd of the num and den, first # must be greater
    public int gcd() {
	if ( den == 0 )
	    return num;
	else
	    return gcd( den, num % den );
    }

    //reduce - using gcd, changes this Rational to one in reduced form
    public void reduce() {
	int factor = gcd();
	if ( factor != 0 ) { 
	    num /= factor;
	    den /= factor;
	}
    }

    //------------------PHASE TRES-------------------

    //static gcd method that will take num and den inputs
    public static int gcd( int n, int d ) {
	if ( d == 0 )
	    return n;
	else
	    return gcd( d, n % d );
    }

    /*compareTo - takes a Rational and compares it to calling object
      returns 0 if two numbers are equal
      returns pos int if calling number is larger than parameter
      returns neg int if calling number is smaller*/
    public int compareTo( Rational r ) {
	if (( num == r.getNum() ) && ( den == r.getDen() )) {
		return 0;
	    }
	else if ( floatValue() > r.floatValue() ) {
	    return 1;
	}
	else {
	    return -1;
	}
    }

    //------------------TESTING-------------------

    public static void main( String[] args ) {

	Rational k = new Rational(1,0);//to test second constructor
	System.out.println(k);

	Rational r = new Rational(2,3);
	Rational s = new Rational(1,2);
	System.out.println(r + ": " + r.floatValue());

	r.multiply(s);
	System.out.println(r + ": " + r.floatValue());
	System.out.println(s + ": " + s.floatValue());//should stay as .5

	r.divide(s);
	System.out.println(r + ": " + r.floatValue());
	System.out.println(s + ": " + s.floatValue());//should stay as .5

	r.add(s);
	System.out.println(r + ": " + r.floatValue());
	System.out.println(s + ": " + s.floatValue());//should stay as .5

	r.subtract(s);
	System.out.println(r + ": " + r.floatValue());
	System.out.println(s + ": " + s.floatValue());//should stay as .5

	Rational m = new Rational(2,2);
	r.multiply(m);
	System.out.println(r + ": " + r.floatValue());
	r.reduce();//should reset r completely
	System.out.println(r + ": " + r.floatValue());

	Rational e = new Rational(r.getNum(),r.getDen());//given same values as R
	System.out.println(r.compareTo(e));//should return 0
	System.out.println(r.compareTo(m));//should return -1
    }
    
}
