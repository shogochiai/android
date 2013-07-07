//Input and Calculate
package com.example.test1;

private void ProcessKeypadInput(KeypadButton keypadButton) {
        // Toast.makeText(this, keypadButton.getText(),
        // Toast.LENGTH_SHORT).show();
        String text = keypadButton.getText().toString();
        String currentInput = userInputText.getText().toString();

        int currentInputLen = currentInput.length();
        String evalResult = null;
        double userInputValue = Double.NaN;

        switch (keypadButton) {
        case BACKSPACE: // Handle backspace
            // If has operand skip backspace
            if (resetInput)
                return;

            int endIndex = currentInputLen - 1;

            // There is one character at input so reset input to 0
            if (endIndex < 1) {
                userInputText.setText("0");
            }
            // Trim last character of the input text
            else {
                userInputText.setText(currentInput.subSequence(0, endIndex));
            }
            break;
        case SIGN: // Handle -/+ sign
            // input has text and is different than initial value 0
            if (currentInputLen > 0 && currentInput != "0") {
                // Already has (-) sign. Remove that sign
                if (currentInput.charAt(0) == '-') {
                    userInputText.setText(currentInput.subSequence(1,
                            currentInputLen));
                }
                // Prepend (-) sign
                else {
                    userInputText.setText("-" + currentInput.toString());
                }
            }
            break;
        case CE: // Handle clear input
            userInputText.setText("0");
            break;
        case C: // Handle clear input and stack
            userInputText.setText("0");
            clearStacks();
            break;
        case DECIMAL_SEP: // Handle decimal seperator
            if (hasFinalResult || resetInput) {
                userInputText.setText("0" + mDecimalSeperator);
                hasFinalResult = false;
                resetInput = false;
            } else if (currentInput.contains("."))
                return;
            else
                userInputText.append(mDecimalSeperator);
            break;
        case DIV:
        case PLUS:
        case MINUS:
        case MULTIPLY:
            if (resetInput) {
                mInputStack.pop();
                mOperationStack.pop();
            } else {
                if (currentInput.charAt(0) == '-') {
                    mInputStack.add("(" + currentInput + ")");
                } else {
                    mInputStack.add(currentInput);
                }
                mOperationStack.add(currentInput);
            }

            mInputStack.add(text);
            mOperationStack.add(text);

            dumpInputStack();
            evalResult = evaluateResult(false);
            if (evalResult != null)
                userInputText.setText(evalResult);

            resetInput = true;
            break;
        case CALCULATE:
            if (mOperationStack.size() == 0)
                break;

            mOperationStack.add(currentInput);
            evalResult = evaluateResult(true);
            if (evalResult != null) {
                clearStacks();
                userInputText.setText(evalResult);
                resetInput = false;
                hasFinalResult = true;
            }
            break;
        case M_ADD: // Add user input value to memory buffer
            userInputValue = tryParseUserInput();
            if (Double.isNaN(userInputValue))
                return;
            if (Double.isNaN(memoryValue))
                memoryValue = 0;
            memoryValue += userInputValue;
            displayMemoryStat();

            hasFinalResult = true;

            break;
        case M_REMOVE: // Subtract user input value to memory buffer
            userInputValue = tryParseUserInput();
            if (Double.isNaN(userInputValue))
                return;
            if (Double.isNaN(memoryValue))
                memoryValue = 0;
            memoryValue -= userInputValue;
            displayMemoryStat();
            hasFinalResult = true;
            break;
        case MC: // Reset memory buffer to 0
            memoryValue = Double.NaN;
            displayMemoryStat();
            break;
        case MR: // Read memoryBuffer value
            if (Double.isNaN(memoryValue))
                return;
            userInputText.setText(doubleToString(memoryValue));
            displayMemoryStat();
            break;
        case MS: // Set memoryBuffer value to user input
            userInputValue = tryParseUserInput();
            if (Double.isNaN(userInputValue))
                return;
            memoryValue = userInputValue;
            displayMemoryStat();
            hasFinalResult = true;
            break;
        default:
            if (Character.isDigit(text.charAt(0))) {
                if (currentInput.equals("0") || resetInput || hasFinalResult) {
                    userInputText.setText(text);
                    resetInput = false;
                    hasFinalResult = false;
                } else {
                    userInputText.append(text);
                    resetInput = false;
                }

            }
            break;

        }

    }

	    private void clearStacks() {
	        mInputStack.clear();
	        mOperationStack.clear();
	        mStackText.setText("");
	    }

	    private void dumpInputStack() {
	        Iterator<String> it = mInputStack.iterator();
	        StringBuilder sb = new StringBuilder();
	
	        while (it.hasNext()) {
	            CharSequence iValue = it.next();
	            sb.append(iValue);
	
	        }
	
	        mStackText.setText(sb.toString());
	    }

	    private String evaluateResult(boolean requestedByUser) {
	        if ((!requestedByUser && mOperationStack.size() != 4)
	                || (requestedByUser && mOperationStack.size() != 3))
	            return null;
	
	        String left = mOperationStack.get(0);
	        String operator = mOperationStack.get(1);
	        String right = mOperationStack.get(2);
	        String tmp = null;
	        if (!requestedByUser)
	            tmp = mOperationStack.get(3);
	
	        double leftVal = Double.parseDouble(left.toString());
	        double rightVal = Double.parseDouble(right.toString());
	        double result = Double.NaN;
	
	        if (operator.equals(KeypadButton.DIV.getText())) {
	            result = leftVal / rightVal;
	        } else if (operator.equals(KeypadButton.MULTIPLY.getText())) {
	            result = leftVal * rightVal;
	
	        } else if (operator.equals(KeypadButton.PLUS.getText())) {
	            result = leftVal + rightVal;
	        } else if (operator.equals(KeypadButton.MINUS.getText())) {
	            result = leftVal - rightVal;
	
	        }
	
	        String resultStr = doubleToString(result);
	        if (resultStr == null)
	            return null;
	
	        mOperationStack.clear();
	        if (!requestedByUser) {
	            mOperationStack.add(resultStr);
	            mOperationStack.add(tmp);
	        }
	
	        return resultStr;
	    }

	    private String doubleToString(double value) {
	        if (Double.isNaN(value))
	            return null;
	
	        long longVal = (long) value;
	        if (longVal == value)
	            return Long.toString(longVal);
	        else
	            return Double.toString(value);
	
	    }

	    private double tryParseUserInput() {
	        String inputStr = userInputText.getText().toString();
	        double result = Double.NaN;
	        try {
	            result = Double.parseDouble(inputStr);
	
	        } catch (NumberFormatException nfe) {}
	        return result;
	
	    }

	    private void displayMemoryStat() {
	        if (Double.isNaN(memoryValue)) {
	            memoryStatText.setText("");
	        } else {
	            memoryStatText.setText("M = " + doubleToString(memoryValue));
	        }
	    }
}