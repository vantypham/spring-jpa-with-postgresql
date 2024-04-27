package com.test.springjpawithpostgresql.search;

public enum SearchOperationEnum {
    CONTAINS, DOES_NOT_CONTAINS,
    EQUAL, NOT_EQUAL,
    BEGIN_WITH, DOES_NOT_BEGIN_WITH,
    ENDS_WITH, DOES_NOT_END_WITH,
    NUL, NOT_NUL,
    GREATER_THAN, GREATER_THAN_EQUAL,
    LESS_THAN, LESS_THAN_EQUAL,
    ANY, ALL;
    public static final String[] SIMPLE_OPERATION_SET = {
            "cn", "nc",
            "eq", "ne",
            "bw", "bn",
            "ew", "en",
            "nu", "nn",
            "gt", "ge",
            "lt", "le"
    };
    public static final SearchOperationEnum getDataOption(final String option) {
        switch (option) {
            case "all": return ALL;
            case "any": return ANY;
            default: return null;
        }
    }
    public static SearchOperationEnum getSimpleOperation(final String simple) {
        switch (simple) {
            case "cn": return CONTAINS;
            case "nc": return DOES_NOT_CONTAINS;
            case "eq": return EQUAL;
            case "ne": return NOT_EQUAL;
            //TODO
            default : return null;
        }
    }
}
