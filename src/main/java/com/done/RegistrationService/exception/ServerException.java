package com.done.RegistrationService.exception;

public abstract class ServerException extends RuntimeException {

    public ServerException(String message) {
        super(message);
    }

    public ServerException(
            String primaryMessage,
            String[] potentialCauses,
            String[] potentialSolutions
    ) {
        super(getCombinedMessage(primaryMessage, potentialCauses, potentialSolutions));
    }

    public static String getCombinedMessage(
            String primaryMessage,
            String[] potentialCauses,
            String[] potentialSolutions
    ) {
        String message = "\n**************\n";
        message += "\t" + primaryMessage + "\n";

        message += "\tPotential Causes:\n";
        for (int i = 0; i < potentialCauses.length; i++) {
            message += "\t\t" + i + ". " + potentialCauses[i] + "\n";
        }
        message += "\tPotential Solutions:\n";
        for (int i = 0; i < potentialSolutions.length; i++) {
            message += "\t\t" + i + ". " + potentialSolutions[i] + "\n";
        }

        message += "\n**************\n";
        return message;
    }

    abstract public int getErrorCode();
}
