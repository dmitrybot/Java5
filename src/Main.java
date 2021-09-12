import java.util.Scanner;

public class Main {
    static int ans4;
    static boolean e7 = true;

    public static long gcd(long a, long b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long mul(long a, long b, long m){
        if(b==1)
            return a;
        if(b%2==0){
            long t = mul(a, b/2, m);
            return (2 * t) % m;
        }
        return (mul(a, b-1, m) + a) % m;
    }

    public static long pows(long a, long b, long m){
        if(b==0)
            return 1;
        if(b%2==0){
            long t = pows(a, b/2, m);
            return mul(t , t, m) % m;
        }
        return ( mul(pows(a, b-1, m) , a, m)) % m;
    }

    public static void ex7(int x, int a){
        if (x % a == 0) {
            System.out.print(a + " ");
            e7 = false;
            ex7(x / a, a);
        }else if(a * a <= x){
            ex7(x, a + 1);
        } else {
            if (e7) System.out.println(x);
        }
    }

    public static boolean ex6(long x){
        if(x == 2)
            return true;
        for(int i = 0; i < 100; i++){
            long a = (long) (Math.random() * (x - 2)) + 2;
            if (gcd(a, x) != 1)
                return false;
            if( pows(a, x - 1, x) != 1)
                return false;
        }
        return true;
    }

    public static void ex3(int a, int b){
        System.out.println(a);
        if (a > b){
            ex3(a - 1, b);
        } else if (a < b){
            ex3(a + 1, b);
        }
    }

    public static void ex4(int a, int b, int c, int d){
        for(int i = 1; i < 10; i++){
            if (d + i < b){
                if (c + 1 != a){
                    ex4(a, b, c + 1, d + i);
                }
            } else if (d + i == b){
                ans4++;
            }
        }
        if (c != 0 && c + 1 != a){
            ex4(a, b, c + 1, d);
        }
    }

    public static void ex5(int a, int b){
        if (a == 0){
            System.out.println(b);
        } else {
            ex5(a / 10, b + a % 10);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, a, b;
        System.out.print("Введите номер упражнения(3, 4, 5, 6, 7) или 0, если хотите завершить работу программы: ");
        num = in.nextInt();
        while(num != 0){
            switch (num){
                case 3:
                    System.out.println("Введите два целый числа: ");
                    a = in.nextInt();
                    b = in.nextInt();
                    ex3(a, b);
                    break;
                case 4:
                    System.out.println("Введите два натуральных числа(количество цифр в числе и требуемую сумму цифр): ");
                    a = in.nextInt();
                    b = in.nextInt();
                    ex4(a, b, 0, 0);
                    System.out.println(ans4);
                    ans4 = 0;
                    break;
                case 5:
                    System.out.println("Натуральное число: ");
                    a = in.nextInt();
                    ex5(a, 0);
                    break;
                case 6:
                    System.out.println("Натуральное число: ");
                    a = in.nextInt();
                    if (ex6(a))
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                    break;
                case 7:
                    System.out.println("Натуральное число: ");
                    a = in.nextInt();
                    e7 = true;
                    ex7(a, 2);
                    System.out.println();
                    break;
            }
            System.out.print("Введите номер упражнения(3, 4, 5, 6, 7) или 0, если хотите завершить работу программы: ");
            num = in.nextInt();
        }
    }
}
