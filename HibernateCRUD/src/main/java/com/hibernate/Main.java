package com.hibernate;


import com.hibernate.queries.Queries;

public class Main
{
    public static void main(String[] args) {

        Queries.CREATE_CITY();
        Queries.UPDATE_CITY();
        Queries.GET_CITIES();
        Queries.DELETE_CITY();

    }
}
