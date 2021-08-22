package homework11;

public class Number {

    private int k;
    private int n;

    public Number(int n){
        k = 1;
        this.n = n;
    }

    public synchronized boolean fizz(){
        if(k > n)
            return false;
        if(k % 3 == 0 && k % 5 != 0) {
            System.out.print("fizz");
            if (k < n)
                System.out.print(", ");
            k++;
        }
        return true;
    }

    public synchronized boolean buzz(){
        if(k > n)
            return false;
        if(k % 5 == 0 && k % 3 != 0) {
            System.out.print("buzz");
            if (k < n)
                System.out.print(", ");
            k++;
        }
        return true;
    }

    public synchronized boolean fizzbuzz(){
        if(k > n)
            return false;
        if(k % 5 == 0 && k % 3 == 0) {
            System.out.print("fizzbuzz");
            if (k < n)
                System.out.print(", ");
            k++;
        }
        return true;
    }

    public synchronized boolean number(){
        if(k > n)
            return false;
        if(!(k % 5 == 0 || k % 3 == 0)) {
            System.out.print(k);
            if (k < n)
                System.out.print(", ");
            k++;
        }
        return true;
    }
}
