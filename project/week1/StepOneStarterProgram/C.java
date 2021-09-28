
/**
 * Write a description of mytest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


interface C {
     int m(int i);
     long m(long i);
}

class A implements C
{
    int i=m(2);
}
    