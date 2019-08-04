package linearalgebra;

import java.util.Arrays;

public class ArrayOp {

    private Op op;
    private Fraction[] params;

    /**
     * A row operation
     * @param op the operation that is performed
     * @param params the parameters of operation
     */
    public ArrayOp(Op op, Fraction[] params){
        this.op = op;
        //the parameter of operation must be in the following format:
        // for SCALAR_MULTIPLICATION, param = {the row to be multiplied, the multiplier}
        // for ROW_SWAP, param = {first row to be swapped, second row to be swapped}
        // for MULTIPLY_ADDITION, param = {row to be multiplied, multiplier, row to be added to}
        this.params = params;
    }

    public enum Op{

        SCALAR_MULTIPLICATION,
        ROW_SWAP,
        MULTIPLY_ADDITION;

    }

    public Op getOp(){
        return op;
    }

    public Fraction[] getParams(){
        return params;
    }

    public static Matrix operateOperationOnMatrix(Matrix m, ArrayOp op){

        Matrix temp = m.clone();

        switch (op.op){
            case ROW_SWAP:
                temp.rowOp_Swap(op.params[0].toInt(false), op.params[1].toInt(false));
                break;
            case MULTIPLY_ADDITION:
                temp.rowOp_Multiply(op.params[0].toInt(false), op.params[1]);
                temp.rowOp_Add(op.params[0].toInt(false), op.params[2].toInt(false));
                temp.rowOp_Multiply(op.params[0].toInt(false), op.params[1].inverse());
                break;
            case SCALAR_MULTIPLICATION:
                temp.rowOp_Multiply(op.params[0].toInt(false), op.params[1]);
                break;
            default:
                return temp;
        }
        return temp;
    }

    @Override
    public String toString(){
        return op.toString() + Arrays.toString(params);
    }

}
