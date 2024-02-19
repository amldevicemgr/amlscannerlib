package com.amltd.amlscanner.settings;

class ReplacementRuleFormatException extends Exception {
    /**
     * Constructs an empty replacement rule format exception.
     */
    public ReplacementRuleFormatException() {}

    /**
     * Constructs a replacement rule format exception.
     * @param message The message that is return to the getMessage() call on the Exception.
     */
    public ReplacementRuleFormatException(String message)
    {
        super(message);
    }
}
