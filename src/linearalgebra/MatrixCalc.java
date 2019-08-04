package linearalgebra;

import java.util.ArrayList;

public class MatrixCalc {

    private Matrix startState, endState;
    private ArrayList<ArrayOp> arrayOps;

    public MatrixCalc(){
        startState = null;
        endState = null;
        arrayOps = new ArrayList<>();
    }

    public void setStartState(Matrix startState){
        this.startState = startState;
    }

    public void setEndState(Matrix endState){
        this.endState = endState;
    }

    public void addArrayOp(ArrayOp op){
        arrayOps.add(op);
    }

    public Matrix getStartState(){
        if(startState != null)
            return startState;
        else
            throw new NullPointerException();
    }

    public Matrix getEndStateState(){
        if(endState != null)
            return endState;
        else
            throw new NullPointerException();
    }

    public ArrayList<ArrayOp> getArrayOps(){
        return arrayOps;
    }



}
