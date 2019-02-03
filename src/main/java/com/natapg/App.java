package com.natapg;

import com.natapg.db.MockedConnection;

public class App
{
    public static void main( String[] args )
    {
        MockedConnection c = MockedConnection.getInstance();
        c.connect();
        c.close();
    }
}
