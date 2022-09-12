public class A {
    
    public synchronized void d1(B b){
        System.out.println("Thread1 start execution of d1() method");

        try{
            Thread.sleep(6000);
        }
        catch(InterruptedException e){}
            
        System.out.println("Thread1 trying to call B's last method");
        b.last();
    }
    public synchronized void last(){
        System.out.println("inside a, this is last() method");
    }
}
 class B{

    public synchronized void d2(A a){
        System.out.println("Thread2 starts execution of d2() method");

        try{
            Thread.sleep(6000);
        }catch(InterruptedException f){}
        a.last();
        System.out.println("Thread1 try to call A's last()");

     }
    public synchronized void last(){
        System.out.println("insisde b this is the last method");

    }
}

  class deadLock extends Thread{

    A a= new A();
    B b = new B();
    //this method also execute by main thread
    public void m1(){
        this.start();
        a.d1(b);
    }
    public void run(){
        b.d2(a); //this line execute by child thread.
    }


    public static void main(String[] args) {
        deadLock d = new deadLock(); //here main thread
        d.m1(); // execute by main thread
    }
 }   
    



    

