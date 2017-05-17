package Data;

import Domain.Operator;
import java.util.LinkedList;
/**
 * @author Samuel
 */
public class OperatorData {
    static LinkedList<Operator> operators;

    public OperatorData() {
        operators = null;
    }

    public void insertClerk(Operator operator) {

        operators.add(operator);
    }

    public void removeClerk(Operator operator) {

        operators.remove(operator);
    }

    public LinkedList<Operator> getAllOperators() {
        return operators;
    }

    public Operator findClerkById(String operatorId) {

        Operator operator = null;

        for (Operator currentOperator : operators) {

            if (currentOperator.getIdentification().equalsIgnoreCase(operatorId)) {

                operator = currentOperator;
            }
        }
        return operator;
    }
}