package main.driver;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    List<Location> locations;

    public Data() {
        locations = new ArrayList<>();
    }

    public void init(String fileName, char separator){
        try {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(separator)
                    .withIgnoreQuotations(true)
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
                    .withCSVParser(parser)
                    .build();

            String[] line;
            int iterator = 0;
            while ((line = csvReader.readNext()) != null){
                System.out.println(iterator + " ...");
                if(line[0].isEmpty())
                    continue;
                float x = Float.parseFloat(line[0].replace(',', '.'));
                float y = Float.parseFloat(line[1].replace(',', '.'));
                locations.add(new Location(x, y, line[2], line[3],line[4], line[5]));
                iterator++;
            }
            System.out.println("Reading complete! "+iterator + " Locations was found.");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public Location getLocationByIndex(int i){
        return locations.get(i);
    }

    public int size(){
        return locations.size();
    }

    public class Location{
        private float x;
        private float y;
        private String type;
        private String subType;
        private String name;
        private String address;

        public Location(float x, float y, String type, String subType, String name, String address) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.subType = subType;
            this.name = name;
            this.address = address;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSubType() {
            return subType;
        }

        public void setSubType(String subType) {
            this.subType = subType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    ", type='" + type + '\'' +
                    ", subType='" + subType + '\'' +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }
}
