package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
        '
public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userChoice = myScanner.nextLine();
        List<String> strings = Arrays.asList("abstract", "assert", "boolean", "break", "byte");
        List<String> strings = Arrays.asList("char", "catch", "continue", "default", "byte");
        boolean allMatch = strings.stream().allMatch(s -> s.equals(str));
                System.out.println("You have entered an invalid choice.");
        }
        switch(userChoice)

    }
}
        /*abstract	assert	boolean	break
          byte	case	catch	char
          class	const	continue	default


             do	double	else	enum
                  extends	final	finally	float
               for	goto	if	implements
              import	instanceof	int	interface
                 long	native	new	package
            private	protected	public	return
             short	static	strictfp	super
            switch	synchronized	this	throw
            throws	transient	try	void
            volatile	while	 true	 false
             null		*/