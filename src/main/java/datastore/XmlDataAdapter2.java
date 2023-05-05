package datastore;

import java.io.*;
import java.util.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

public class XmlDataAdapter2 implements DataAdapter {
    
    @XmlRootElement(name = "data")
    @XmlSeeAlso({Employee.class, Manager.class})
    static class DataWrapper {
        @XmlElement(name = "item")
        List<Object> items;
        public DataWrapper() {}
        public DataWrapper(List<Object> items) {
            this.items = items;
        }
    }

    @Override
    public void saveData(String path, List<?> data) throws IOException, JAXBException {
        DataWrapper wrapper = new DataWrapper(new ArrayList<>(data));
        try (OutputStream os = new FileOutputStream(path)) {
            JAXBContext context = JAXBContext.newInstance(DataWrapper.class, Employee.class, Manager.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, os);
        }
    }

    @Override
    public List<?> loadData(String path) throws IOException, ClassNotFoundException, JAXBException {
        try (InputStream is = new FileInputStream(path)) {
            JAXBContext context = JAXBContext.newInstance(DataWrapper.class, Employee.class, Manager.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            DataWrapper wrapper = (DataWrapper) unmarshaller.unmarshal(is);
            return wrapper.items;
        }
    }
}

