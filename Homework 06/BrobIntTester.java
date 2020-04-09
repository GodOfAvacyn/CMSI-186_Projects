/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* ===============    BrobIntTester Class File    ===============
* @author Aiden Meyer
* @version 1.0.0
* 
* DESCRIPTION
* Basically a bunch of callable methods that allow us to test
* our BrobInt file.
* 
* METHODS
* public static void main (String[] args)     Runs simple tests.
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ **/
public class BrobIntTester {
    public static void main( String[] args ) {
        System.out.println( "\n  BrobInt Testing!\n" );
  
        BrobInt b1 = null;;
        try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "147258369789456123" ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
        try { System.out.println( "   expecting: 147258369789456123\n     and got: " + b1.toString() ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
  
        System.out.println( "\n    Multiplying 82832833 by 3: " );
        try { System.out.println( "      expecting: 248498499\n        and got: " + new BrobInt("82832833").multiply( BrobInt.THREE ) ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
  
        System.out.println( "\n    Multiplying 3 by 82832833 and adding 1: " );
        try { System.out.println( "      expecting: 248498500\n        and got: " + BrobInt.THREE.multiply( new BrobInt( "82832833" ) ).add( BrobInt.ONE ) ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

        System.out.println( "\n    Dividing 4472385623849647 by 1836491283: " );
        try { System.out.println( "      expecting: 2435228\n        and got: " + new BrobInt("4472385623849647").divide( new BrobInt("1836491283") ) ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
  
        try { System.out.println( "\n\n   Making a new BrobInt: " ); b1 = new BrobInt( "-99999" ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
        System.out.println( "\n   Testing equals() method on b1 of -99999 and b2 of 99999: " );
        try { System.out.println( "      expecting: false\n        and got: " + b1.equals( new BrobInt( "99999" ) ) ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
        System.out.println( "\n   Testing equals() method on b1 of -99999 and b2 of -99999: " );
        try { System.out.println( "      expecting: true\n        and got: " + b1.equals( new BrobInt( "-99999" ) ) ); }
        catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
    }
}