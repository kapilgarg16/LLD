public class Number implement ArithmeticExpression
{
    public int num;

    public Number(int num){
        this.num = num;
    }

    public int evaluate(){
        return num;
    }
}