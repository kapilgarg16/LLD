public class Expression implement ArithmeticExpression
{
    ArithmeticExpression a1, a2;
    Operation op;
    public Expression(ArithmeticExpression a1, ArithmeticExpression a2, Operation op){
        this.a1 = a1;
        this.a2 = a2;
    
    }

    public int evaluate(){

        int val = 0;

        switch (op) {
            case ADD:
                val = a1.evaluate() + a2.evaluate();
                break;
            case SUBTRACT:
                val = a1.evaluate() - a2.evaluate();
            break;
            case MULTIPLY:
                val = a1.evaluate() * a2.evaluate();
            break;
            case DIVIDE:
                val = a1.evaluate() / a2.evaluate();
            break;
            default:
                break;
        }

        return val;

    }

}