package com.omotyliu;

import com.omotyliu.domain.Fact;
import com.omotyliu.domain.Operator;
import org.apache.commons.lang3.StringUtils;

public class Util
{

    public static boolean isFact(String rowFact)
    {
        return rowFact != null && StringUtils.isAlpha(rowFact) && rowFact.length() == 1;
    }

    public static boolean isOperator(String rowFact)
    {
        return Operator.knownOperators.contains(rowFact);
    }


}
