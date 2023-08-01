import models.*;
import service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Coffee dispenser!");
        Service service = new Service();
        service.instantiateMachine();
    }
}