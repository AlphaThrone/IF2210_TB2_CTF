package main.DataStoreTest2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;

import main.DataStoreTest2.CustomerStatus.Customer;

public class Main6 {
    public static void main(String[] args) throws IOException, PropertyException, JAXBException, ClassNotFoundException {
        // Create some test data
        List<Customer> people = new ArrayList<>();
        people.add(new Customer(19));
        people.add(new Customer(18));

        // Save the test data to an XML file
        DataAdapter adapter = new XmlDataAdapter();
        adapter.saveData("people.xml", people);

        System.out.println("Save success");

        // Load the test data from the XML file
        // List<?> loadedData = adapter.loadData("people.xml");
        // List<Person> loadedPeople = new ArrayList<>();
        // System.out.println(loadedPeople);
        // System.out.println(loadedData);
        // for (Object obj : loadedData) {
        //     loadedPeople.add((Person) ((Object)obj));
        // }

        // // Print the loaded data to verify that it matches the saved data
        // for (Person person : loadedPeople) {
        //     System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
        // }
    }
}