package com.company;

import Jaxb.*;
import Server.*;

//main, pradzioj uzkomentavau klient/serva, nes noriu kad pradziai isvis konvertuotu, paskui gal aisku
//iskils problemu ir su servais ir klient bet krc bybys zino
public class Main
{
    public static void main(String[] args)
    {
/*        Client obj2 = new Client();
        Server obj = new Server();

        obj.start();
        obj2.start();*/


        Jaxb obj3 = new Jaxb();

        obj3.marshall();
        obj3.unmarshall();
    }
}
