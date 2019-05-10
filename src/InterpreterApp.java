public class InterpreterApp {

    public static void main(String[] args){
        Context context = new Context();
        Expression expression = context.evaluate("-1-2+3");
        System.out.println(expression.interpret());
    }
}

interface Expression{
    int interpret();
}

class NumberExpression implements Expression{
    int number;

    public NumberExpression(int number){
        this.number = number;
    }
    @Override
    public int interpret() {
        return number;
    }
}

class MinusOperation implements Expression{
    Expression left;
    Expression right;

    public MinusOperation(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class PlusOperation implements Expression{
    Expression left;
    Expression right;

    public PlusOperation(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class Context{
    Expression evaluate(String s){
        int pos = s.length() - 1;
        while (pos>0){
            if(Character.isDigit(s.charAt(pos))){
                pos--;

            }
            else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new NumberExpression(Integer.valueOf(s.substring(pos+1, s.length())));
                char operator = s.charAt(pos);
                switch (operator){
                    case '-':
                        return new MinusOperation(left, right);
                    case '+':
                        return new PlusOperation(left, right);
                }
            }
        }
        int result = Integer.valueOf(s);
        return new NumberExpression(result);
    }
}


