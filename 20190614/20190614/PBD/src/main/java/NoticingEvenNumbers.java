public class NoticingEvenNumbers {
    public static void main(String[] args) {
        int num;

        for (int i=1 ; i<21; i++ )
        {    num = i%2 ;
            if ( num==1 )
            {
                System.out.println( i );
            }
    else
            {
                System.out.println(i  + ">" );
            }
        }

    }
}
