package org.example;

import org.example.collect.Collector;
import org.example.config.Configuration;
import org.example.flaghandler.factory.*;
import org.example.flaghandler.handler.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Collector collector = new Collector(args);
    }
}