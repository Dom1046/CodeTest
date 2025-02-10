package code.test;

public class CodeTest44 {
    public int solution( String[] args )
    {
        int sum = 0;
        for(String arg : args){
            sum += Integer.parseInt(arg);
        }
        return sum;
    }
    public int solution2( String[] args )
    {
        int sum = 0;
        for (int i = 0; i < args.length; i++){
            sum += Integer.parseInt(String.valueOf(args[i].charAt(0)));
        }
        return sum;
    }
    public int solution3( String[] args )
    {
        int sum = 0;
        int size = args.length;
        int index = 0;
        while (size>0){
            sum += Integer.parseInt(args[index++]);
            size--;
        };
        return sum;
    }
}
