package com.nymble.travelagency.Exception;

import org.springframework.beans.factory.annotation.Autowired;

public class UserDefinedException extends Exception
{
    @Autowired
    public UserDefinedException(String str)
    {
        super(str);
    }
}

