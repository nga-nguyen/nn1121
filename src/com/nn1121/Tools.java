package com.nn1121;

public class Tools {
    public String toolType, toolBrand, toolCode;

    public static final String TOOL_TYPE_LADDER = "Ladder";
    public static final String TOOL_TYPE_CHAINSAW = "Chainsaw";
    public static final String TOOL_TYPE_JACKHAMMER = "Jackhammer";

    public static final String TOOL_BRAND_WERNER = "Werner";
    public static final String TOOL_BRAND_STIHL = "Stihl";
    public static final String TOOL_BRAND_RIDGID = "Ridgid";
    public static final String TOOL_BRAND_DEWALT = "DeWalt";

    public static final String TOOL_CODE_LADW = "LADW";
    public static final String TOOL_CODE_CHNS = "CHNS";
    public static final String TOOL_CODE_JAKR = "JAKR";
    public static final String TOOL_CODE_JAKD = "JAKD";

    public Tools (String toolCode) {
        this.toolCode = toolCode;

        if (toolCode != null) {
            switch (this.getToolCode()) {
                case TOOL_CODE_LADW:
                    this.toolType = TOOL_TYPE_LADDER;
                    this.toolBrand = TOOL_BRAND_WERNER;
                    break;
                case TOOL_CODE_CHNS:
                    this.toolType = TOOL_TYPE_CHAINSAW;
                    this.toolBrand = TOOL_BRAND_STIHL;
                    break;
                case TOOL_CODE_JAKR:
                    this.toolType = TOOL_TYPE_JACKHAMMER;
                    this.toolBrand = TOOL_BRAND_RIDGID;
                    break;
                case TOOL_CODE_JAKD:
                    this.toolType = TOOL_TYPE_JACKHAMMER;
                    this.toolBrand = TOOL_BRAND_DEWALT;
                    break;
            }
        }
    }

    public String getToolType() {
        return toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public void setToolCode(String toolCode) { this.toolCode = toolCode; }
}
