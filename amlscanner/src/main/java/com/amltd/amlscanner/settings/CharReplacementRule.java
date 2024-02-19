package com.amltd.amlscanner.settings;


class CharReplacementRule {
    public String CharToReplace;
    public String ReplaceWith;

    /**
     * Constructs a character replacement rule for incoming barcode data.
     * Restricted to single character strings and 2 digit hex code values.
     * @param charToReplace The character or 2 digit hex code to be replaced in the rule.
     * @param replaceWith The character or 2 digit hex code to use for replacement in the rule.
     * @throws Exception Throws Exception if charToReplace parameter is null or if either parameter is not a single character or 2 digit hex code string.
     */
    public CharReplacementRule(String charToReplace, String replaceWith) throws Exception {
        if (replaceWith == null)
            replaceWith = "";
        if (charToReplace == null)
            throw new NullPointerException("Parameter \"charToReplace\" cannot be null.");
        if (charToReplace.length() > 2)
            throw new ReplacementRuleFormatException("Parameter \"charToReplace\" must be a single character or 2 digit hex code string.");
        if (replaceWith.length() > 2)
            throw new ReplacementRuleFormatException("Parameter \"replaceWith\" cannot be longer than 2 characters.");

        this.CharToReplace = charToReplace;
        this.ReplaceWith = replaceWith;
    }

    /**
     * Gets the character to be replaced in the character replacement rule.
     * @return The character to be replaced in the rule or null if no value exists.
     */
    public String getCharToReplace() {
        return CharToReplace;
    }

    /**
     * Sets the character to be replaced in the character replacement rule.
     * @param charToReplace The character to be replaced in the rule. Must be a single character or 2 digit hex code string.
     * @throws Exception Throws Exception if charToReplace parameter is null or is not a single character or 2 digit hex code string.
     */
    public void setCharToReplace(String charToReplace) throws Exception {
        if (charToReplace == null)
            throw new NullPointerException("Parameter \"charToReplace\" cannot be null.");
        if (charToReplace.length() > 2)
            throw new ReplacementRuleFormatException("Parameter \"charToReplace\" must be a single character or 2 digit hex code string.");
        CharToReplace = charToReplace;
    }

    /**
     * Gets the replacement character in the character replacement rule.
     * @return The character to use for replacement in the rule or null if no value exists.
     */
    public String getReplaceWith() {
        return ReplaceWith;
    }

    /**
     * Sets the replacement character in the character replacement rule.
     * @param replaceWith The replacement character in the rule. Must be null, a single character, or 2 digit hex code string.
     * @throws Exception Throws Exception if replaceWith parameter is null or is not a single character or 2 digit hex code string.
     */
    public void setReplaceWith(String replaceWith) throws Exception {
        if (replaceWith == null)
            replaceWith = "";
        if (replaceWith.length() > 2)
            throw new ReplacementRuleFormatException("Parameter \"replaceWith\" cannot be longer than 2 characters.");
        ReplaceWith = replaceWith;
    }
}
