package com.metatech.JavaCat;

import org.slf4j.Logger;;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger = Testslf4j.getLogger(App.class);

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        logger.info("App is doing something");
    }
}
